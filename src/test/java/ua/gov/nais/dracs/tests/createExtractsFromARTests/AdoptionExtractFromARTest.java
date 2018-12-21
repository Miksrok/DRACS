package ua.gov.nais.dracs.tests.createExtractsFromARTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.adoptionPage.AdoptionPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.parenthoodPage.ParenthoodPage;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;
import ua.gov.nais.dracs.util.PropertiesFileReader;

import java.io.IOException;

public class AdoptionExtractFromARTest extends MainTest {

    /*
     * test data for input
     */
    private final String ROLE_CHILD = PropertiesFileReader.getPropValues("child-adoption");

    private final String CHILD_SURNAME = PropertiesFileReader.getPropValues("child-ad-surname");
    private final String CHILD_NAME = PropertiesFileReader.getPropValues("child-ad-name");
    private final String CHILD_FATHER_NAME = PropertiesFileReader.getPropValues("child-ad-father-name");
    /*
     * variables
     */
    private ActRecordsTab actRecordsTab;
    private AdoptionPage adoptionPage;
    private ExtendSearch extendSearch;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPage extractPage;
    private ExtractPrint extractPrint;

    protected AdoptionExtractFromARTest() throws IOException {
    }
    @Test
    public void parenthoodExtractFromARTest(){
        ActRecord act = new ActRecord();
        actRecordsTab = mainPage.openActRecordsTab();
        adoptionPage = actRecordsTab.selectAdoption();
        extendSearch = adoptionPage.openExtendSearchModalWindow();
        searchByPersonRibbon = extendSearch.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_CHILD);
        searchByPersonRibbon.enterPersonInformation(
                CHILD_SURNAME,
                CHILD_NAME,
                CHILD_FATHER_NAME
        );
        extendSearch.clickExtFindButton();
        adoptionPage.selectSearchResult(
                CHILD_SURNAME,
                CHILD_NAME,
                CHILD_FATHER_NAME
        );
        extractPage = adoptionPage.clickCreateExtract();
        extractPage.typeReason("само вийшло");
        extractPage.generatePreview();
        extractPrint = extractPage.generateExtract();
        Assert.assertTrue(extractPrint.printExtract("adoption-from-ar", act.getActNumber()));
    }

}
