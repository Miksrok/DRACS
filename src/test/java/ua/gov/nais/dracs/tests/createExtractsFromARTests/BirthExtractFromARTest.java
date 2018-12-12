package ua.gov.nais.dracs.tests.createExtractsFromARTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPage;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;

public class BirthExtractFromARTest  extends MainTest {

    private final String ROLE_CHILD = "Дитина";

    private ActRecordsTab actRecordsTab;
    private BirthPage birthPage;
    private ExtendSearch extendSearch;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPage extractPage;
    private ExtractPrint extractPrint;

    @Test
    public void birthExtractFromARTest(){
        actRecordsTab = mainPage.openActRecordsTab();
        birthPage = actRecordsTab.selectBirth();
        extendSearch = birthPage.openExtendSearchModalWindow();
        searchByPersonRibbon = extendSearch.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_CHILD);
        searchByPersonRibbon.enterPersonInformation("Ячрюкцезґтузо", "Робот", "Шжшдйевкжлью");
        extendSearch.clickExtFindButton();
        birthPage.selectSearchResult("Ячрюкцезґтузо", "Робот", "Шжшдйевкжлью");
        extractPage = birthPage.clickCreateExtract();
        extractPage.typeReason("само вийшло");
        extractPage.generatePreview();
        extractPage.generateExtract();
        extractPrint = new ExtractPrint(driver);
        extractPrint.printExtract();
    }
}
