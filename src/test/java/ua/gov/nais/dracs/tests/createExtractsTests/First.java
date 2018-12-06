package ua.gov.nais.dracs.tests.createExtractsTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;

public class First extends MainTest {

    ExtractPage ex;
    ExtendSearch search;
    SearchByPersonRibbon sbpr;

    @Test
    public void test(){
        ex = mainPage.openExtractTab();
        ex.createNewExtract();
        ex.selectActRecordType("про народження");
        ex.selectExtractType("Повний витяг щодо актового запису про народження");
        ex.typeReason("випадково вийшло");
        search = ex.clickSearchButton();
        sbpr = search.openPersonRibbon();
        sbpr.selectPersonRole("Дитина");
        sbpr.enterPersonInformation("Яевзьунеїфшїі", "Робот", "Ррехкчьюпїрб");
        search.clickFindButton();
        search.clickAcceptButton();
        ex.generatePreview();
        ex.generateExtract();
    }

}
