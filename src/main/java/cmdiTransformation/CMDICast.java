package cmdiTransformation;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.sf.saxon.s9api.*;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class CMDICast
{
    /**
     * Test if a JSON(-LD) file is valid, well-formed JSON
     * @param filepath - The path to the JSON(-LD) file
     * @return true if JSON is valid
     */
    public boolean isValidJson(String filepath) {
        // Known errors: Does not check for unique key names (still valid JSON-LD)
        // Does not check for newline errors
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filepath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String json = contentBuilder.toString();

        try {
            new Gson().getAdapter(JsonElement.class).fromJson(json);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    // Downloads the corresponding CMDI Profile description, if not downloaded already
    private void checkCMDIProfile(String xmlFile) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        // extract handle from CMDI
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile("//*[local-name()='MdProfile']");

        String handle = expr.evaluate(doc);
        File outputFile = new File("CMDI_Profiles/" + handle.replaceAll(":", "") + ".xml");

        // only download Profile, if not downloaded yet
        if (!outputFile.isFile()) {
            String handleURL = "https://catalog.clarin.eu/ds/ComponentRegistry/rest/registry/1.x/profiles/" + handle + "/xml";
            FileUtils.copyURLToFile(new URL(handleURL), outputFile);
        }

    }


    /**
     * Transform a CMDI to JSON-LD
     * @param xmlFile - Filepath to CMDI
     * @param jsonld - Save Location for JSON-LD file
     * @throws SaxonApiException
     * @throws IOException
     * @throws XPathExpressionException
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    public void transformCMDI(String xmlFile, String jsonld) throws SaxonApiException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
        this.checkCMDIProfile(xmlFile);
        System.out.println("Transform: " + xmlFile + " to: " + jsonld);
        Processor processor = new Processor(false);
        XsltCompiler compiler = processor.newXsltCompiler();
        compiler.setURIResolver(new ClasspathResourceURIResolver());
        XsltExecutable stylesheet = compiler.compile(new StreamSource(this.getClass().getClassLoader().getResourceAsStream("chain_xsl.xsl")));

        Serializer out = processor.newSerializer(new File(jsonld));
        out.setOutputProperty(Serializer.Property.METHOD, "text");
        Xslt30Transformer transformer = stylesheet.load30();
        transformer.transform(new StreamSource(new File(xmlFile)), out);
    }


    /**
     * Transforms every CMDI in directory to JSON-LD
     * @param files - Path to directory
     * @param output - Output directory
     * @throws IOException
     */
    public void transformDirectory(String files, String output) throws IOException {
        Path dir = Paths.get(files);
        Files.walk(dir).forEach(path -> {
            if (!path.toFile().isDirectory()) {
                try {
                    this.transformCMDI(path.toAbsolutePath().toString(), (output + path.getFileName().toString().replaceAll("\\.xml", "\\.jsonld")));
                    // System.out.println("Transformed: " + path.getFileName().toString().replaceAll("\\.xml", ".jsonld"));
                } catch (SaxonApiException | IOException | XPathExpressionException | ParserConfigurationException | SAXException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Adds AuthoriativeIDs to every CMDI in directory (using BioDataNer) and transforms to JSON-LD
     * @param files - Path to directory
     * @param output - Output directory
     * @param python - Python3 installation location
     * @param nerDir - BioDataNER location
     * @param cache - BioDaterNER cache location
     * @param specification - BioDaterNER specification location
     * @param namespaceTagList - BioDaterNER namespaceTagList location
     * @param authTag - BioDaterNER Authoritative ID
     * @throws IOException
     */
    public void transformDirectory(String files, String output, String python, String nerDir, String cache,
                                    String specification, String namespaceTagList, String authTag) throws IOException {
        // Not working under Windows due to encoding issues (when ran under Java, Python tries to use the Windows coding page.)
        // I recommend using the Linux Subsystem, instead of trying to fix it.
        Process proc = Runtime.getRuntime().exec(new String[]{python, nerDir + "/python_scripts/update_cmdi.py",
                cache, files, specification, namespaceTagList, authTag, "updated_cmdis"});

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(proc.getInputStream(), StandardCharsets.UTF_8));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(proc.getErrorStream(), StandardCharsets.UTF_8));


        System.out.println("BioDataNER script starting:\n");
        // Read the output from Python
        String s;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

        // Read any errors from Python
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
        System.out.println("BioDataNER Finished\n\n");

        this.transformDirectory("updated_cmdis/", output);
    }


    public static void main(String[] args) throws IOException, SaxonApiException, XPathExpressionException, ParserConfigurationException, SAXException {
        CMDICast cmdiCast = new CMDICast();
        ArgumentParser parser = ArgumentParsers.newFor("cmdiTransformation.CMDICast").build()
                .defaultHelp(true)
                .description("Convert CMDI to JSON-LD/RDF");
        parser.addArgument("-d", "--dir")
                .dest("dir")
                .help("The path to the directory that contains the CMDI files to convert");
        parser.addArgument("-f", "--file")
                .dest("file")
                .help("Single CMDI file, instead of directory");
        parser.addArgument("-o", "--ouput")
                .dest("output")
                .help("The path for the JSON-LD/RDF files")
                .required(true);
        parser.addArgument("-p", "--python")
                .dest("python")
                .help("Path to Python3");
        parser.addArgument("-b", "--biodata")
                .dest("biodata")
                .help("BioData NER directory");
        parser.addArgument("-c", "--cache")
                .dest("cache")
                .help("Cache for BioData NER");
        parser.addArgument("-s", "--specification")
                .dest("specification")
                .help("Specification for BioData NER");
        parser.addArgument("-l", "--namespaceTagList")
                .dest("nsList")
                .help("Namespace tag list for BioData NER");
        parser.addArgument("-i", "--id")
                .dest("id")
                .help("AuthoritativeID Tag for BioData NER");

        Namespace ns = null;
        try {
            ns = parser.parseArgs(args);
        } catch (ArgumentParserException e) {
            parser.handleError(e);
            System.exit(1);
        }

        if (ns.get("file") != null) {
            cmdiCast.transformCMDI(ns.get("file"), ns.get("output"));
        }else {
            if (ns.get("python") == null) {
                cmdiCast.transformDirectory(ns.get("dir"), ns.get("output"));
            } else {
                cmdiCast.transformDirectory(ns.get("dir"), ns.get("output"), ns.get("python"), ns.get("biodata"), ns.get("cache"),
                        ns.get("specification"), ns.get("nsList"), ns.get("id"));
            }
        }

    }
}

// URI Resolver for XSL Files
class ClasspathResourceURIResolver implements URIResolver
{
    @Override
    public Source resolve(String href, String base) throws TransformerException {
        return new StreamSource(this.getClass().getClassLoader().getResourceAsStream(href));
    }
}
