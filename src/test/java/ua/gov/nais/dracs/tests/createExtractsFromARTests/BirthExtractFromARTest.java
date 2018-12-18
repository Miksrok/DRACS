package ua.gov.nais.dracs.tests.createExtractsFromARTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPage;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;
import ua.gov.nais.dracs.util.PropertiesFileReader;

import java.io.IOException;

public class BirthExtractFromARTest  extends MainTest {
    /**
     * test data for input
     */
    private final String ROLE_CHILD = PropertiesFileReader.getPropValues("child");

    private final String CHILD_SURNAME = PropertiesFileReader.getPropValues("child-surname");
    private final String CHILD_NAME = PropertiesFileReader.getPropValues("child-name");
    private final String CHILD_FATHER_NAME = PropertiesFileReader.getPropValues("child-father-name");
    /**
     * variables
     */
    private ActRecordsTab actRecordsTab;
    private BirthPage birthPage;
    private ExtendSearch extendSearch;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPage extractPage;
    private ExtractPrint extractPrint;

    public BirthExtractFromARTest() throws IOException {
    }

    @Test
    public void birthExtractFromARTest(){
        ActRecord act = new ActRecord();
        actRecordsTab = mainPage.openActRecordsTab();
        birthPage = actRecordsTab.selectBirth();
        extendSearch = birthPage.openExtendSearchModalWindow();
        searchByPersonRibbon = extendSearch.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_CHILD);
        searchByPersonRibbon.enterPersonInformation(
                CHILD_SURNAME,
                CHILD_NAME,
                CHILD_FATHER_NAME
        );
        extendSearch.clickExtFindButton();
        birthPage.selectSearchResult(
                CHILD_SURNAME,
                CHILD_NAME,
                CHILD_FATHER_NAME
        );
        extractPage = birthPage.clickCreateExtract();
        extractPage.typeReason("само вийшло");
        extractPage.generatePreview();
        extractPrint = extractPage.generateExtract();
        Assert.assertTrue(extractPrint.printExtract("birth-from-ar", act.getActNumber()));
    }
}
