package ua.gov.nais.dracs.tests.createExtractsFromARTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.DeathPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.divorcePage.DivorcePage;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;

public class DivorceExtractFromARTest extends MainTest {

    private final String ROLE_DIVORCE = "Чоловік";

    private ActRecordsTab actRecordsTab;
    private DivorcePage divorcePage;
    private ExtendSearch extendSearch;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPage extractPage;
    private ExtractPrint extractPrint;

    @Test
    public void divorceExtractFromARTest(){
        actRecordsTab = mainPage.openActRecordsTab();
        divorcePage = actRecordsTab.selectDivorce();
        extendSearch = divorcePage.openExtendSearchModalWindow();
        searchByPersonRibbon = extendSearch.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_DIVORCE);
        searchByPersonRibbon.enterPersonInformation("Яидлчсвуґеуоі", "РоботЯидлчсвуґеуоі", "Оокщсьїяуптг");
        extendSearch.clickExtFindButton();
        divorcePage.selectSearchResult("Яидлчсвуґеуоі", "РоботЯидлчсвуґеуоі", "Оокщсьїяуптг");
        extractPage = divorcePage.clickCreateExtract();
        extractPage.typeReason("само вийшло");
        extractPage.generatePreview();
        extractPage.generateExtract();
        extractPrint = new ExtractPrint(driver);
        //extractPrint.printExtract("divorce-from-ar");
    }

}
