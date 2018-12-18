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

public class DivorceExtractTest extends MainTest {

    private final String DIVORCE_ACT_RECORD = PropertiesFileReader.getPropValues("divorce-act-record");
    private final String EXTRACT_TYPE = PropertiesFileReader.getPropValues("extract-type-divorce");
    private final String ROLE_HUSBAND = PropertiesFileReader.getPropValues("husband");

    private final String HUSBAND_SURNAME = PropertiesFileReader.getPropValues("husband-surname");
    private final String HUSBAND_NAME = PropertiesFileReader.getPropValues("husband-name");
    private final String HUSBAND_FATHER_NAME = PropertiesFileReader.getPropValues("husband-father-name");

    private ExtractPage extractPage;
    private ExtendSearch search;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPrint extractPrint;

    public DivorceExtractTest() throws IOException {
    }

    @Test
    public void divorceExtractTest() {
        ActRecord act = new ActRecord();
        extractPage = mainPage.openExtractTab();
        extractPage.createNewExtract();
        extractPage.selectActRecordType(DIVORCE_ACT_RECORD);
        extractPage.selectExtractType(EXTRACT_TYPE);
        extractPage.typeReason("випадково вийшло");
        search = extractPage.clickSearchButton();
        searchByPersonRibbon = search.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_HUSBAND);
        searchByPersonRibbon.enterPersonInformation(
                HUSBAND_SURNAME,
                HUSBAND_NAME,
                HUSBAND_FATHER_NAME
        );
        search.clickFindButton();
        search.clickAcceptButton();
        extractPage.generatePreview();
        extractPrint = extractPage.generateExtract();
        Assert.assertTrue(extractPrint.printExtract("divorce", act.getActNumber()));
    }

}
