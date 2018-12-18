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

public class BirthExtractTest extends MainTest {
    /**
     * test data for input
     */
    private final String CHILD_ACT_RECORD = PropertiesFileReader.getPropValues("birth-act-record");
    private final String EXTRACT_TYPE = PropertiesFileReader.getPropValues("extract-type-birth");
    private final String ROLE_CHILD = PropertiesFileReader.getPropValues("child");

    private final String CHILD_SURNAME = PropertiesFileReader.getPropValues("child-surname");
    private final String CHILD_NAME = PropertiesFileReader.getPropValues("child-name");
    private final String CHILD_FATHER_NAME = PropertiesFileReader.getPropValues("child-father-name");
    /**
     * variables
     */
    private ExtractPage extractPage;
    private ExtendSearch search;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPrint extractPrint;

    public BirthExtractTest() throws IOException {
    }

    @Test
    public void birthExtractTest() {
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
                CHILD_SURNAME,
                CHILD_NAME,
                CHILD_FATHER_NAME
        );
        search.clickFindButton();
        search.clickAcceptButton();
        extractPage.generatePreview();
        extractPrint = extractPage.generateExtract();
        Assert.assertTrue(extractPrint.printExtract("birth", act.getActNumber()));
    }
}
