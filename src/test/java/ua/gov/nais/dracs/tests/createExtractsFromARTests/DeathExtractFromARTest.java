package ua.gov.nais.dracs.tests.createExtractsFromARTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.DeathPage;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;
import ua.gov.nais.dracs.util.PropertiesFileReader;

import java.io.IOException;

public class DeathExtractFromARTest extends MainTest {
    /**
     * test data for input
     */
    private final String ROLE_DEAD = PropertiesFileReader.getPropValues("dead");

    private final String DEAD_SURNAME = PropertiesFileReader.getPropValues("dead-surname");
    private final String DEAD_NAME = PropertiesFileReader.getPropValues("dead-name");
    private final String DEAD_FATHER_NAME = PropertiesFileReader.getPropValues("dead-father-name");
    /**
     * variables
     */
    private ActRecordsTab actRecordsTab;
    private DeathPage deathPage;
    private ExtendSearch extendSearch;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPage extractPage;
    private ExtractPrint extractPrint;

    public DeathExtractFromARTest() throws IOException {
    }

    @Test
    public void deathExtractFromARTest(){
        ActRecord act = new ActRecord();
        actRecordsTab = mainPage.openActRecordsTab();
        deathPage = actRecordsTab.selectDeath();
        extendSearch = deathPage.openExtendSearchModalWindow();
        searchByPersonRibbon = extendSearch.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_DEAD);
        searchByPersonRibbon.enterPersonInformation(
                DEAD_SURNAME,
                DEAD_NAME,
                DEAD_FATHER_NAME
        );
        extendSearch.clickExtFindButton();
        deathPage.selectSearchResult(
                DEAD_SURNAME,
                DEAD_NAME,
                DEAD_FATHER_NAME
        );
        extractPage = deathPage.clickCreateExtract();
        extractPage.typeReason("само вийшло");
        extractPage.generatePreview();
        extractPrint = extractPage.generateExtract();
        Assert.assertTrue(extractPrint.printExtract("death-from-ar", act.getActNumber()));
    }

}
