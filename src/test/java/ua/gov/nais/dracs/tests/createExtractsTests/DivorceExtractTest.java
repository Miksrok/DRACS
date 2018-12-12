package ua.gov.nais.dracs.tests.createExtractsTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;

public class DivorceExtractTest extends MainTest {

    private final String DIVORCE_ACT_RECORD = "6";
    private final String EXTRACT_TYPE = "20";
    private final String ROLE_HUSBAND = "Чоловік";

    ExtractPage extractPage;
    ExtendSearch search;
    SearchByPersonRibbon searchByPersonRibbon;
    ExtractPrint extractPrint;

    @Test
    public void divorceExtractTest(){
        extractPage = mainPage.openExtractTab();
        extractPage.createNewExtract();
        extractPage.selectActRecordType(DIVORCE_ACT_RECORD);
        extractPage.selectExtractType(EXTRACT_TYPE);
        extractPage.typeReason("випадково вийшло");
        search = extractPage.clickSearchButton();
        searchByPersonRibbon = search.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_HUSBAND);
        searchByPersonRibbon.enterPersonInformation("Яидлчсвуґеуоі", "РоботЯидлчсвуґеуоі", "Оокщсьїяуптг");
        search.clickFindButton();
        search.clickAcceptButton();
        extractPage.generatePreview();
        extractPage.generateExtract();
        extractPrint = new ExtractPrint(driver);
        extractPrint.printExtract();
    }

}
