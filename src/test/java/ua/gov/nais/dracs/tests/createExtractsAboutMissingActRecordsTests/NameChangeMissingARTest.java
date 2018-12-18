package ua.gov.nais.dracs.tests.createExtractsAboutMissingActRecordsTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;

public class NameChangeMissingARTest extends MainTest {

    private final String CHANGE_NAME_ACT_RECORD = "4";
    private final String EXTRACT_TYPE = "21";
    private final String ROLE_SUBJ_AR = "Суб'єкт АЗ";

    ExtractPage extractPage;
    ExtendSearch search;
    SearchByPersonRibbon searchByPersonRibbon;
    ExtractPrint extractPrint;

    @Test
    public void changeNameMissingARTest(){
        extractPage = mainPage.openExtractTab();
        extractPage.createNewExtract();
        extractPage.selectActRecordType(CHANGE_NAME_ACT_RECORD);
        extractPage.selectExtractType(EXTRACT_TYPE);
        extractPage.typeReason("випадково вийшло");
        search = extractPage.clickSearchButton();
        searchByPersonRibbon = search.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_SUBJ_AR);
        searchByPersonRibbon.enterPersonInformation("Нема", "Такого", "Чувака");
        search.clickFindButton();
        search.clickNoResultYesButton();
        extractPage.generatePreview();
        extractPage.generateExtract();
        extractPrint = new ExtractPrint(driver);
        //extractPrint.printExtract("namechange-miss");
    }

}
