# CMDI2JSONLD

CMDI2JSONLD is a tool to transform CMDI files to JSON-LD/RDF.

## How to build

The `pom.xml` file contains configuration for building a `jar` file using the Apache Maven Assembly Plugin.

## How to use

The tool can be run from the command line using the following arguments:

- `-d`: input directory of CMDI data
- `-f`: input CMDI (instead of directory)
- `-o`: output file/directory
- `-p`: installation path for python 3
- `-b`: BioDataNER tool directory
- `-c`: BioDataNER cache file
- `-s`: BioDataNER specification file
- `-l`: BioDataNER namespace tag list file
- `-i`: BioDataNER authoritative ID tag name

Example Usage:

`java -jar -d "data/" -o "output/"`

`java -jar -f "CMDI.xml" -o "CMDI_JSONLD.jsonld"`

Note: The BioDataNER tool can be found here: https://github.com/SfS-ASCL/BiodataNER

CMDI2JSONLD only supports the BioDataNER tool when transforming entire directories. It will execute the `update_cmdi.py`. When run under Windows 10, the console running Python from within Java does not support Unicode characters. If a CMDI uses special characters, the BioDataNER tool might crash. To prevent this, one can use the Windows Subsystem for Linux.

It is recommended to execute the tool inside its own directory. Upon execution it will create the directory `CMDI_Profiles` where it will download the corresponding CMDI profile schemata.

## Project Structure

XSLT 3.0 Transformation stylesheets (found under `src/main/resources`):

`mapping2json.xsl`: Stylesheet transforming CMDI to JSON-LD using the mapping system

`clean_cmdi.xsl`: Preprocessing a CMDI before transforming it to JSON.

`cmdi2json.xsl`: Stylesheet that will transform a preprocessed CMDI into a JSON representation

`chain_xsl.xsl`: The main stylesheet, executes templates from the stylesheets above.


Mapping:

`mapping.xml`: Contains mappings to transform CMDI into JSON-LD using Schema.org vocabulary. How to use it is explained inside the thesis.
