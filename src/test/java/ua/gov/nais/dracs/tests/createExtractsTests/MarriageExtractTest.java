package ua.gov.nais.dracs.tests.createExtractsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;
import ua.gov.nais.dracs.util.PropertiesFileReader;

import java.io.IOException;

public class MarriageExtractTest extends MainTest {

    private final String MARRIAGE_ACT_RECORD =  PropertiesFileReader.getPropValues("marriage-act-record");
    private final String EXTRACT_TYPE = PropertiesFileReader.getPropValues("extract-type-marriage");
    private final String ROLE_FIANCE = PropertiesFileReader.getPropValues("fiance");

    private final String FIANCE_SURNAME = PropertiesFileReader.getPropValues("fiance-surname");
    private final String FIANCE_NAME = PropertiesFileReader.getPropValues("fiance-name");
    private final String FIANCE_FATHER_NAME = PropertiesFileReader.getPropValues("fiance-father-name");

    private ExtractPage extractPage;
    private ExtendSearch search;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPrint extractPrint;

    public MarriageExtractTest() throws IOException {
    }

    @Test
    public void marriageExtractTest(){
        ActRecord act = new ActRecord();
        extractPage = mainPage.openExtractTab();
        extractPage.createNewExtract();
        extractPage.selectActRecordType(MARRIAGE_ACT_RECORD);
        extractPage.selectExtractType(EXTRACT_TYPE);
        extractPage.typeReason("випадково вийшло");
        search = extractPage.clickSearchButton();
        searchByPersonRibbon = search.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_FIANCE);
        searchByPersonRibbon.enterPersonInformation(
                FIANCE_SURNAME,
                FIANCE_NAME,
                FIANCE_FATHER_NAME
        );
        search.clickFindButton();
        search.clickAcceptButton();
        extractPage.generatePreview();
        extractPrint = extractPage.generateExtract();
        Assert.assertTrue(extractPrint.printExtract("marriage", act.getActNumber()));
    }

}
