package ua.gov.nais.dracs.tests.createExtractsAboutMissingActRecordsTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;

public class DeathMissingARTest extends MainTest {

    private final String DEATH_ACT_RECORD = "5";
    private final String EXTRACT_TYPE = "18";
    private final String ROLE_DEAD = "Померлий";

    ExtractPage extractPage;
    ExtendSearch search;
    SearchByPersonRibbon searchByPersonRibbon;
    ExtractPrint extractPrint;

    @Test
    public void deathMissingARTest(){
        extractPage = mainPage.openExtractTab();
        extractPage.createNewExtract();
        extractPage.selectActRecordType(DEATH_ACT_RECORD);
        extractPage.selectExtractType(EXTRACT_TYPE);
        extractPage.typeReason("випадково вийшло");
        search = extractPage.clickSearchButton();
        searchByPersonRibbon = search.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_DEAD);
        searchByPersonRibbon.enterPersonInformation("Нема", "Такого", "Померлого");
        search.clickFindButton();
        search.clickNoResultYesButton();
        extractPage.generatePreview();
        extractPage.generateExtract();
        extractPrint = new ExtractPrint(driver);
        //extractPrint.printExtract("death-miss");

    }


}