package ua.gov.nais.dracs.tests.createExtractsTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;

public class MarriageExtractTest extends MainTest {

    private final String MARRIAGE_ACT_RECORD = "7";
    private final String EXTRACT_TYPE = "19";
    private final String ROLE_FEANCE = "Наречений";

    ExtractPage extractPage;
    ExtendSearch search;
    SearchByPersonRibbon searchByPersonRibbon;
    ExtractPrint extractPrint;

    @Test
    public void marriageExtractTest(){
        extractPage = mainPage.openExtractTab();
        extractPage.createNewExtract();
        extractPage.selectActRecordType(MARRIAGE_ACT_RECORD);
        extractPage.selectExtractType(EXTRACT_TYPE);
        extractPage.typeReason("випадково вийшло");
        search = extractPage.clickSearchButton();
        searchByPersonRibbon = search.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_FEANCE);
        searchByPersonRibbon.enterPersonInformation("Яїдгмтшйжщєтз", "РоботЯїдгмтшйжщєтз", "Шршзфжоідачх");
        search.clickFindButton();
        search.clickAcceptButton();
        extractPage.generatePreview();
        extractPage.generateExtract();
        extractPrint = new ExtractPrint(driver);
        //extractPrint.printExtract("marriage");
    }

}
