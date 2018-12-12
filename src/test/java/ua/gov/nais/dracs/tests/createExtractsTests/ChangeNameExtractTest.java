package ua.gov.nais.dracs.tests.createExtractsTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;

public class ChangeNameExtractTest extends MainTest {

    private final String CHANGE_NAME_ACT_RECORD = "4";
    private final String EXTRACT_TYPE = "21";
    private final String ROLE_SUBJ_AR = "Суб'єкт АЗ";

    ExtractPage extractPage;
    ExtendSearch search;
    SearchByPersonRibbon searchByPersonRibbon;
    ExtractPrint extractPrint;

    @Test
    public void changeNameExtractTest(){
        extractPage = mainPage.openExtractTab();
        extractPage.createNewExtract();
        extractPage.selectActRecordType(CHANGE_NAME_ACT_RECORD);
        extractPage.selectExtractType(EXTRACT_TYPE);
        extractPage.typeReason("випадково вийшло");
        search = extractPage.clickSearchButton();
        searchByPersonRibbon = search.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_SUBJ_AR);
        searchByPersonRibbon.enterPersonInformation("Ямфжрбьувохия", "Робот", "Вхкщїизебфєв");
        search.clickFindButton();
        search.clickAcceptButton();
        extractPage.generatePreview();
        extractPage.generateExtract();
        extractPrint = new ExtractPrint(driver);
        extractPrint.printExtract();
    }

}
