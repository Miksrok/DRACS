package ua.gov.nais.dracs.tests.createExtractsAboutMissingActRecordsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.pages.register.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.register.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.register.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.register.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;
import ua.gov.nais.dracs.util.PropertiesFileReader;

import java.io.IOException;

public class BirthMissingARTest extends MainTest {
    /*
     * test data for input
     */
    private final String CHILD_ACT_RECORD = PropertiesFileReader.getPropValues("birth-act-record");
    private final String EXTRACT_TYPE = PropertiesFileReader.getPropValues("extract-type-birth");
    private final String ROLE_CHILD = PropertiesFileReader.getPropValues("child");

    private final String UNKNOWN_SURNAME = PropertiesFileReader.getPropValues("unknown-surname");
    private final String UNKNOWN_NAME = PropertiesFileReader.getPropValues("unknown-name");
    private final String UNKNOWN_FATHER_NAME = PropertiesFileReader.getPropValues("unknown-father-name");
    /*
     * variables
     */
    private ExtractPage extractPage;
    private ExtendSearch search;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPrint extractPrint;

    public BirthMissingARTest() throws IOException {
    }

    @Test
    public void birthMissingARTest(){
        ActRecord act = new ActRecord();
        extractPage = mainPage.openExtractTab();
        extractPage.createNewExtract();
        extractPage.selectActRecordType(CHILD_ACT_RECORD);
        extractPage.selectExtractType(EXTRACT_TYPE);
        extractPage.typeReason("випадково вийшло");
        search = extractPage.clickSearchButton();
        searchByPersonRibbon = search.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_CHILD);
        searchByPersonRibbon.enterPersonInformation(
                UNKNOWN_SURNAME,
                UNKNOWN_NAME,
                UNKNOWN_FATHER_NAME
        );
        search.clickFindButton();
        search.clickNoResultYesButton();
        extractPage.getExtractTypeName();
        extractPage.generatePreview();
        extractPrint = extractPage.generateExtract();
        Assert.assertTrue(extractPrint.printExtract("birth-miss", act.getActNumber()));
    }

}
