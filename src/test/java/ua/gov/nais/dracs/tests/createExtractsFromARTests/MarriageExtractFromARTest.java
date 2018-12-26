package ua.gov.nais.dracs.tests.createExtractsFromARTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.pages.register.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.register.actRecordsTab.acts.marriagePage.MarriagePage;
import ua.gov.nais.dracs.pages.register.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.register.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.register.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.register.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;
import ua.gov.nais.dracs.util.PropertiesFileReader;

import java.io.IOException;

public class MarriageExtractFromARTest extends MainTest {
    /**
     * test data for input
     */
    private final String ROLE_FIANCE = PropertiesFileReader.getPropValues("fiance");

    private final String FIANCE_SURNAME = PropertiesFileReader.getPropValues("fiance-surname");
    private final String FIANCE_NAME = PropertiesFileReader.getPropValues("fiance-name");
    private final String FIANCE_FATHER_NAME = PropertiesFileReader.getPropValues("fiance-father-name");
    /**
     * variables
     */
    private ActRecordsTab actRecordsTab;
    private MarriagePage marriagePage;
    private ExtendSearch extendSearch;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPage extractPage;
    private ExtractPrint extractPrint;

    public MarriageExtractFromARTest() throws IOException {
    }

    @Test
    public void marriageExtractFromARTest(){
        ActRecord act = new ActRecord();
        actRecordsTab = mainPage.openActRecordsTab();
        marriagePage = actRecordsTab.selectMarriage();
        extendSearch = marriagePage.openExtendSearchModalWindow();
        searchByPersonRibbon = extendSearch.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_FIANCE);
        searchByPersonRibbon.enterPersonInformation(
                FIANCE_SURNAME,
                FIANCE_NAME,
                FIANCE_FATHER_NAME
        );
        extendSearch.clickExtFindButton();
        marriagePage.selectSearchResult(
                FIANCE_SURNAME,
                FIANCE_NAME,
                FIANCE_FATHER_NAME
        );
        extractPage = marriagePage.clickCreateExtract();
        extractPage.typeReason("само вийшло");
        extractPage.generatePreview();
        extractPrint = extractPage.generateExtract();
        Assert.assertTrue(extractPrint.printExtract("marriage-from-ar", act.getActNumber()));
    }

}
