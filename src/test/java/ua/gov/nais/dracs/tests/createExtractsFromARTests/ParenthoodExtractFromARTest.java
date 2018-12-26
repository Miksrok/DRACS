package ua.gov.nais.dracs.tests.createExtractsFromARTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.pages.register.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.register.actRecordsTab.acts.parenthoodPage.ParenthoodPage;
import ua.gov.nais.dracs.pages.register.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.register.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.register.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.register.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;
import ua.gov.nais.dracs.util.PropertiesFileReader;

import java.io.IOException;

public class ParenthoodExtractFromARTest extends MainTest {
    /*
     * test data for input
     */
    private final String ROLE_CHILD = PropertiesFileReader.getPropValues("child-parenthood");

    private final String CHILD_SURNAME = PropertiesFileReader.getPropValues("child-parenthood-surname");
    private final String CHILD_NAME = PropertiesFileReader.getPropValues("child-parenthood-name");
    private final String CHILD_FATHER_NAME = PropertiesFileReader.getPropValues("child-parenthood-father-name");
    /*
     * variables
     */
    private ActRecordsTab actRecordsTab;
    private ParenthoodPage parenthoodPage;
    private ExtendSearch extendSearch;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPage extractPage;
    private ExtractPrint extractPrint;
    protected ParenthoodExtractFromARTest() throws IOException {
    }

    @Test
    public void parenthoodExtractFromARTest(){
        ActRecord act = new ActRecord();
        actRecordsTab = mainPage.openActRecordsTab();
        parenthoodPage = actRecordsTab.selectParenthood();
        extendSearch = parenthoodPage.openExtendSearchModalWindow();
        searchByPersonRibbon = extendSearch.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_CHILD);
        searchByPersonRibbon.enterPersonInformation(
                CHILD_SURNAME,
                CHILD_NAME,
                CHILD_FATHER_NAME
        );
        extendSearch.clickExtFindButton();
        parenthoodPage.selectSearchResult(
                CHILD_SURNAME,
                CHILD_NAME,
                CHILD_FATHER_NAME
        );
        extractPage = parenthoodPage.clickCreateExtract();
        extractPage.typeReason("само вийшло");
        extractPage.generatePreview();
        extractPrint = extractPage.generateExtract();
        Assert.assertTrue(extractPrint.printExtract("parenthood-from-ar", act.getActNumber()));
    }

}
