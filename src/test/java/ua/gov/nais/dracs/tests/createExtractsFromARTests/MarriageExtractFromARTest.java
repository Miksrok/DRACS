package ua.gov.nais.dracs.tests.createExtractsFromARTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.divorcePage.DivorcePage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.marriagePage.MarriagePage;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;

public class MarriageExtractFromARTest extends MainTest {

    private final String ROLE_MARRIAGE = "Наречений";

    private ActRecordsTab actRecordsTab;
    private MarriagePage marriagePage;
    private ExtendSearch extendSearch;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPage extractPage;
    private ExtractPrint extractPrint;

    @Test
    public void deathExtractFromARTest(){
        actRecordsTab = mainPage.openActRecordsTab();
        marriagePage = actRecordsTab.selectMarriage();
        extendSearch = marriagePage.openExtendSearchModalWindow();
        searchByPersonRibbon = extendSearch.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_MARRIAGE);
        searchByPersonRibbon.enterPersonInformation("Яїдгмтшйжщєтз", "РоботЯїдгмтшйжщєтз", "Шршзфжоідачх");
        extendSearch.clickExtFindButton();
        marriagePage.selectSearchResult("Яїдгмтшйжщєтз", "РоботЯїдгмтшйжщєтз", "Шршзфжоідачх");
        extractPage = marriagePage.clickCreateExtract();
        extractPage.typeReason("само вийшло");
        extractPage.generatePreview();
        extractPage.generateExtract();
        extractPrint = new ExtractPrint(driver);
        extractPrint.printExtract();
    }

}
