import cmdiTransformation.CMDICast;
import net.sf.saxon.s9api.SaxonApiException;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


class CMDICastTest {

    CMDICast cmdiCast;
    ClassLoader classLoader;
    JSONParser parser;

    @BeforeEach
    void setUp() {
        cmdiCast = new CMDICast();
        classLoader = getClass().getClassLoader();
        parser = new JSONParser();
    }

    @org.junit.jupiter.api.Test
    void transformCMDI4() throws XPathExpressionException, IOException, ParserConfigurationException, SaxonApiException, SAXException {
        cmdiCast.transformCMDI(classLoader.getResource("CMDIs/CMDI_(4).xml").getFile(), "Output/CMDI_(4)_test.jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/CMDI_(4)_test.jsonld"));
    }

    @org.junit.jupiter.api.Test
    void transformCMDIToVALIDJSON() throws XPathExpressionException, IOException, ParserConfigurationException, SaxonApiException, SAXException {
        cmdiCast.transformCMDI(classLoader.getResource("CMDIs/CMDI_(4).xml").getFile(), "Output/CMDI_(4)_test.jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/CMDI_(4)_test.jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("CMDIs/CMDI_(432).xml").getFile(), "Output/CMDI_(432)_test.jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/CMDI_(432)_test.jsonld"));

        //cmdiCast.transformCMDI(classLoader.getResource("CMDIs/CMDI_(301).xml").getFile(), "Output/CMDI_(301)_test.jsonld");
        //Assertions.assertTrue(cmdiCast.isValidJson("Output/CMDI_(301)_test.jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("CMDIs/CMDI_(512).xml").getFile(), "Output/CMDI_(512)_test.jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/CMDI_(512)_test.jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("CMDIs/CMDI_(224).xml").getFile(), "Output/CMDI_(224)_test.jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/CMDI_(224)_test.jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/clarin.eucr1p_1336550377513_(1).xml").getFile(), "Output/clarin.eucr1p_1336550377513_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/clarin.eucr1p_1336550377513_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/clarin.eucr1p_1336550377513_(2).xml").getFile(), "Output/clarin.eucr1p_1336550377513_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/clarin.eucr1p_1336550377513_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/clarin.eucr1p_1336550377513_(3).xml").getFile(), "Output/clarin.eucr1p_1336550377513_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/clarin.eucr1p_1336550377513_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/SpokenCorpusProfile_(1).xml").getFile(), "Output/SpokenCorpusProfile_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/SpokenCorpusProfile_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/lat-corpus_(1).xml").getFile(), "Output/lat-corpus_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/lat-corpus_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/lat-corpus_(2).xml").getFile(), "Output/lat-corpus_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/lat-corpus_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/lat-corpus_(3).xml").getFile(), "Output/lat-corpus_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/lat-corpus_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/lat-corpus_(4).xml").getFile(), "Output/lat-corpus_(4).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/lat-corpus_(4).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/IDSAGD_Speaker_(1).xml").getFile(), "Output/IDSAGD_Speaker_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/IDSAGD_Speaker_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/IDSAGD_Speaker_(2).xml").getFile(), "Output/IDSAGD_Speaker_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/IDSAGD_Speaker_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/IDSAGD_Speaker_(3).xml").getFile(), "Output/IDSAGD_Speaker_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/IDSAGD_Speaker_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/IDSAGD_Event_(1).xml").getFile(), "Output/IDSAGD_Event_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/IDSAGD_Event_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/IDSAGD_Event_(2).xml").getFile(), "Output/IDSAGD_Event_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/IDSAGD_Event_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/IDSAGD_Event_(3).xml").getFile(), "Output/IDSAGD_Event_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/IDSAGD_Event_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/collection_(1).xml").getFile(), "Output/collection_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/collection_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/collection_(2).xml").getFile(), "Output/collection_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/collection_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/collection_(3).xml").getFile(), "Output/collection_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/collection_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/CommunicationProfile_(1).xml").getFile(), "Output/CommunicationProfile_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/CommunicationProfile_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/CommunicationProfile_(2).xml").getFile(), "Output/CommunicationProfile_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/CommunicationProfile_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/CommunicationProfile_(3).xml").getFile(), "Output/CommunicationProfile_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/CommunicationProfile_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/lat-corpus_(1).xml").getFile(), "Output/lat-corpus_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/lat-corpus_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/lat-corpus_(2).xml").getFile(), "Output/lat-corpus_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/lat-corpus_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/lat-corpus_(3).xml").getFile(), "Output/lat-corpus_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/lat-corpus_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/LINDAT_CLARIN_(1).xml").getFile(), "Output/LINDAT_CLARIN_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/LINDAT_CLARIN_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/LINDAT_CLARIN_(2).xml").getFile(), "Output/LINDAT_CLARIN_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/LINDAT_CLARIN_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/LINDAT_CLARIN_(3).xml").getFile(), "Output/LINDAT_CLARIN_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/LINDAT_CLARIN_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/VALID_(1).xml").getFile(), "Output/VALID_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/VALID_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/VALID_(2).xml").getFile(), "Output/VALID_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/VALID_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/VALID_(3).xml").getFile(), "Output/VALID_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/VALID_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/SL_IPROSLA_(1).xml").getFile(), "Output/SL_IPROSLA_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/SL_IPROSLA_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/SL_IPROSLA_(2).xml").getFile(), "Output/SL_IPROSLA_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/VALID_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/SL_IPROSLA_(3).xml").getFile(), "Output/SL_IPROSLA_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/SL_IPROSLA_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/resourceInfo_(1).xml").getFile(), "Output/resourceInfo_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/resourceInfo_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/resourceInfo_(2).xml").getFile(), "Output/resourceInfo_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/resourceInfo_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/resourceInfo_(3).xml").getFile(), "Output/resourceInfo_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/resourceInfo_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/singlePaperPackage_(1).xml").getFile(), "Output/singlePaperPackage_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/singlePaperPackage_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/singlePaperPackage_(2).xml").getFile(), "Output/singlePaperPackage_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/resourceInfo_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/singlePaperPackage_(3).xml").getFile(), "Output/singlePaperPackage_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/singlePaperPackage_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/CEDIFOR_TextCorpus_(1).xml").getFile(), "Output/CEDIFOR_TextCorpus_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/CEDIFOR_TextCorpus_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/CEDIFOR_TextCorpus_(2).xml").getFile(), "Output/CEDIFOR_TextCorpus_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/CEDIFOR_TextCorpus_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/CEDIFOR_TextCorpus_(3).xml").getFile(), "Output/CEDIFOR_TextCorpus_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/CEDIFOR_TextCorpus_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/LCC_CorpusProfile_(1).xml").getFile(), "Output/LCC_CorpusProfile_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/LCC_CorpusProfile_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/LCC_CorpusProfile_(2).xml").getFile(), "Output/LCC_CorpusProfile_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/LCC_CorpusProfile_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/LCC_CorpusProfile_(3).xml").getFile(), "Output/LCC_CorpusProfile_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/LCC_CorpusProfile_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/media_corpus_profile_(1).xml").getFile(), "Output/media_corpus_profile_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/media_corpus_profile_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/media_corpus_profile_(2).xml").getFile(), "Output/media_corpus_profile_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/media_corpus_profile_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/media_corpus_profile_(3).xml").getFile(), "Output/media_corpus_profile_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/media_corpus_profile_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/DGDCorpus_(1).xml").getFile(), "Output/DGDCorpus_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/DGDCorpus_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/DGDCorpus_(2).xml").getFile(), "Output/DGDCorpus_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/DGDCorpus_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/DGDCorpus_(3).xml").getFile(), "Output/DGDCorpus_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/DGDCorpus_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/wnd_subcollection_core_data_(1).xml").getFile(), "Output/wnd_subcollection_core_data_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/wnd_subcollection_core_data_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/wnd_subcollection_core_data_(2).xml").getFile(), "Output/wnd_subcollection_core_data_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/wnd_subcollection_core_data_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/wnd_subcollection_core_data_(3).xml").getFile(), "Output/wnd_subcollection_core_data_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/wnd_subcollection_core_data_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/AnnotatedCorpusProfile_DLU_(1).xml").getFile(), "Output/AnnotatedCorpusProfile_DLU_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/AnnotatedCorpusProfile_DLU_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/AnnotatedCorpusProfile_DLU_(2).xml").getFile(), "Output/AnnotatedCorpusProfile_DLU_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/AnnotatedCorpusProfile_DLU_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/AnnotatedCorpusProfile_DLU_(3).xml").getFile(), "Output/AnnotatedCorpusProfile_DLU_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/AnnotatedCorpusProfile_DLU_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/LexicalResourceProfile_DLU_(1).xml").getFile(), "Output/LexicalResourceProfile_DLU_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/LexicalResourceProfile_DLU_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/LexicalResourceProfile_DLU_(2).xml").getFile(), "Output/LexicalResourceProfile_DLU_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/LexicalResourceProfile_DLU_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/LexicalResourceProfile_DLU_(3).xml").getFile(), "Output/LexicalResourceProfile_DLU_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/LexicalResourceProfile_DLU_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/BatImageBundle_(1).xml").getFile(), "Output/BatImageBundle_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/BatImageBundle_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/BatImageBundle_(2).xml").getFile(), "Output/BatImageBundle_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/BatImageBundle_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/BatImageBundle_(3).xml").getFile(), "Output/BatImageBundle_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/BatImageBundle_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/SpeechCorpus_DLU_(1).xml").getFile(), "Output/SpeechCorpus_DLU_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/SpeechCorpus_DLU_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/SpeechCorpus_DLU_(2).xml").getFile(), "Output/SpeechCorpus_DLU_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/SpeechCorpus_DLU_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/SpeechCorpus_DLU_(3).xml").getFile(), "Output/SpeechCorpus_DLU_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/SpeechCorpus_DLU_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/IDSAGD_Corpus_(1).xml").getFile(), "Output/IDSAGD_Corpus_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/SpeechCorpus_DLU_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/IDSAGD_Corpus_(2).xml").getFile(), "Output/IDSAGD_Corpus_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/SpeechCorpus_DLU_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/IDSAGD_Corpus_(3).xml").getFile(), "Output/IDSAGD_Corpus_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/IDSAGD_Corpus_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/Framework_(1).xml").getFile(), "Output/Framework_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/Framework_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/Framework_(2).xml").getFile(), "Output/Framework_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/Framework_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/Framework_(3).xml").getFile(), "Output/Framework_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/Framework_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/BilingualDictionaryProfile_DLU_(1).xml").getFile(), "Output/BilingualDictionaryProfile_DLU_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/BilingualDictionaryProfile_DLU_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/BilingualDictionaryProfile_DLU_(2).xml").getFile(), "Output/BilingualDictionaryProfile_DLU_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/BilingualDictionaryProfile_DLU_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/BilingualDictionaryProfile_DLU_(3).xml").getFile(), "Output/BilingualDictionaryProfile_DLU_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/BilingualDictionaryProfile_DLU_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/TreebankProfile_DLU_(1).xml").getFile(), "Output/TreebankProfile_DLU_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/TreebankProfile_DLU_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/TreebankProfile_DLU_(2).xml").getFile(), "Output/TreebankProfile_DLU_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/TreebankProfile_DLU_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/TreebankProfile_DLU_(3).xml").getFile(), "Output/TreebankProfile_DLU_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/TreebankProfile_DLU_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/LexicalResourceProfile_DLU_2_(2).xml").getFile(), "Output/LexicalResourceProfile_DLU_2_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/TreebankProfile_DLU_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/FrequencyListProfile_DLU_(1).xml").getFile(), "Output/FrequencyListProfile_DLU_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/FrequencyListProfile_DLU_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/talkbank_license_session_(1).xml").getFile(), "Output/talkbank_license_session_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/talkbank_license_session_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/talkbank_license_session_(2).xml").getFile(), "Output/talkbank_license_session_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/talkbank_license_session_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/talkbank_license_session_(3).xml").getFile(), "Output/talkbank_license_session_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/talkbank_license_session_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/DGDEvent_(1).xml").getFile(), "Output/DGDEvent_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/DGDEvent_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/DGDEvent_(2).xml").getFile(), "Output/DGDEvent_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/DGDEvent_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/DGDEvent_(3).xml").getFile(), "Output/DGDEvent_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/DGDEvent_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/OLAC-DcmiTerms_(4).xml").getFile(), "Output/OLAC-DcmiTerms_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/talkbank_license_session_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/OLAC-DcmiTerms_(1).xml").getFile(), "Output/OLAC-DcmiTerms_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/OLAC-DcmiTerms_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/OLAC-DcmiTerms_(2).xml").getFile(), "Output/OLAC-DcmiTerms_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/OLAC-DcmiTerms_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/OLAC-DcmiTerms_(3).xml").getFile(), "Output/OLAC-DcmiTerms_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/OLAC-DcmiTerms_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/OLAC_DcmiTerms_ref_(1).xml").getFile(), "Output/OLAC_DcmiTerms_ref_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/OLAC_DcmiTerms_ref_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/OLAC_DcmiTerms_ref_(2).xml").getFile(), "Output/OLAC_DcmiTerms_ref_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/OLAC_DcmiTerms_ref_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/OLAC_DcmiTerms_ref_(3).xml").getFile(), "Output/OLAC_DcmiTerms_ref_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/OLAC_DcmiTerms_ref_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/MPI_Bundle_(1).xml").getFile(), "Output/MPI_Bundle_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/MPI_Bundle_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/MPI_Bundle_(2).xml").getFile(), "Output/MPI_Bundle_(2).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/MPI_Bundle_(2).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/MPI_Bundle_(3).xml").getFile(), "Output/MPI_Bundle_(3).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/MPI_Bundle_(3).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/Communication_Transcript_(1).xml").getFile(), "Output/Communication_Transcript_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/Communication_Transcript_(1).jsonld"));

        cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/Communication_Recording_(1).xml").getFile(), "Output/Communication_Recording_(1).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/Communication_Recording_(1).jsonld"));

    } //35

    @org.junit.jupiter.api.Test
    void transformCMDIToVALIDJSONCURRENT() throws XPathExpressionException, IOException, ParserConfigurationException, SaxonApiException, SAXException {
        String name = "Communication_Recording_";

        cmdiCast.transformCMDI(classLoader.getResource("CMDIs/CMDI_(86).xml").getFile(), "Output/CMDI_(85).jsonld");
        Assertions.assertTrue(cmdiCast.isValidJson("Output/CMDI_(85).jsonld"));

        //cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/" + name + "(2).xml").getFile(), "Output/" + name + "(2).jsonld");
        //Assertions.assertTrue(cmdiCast.isValidJson("Output/" + name + "(2).jsonld"));

        //cmdiCast.transformCMDI(classLoader.getResource("OtherCMDIs/" + name + "(3).xml").getFile(), "Output/" + name + "(3).jsonld");
        //Assertions.assertTrue(cmdiCast.isValidJson("Output/" + name + "(3).jsonld"));
    }

    @org.junit.jupiter.api.Test
    void transformCMDIAll() throws XPathExpressionException, IOException, ParserConfigurationException, SaxonApiException, SAXException, URISyntaxException {

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource("updated_cmdis");
        String path = url.getPath();
        File[] cmdis =  new File(path).listFiles();

        for (File f : cmdis) {
            String filename = f.getName();
            String outputName = "Output/" + filename.split("\\.")[0] + "_test.jsonld";

            cmdiCast.transformCMDI(f.getAbsolutePath(), outputName);
            Assertions.assertTrue(cmdiCast.isValidJson(outputName));
            System.out.println("Successful: " + filename);

        }

//        url = loader.getResource("OtherCMDIs");
//        path = url.getPath();
//        cmdis =  new File(path).listFiles();

//        for (File f : cmdis) {
//            String filename = f.getName();
//            String outputName = "Output/" + filename.split("\\.")[0] + "_test.jsonld";
//
//            cmdiCast.transformCMDI(f.getAbsolutePath(), outputName);
//            Assertions.assertTrue(cmdiCast.isValidJson(outputName));
//            System.out.println("Successful: " + filename);
//
//        }
    }
}