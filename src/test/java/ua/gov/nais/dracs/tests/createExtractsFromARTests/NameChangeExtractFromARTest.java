package ua.gov.nais.dracs.tests.createExtractsFromARTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.divorcePage.DivorcePage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.nameChangePage.NameChangePage;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;

public class NameChangeExtractFromARTest extends MainTest {

    private final String ROLE_CHANGE_NAME = "Суб'єкт АЗ";

    private ActRecordsTab actRecordsTab;
    private NameChangePage nameChangePage;
    private ExtendSearch extendSearch;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPage extractPage;
    private ExtractPrint extractPrint;

    @Test
    public void nameChangeExtractFromARTest(){
        actRecordsTab = mainPage.openActRecordsTab();
        nameChangePage = actRecordsTab.selectNameChange();
        extendSearch = nameChangePage.openExtendSearchModalWindow();
        searchByPersonRibbon = extendSearch.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_CHANGE_NAME);
        searchByPersonRibbon.enterPersonInformation("Ямфжрбьувохия", "Робот", "Вхкщїизебфєв");
        extendSearch.clickExtFindButton();
        nameChangePage.selectSearchResult("Ямфжрбьувохия", "Робот", "Вхкщїизебфєв");
        extractPage = nameChangePage.clickCreateExtract();
        extractPage.typeReason("само вийшло");
        extractPage.generatePreview();
        extractPage.generateExtract();
        extractPrint = new ExtractPrint(driver);
        //extractPrint.printExtract("namechange-from-ar");
    }

}
