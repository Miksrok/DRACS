package ua.gov.nais.dracs.tests.createExtractsFromARTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.pages.register.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.register.actRecordsTab.acts.divorcePage.DivorcePage;
import ua.gov.nais.dracs.pages.register.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.register.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.register.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.register.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;
import ua.gov.nais.dracs.util.PropertiesFileReader;

import java.io.IOException;

public class DivorceExtractFromARTest extends MainTest {
    /**
     * test data for input
     */
    private final String ROLE_HUSBAND = PropertiesFileReader.getPropValues("husband");

    private final String HUSBAND_SURNAME = PropertiesFileReader.getPropValues("husband-surname");
    private final String HUSBAND_NAME = PropertiesFileReader.getPropValues("husband-name");
    private final String HUSBAND_FATHER_NAME = PropertiesFileReader.getPropValues("husband-father-name");
    /**
     * variables
     */
    private ActRecordsTab actRecordsTab;
    private DivorcePage divorcePage;
    private ExtendSearch extendSearch;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPage extractPage;
    private ExtractPrint extractPrint;

    public DivorceExtractFromARTest() throws IOException {
    }

    @Test
    public void divorceExtractFromARTest(){
        ActRecord act = new ActRecord();
        actRecordsTab = mainPage.openActRecordsTab();
        divorcePage = actRecordsTab.selectDivorce();
        extendSearch = divorcePage.openExtendSearchModalWindow();
        searchByPersonRibbon = extendSearch.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_HUSBAND);
        searchByPersonRibbon.enterPersonInformation(
                HUSBAND_SURNAME,
                HUSBAND_NAME ,
                HUSBAND_FATHER_NAME
        );
        extendSearch.clickExtFindButton();
        divorcePage.selectSearchResult(
                HUSBAND_SURNAME,
                HUSBAND_NAME ,
                HUSBAND_FATHER_NAME
        );
        extractPage = divorcePage.clickCreateExtract();
        extractPage.typeReason("само вийшло");
        extractPage.generatePreview();
        extractPrint = extractPage.generateExtract();
        Assert.assertTrue(extractPrint.printExtract("divorce-from-ar", act.getActNumber()));
    }

}
