package ua.gov.nais.dracs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPage;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.util.CustomReporter;

public class NotarTest extends MainTest {

    private final String ACT_RECORD_TITLE = "АЗ про народження";
    private final String BIRTH = "3";
    private final String DEATH = "5";

    ExtractPage extractPage;
    ExtendSearch extendSearch;
    SearchByPersonRibbon searchByPersonRibbon;
    ExtractPrint extractPrint;
    ActRecordsTab actRecordsTab;
    BirthPage birthPage;

    //@Test
    public void notarTest() {
        extractPage = mainPage.openExtractTab();
        extractPage.selectActRecordType(BIRTH);
        extractPage.selectExtractType();
        extendSearch = extractPage.clickSearchButton();
        searchByPersonRibbon = extendSearch.openPersonRibbon();
        searchByPersonRibbon.enterChildInformation();
        extendSearch.clickFindButton();
        extendSearch.clickAcceptButton();
        extractPage.typeReason();
        extractPage.generatePreview();
        extractPage.generateExtract();
        extractPrint = new ExtractPrint(driver);
        extractPrint.printExtract();
    }

   // @Test
    public void secondTest() {
        actRecordsTab = mainPage.openActRecordsTab();
        birthPage = actRecordsTab.selectBirth();
        Assert.assertEquals(ACT_RECORD_TITLE, actRecordsTab.getActRecordTitle());
        extendSearch = birthPage.openExtendSearchModalWindow();
        searchByPersonRibbon = extendSearch.openPersonRibbon();
        searchByPersonRibbon.enterChildInformation();
        extendSearch.clickExtFindButton();
        birthPage.selectSearchResult("Яяжішсикиатпч", "Робот", "Ймнхфабцзщац");
        birthPage.clickCreateExtract();
        extractPage = new ExtractPage(driver);
        extractPage.typeReason();
        extractPage.generatePreview();
        extractPage.generateExtract();
        extractPrint = new ExtractPrint(driver);
        extractPrint.printExtract();
    }
    @Test
    public void thirdTest(){
        extractPage = mainPage.openExtractTab();
        extractPage.selectActRecordType(DEATH);
        extractPage.selectExtractType();
        extendSearch = extractPage.clickSearchButton();
        searchByPersonRibbon = extendSearch.openPersonRibbon();
        searchByPersonRibbon.enterChildInformation();
        extendSearch.clickFindButton();
        extendSearch.clickAcceptButton();
        extractPage.typeReason();
        extractPage.generatePreview();
        extractPage.generateExtract();
        extractPrint = new ExtractPrint(driver);
        extractPrint.printExtract();
    }

}
