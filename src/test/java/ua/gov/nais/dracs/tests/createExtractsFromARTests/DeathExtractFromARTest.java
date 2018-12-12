package ua.gov.nais.dracs.tests.createExtractsFromARTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.DeathPage;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;

public class DeathExtractFromARTest extends MainTest {

    private final String ROLE_DEAD = "Померлий";

    private ActRecordsTab actRecordsTab;
    private DeathPage deathPage;
    private ExtendSearch extendSearch;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPage extractPage;
    private ExtractPrint extractPrint;

    @Test
    public void deathExtractFromARTest(){
        actRecordsTab = mainPage.openActRecordsTab();
        deathPage = actRecordsTab.selectDeath();
        extendSearch = deathPage.openExtendSearchModalWindow();
        searchByPersonRibbon = extendSearch.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_DEAD);
        searchByPersonRibbon.enterPersonInformation("Ячсакяєйрркло", "РоботЯчсакяєйрркло", "Смьбкжчтнукк");
        extendSearch.clickExtFindButton();
        deathPage.selectSearchResult("Ячсакяєйрркло", "РоботЯчсакяєйрркло", "Смьбкжчтнукк");
        extractPage = deathPage.clickCreateExtract();
        extractPage.typeReason("само вийшло");
        extractPage.generatePreview();
        extractPage.generateExtract();
        extractPrint = new ExtractPrint(driver);
        extractPrint.printExtract("deathar");
    }

}
