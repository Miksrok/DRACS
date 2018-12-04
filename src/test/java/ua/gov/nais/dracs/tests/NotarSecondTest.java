package ua.gov.nais.dracs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.gov.nais.dracs.pages.LoginPage;
import ua.gov.nais.dracs.pages.MainPage;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPage;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.util.CustomReporter;
public class NotarSecondTest extends MainTest {

    private final String ACT_RECORD_TITLE = "АЗ про народження";

    @Test
    public void secondTest(){

        MainPage mainPage = new MainPage(driver);
        ActRecordsTab actRecordsTab = mainPage.openActRecordsTab();
        BirthPage birthPage = actRecordsTab.selectBirth();
        Assert.assertEquals(ACT_RECORD_TITLE, actRecordsTab.getActRecordTitle());
        ExtendSearch extendSearch =  birthPage.openExtendSearchModalWindow();
        SearchByPersonRibbon searchByPersonRibbon = extendSearch.openPersonRibbon();
        searchByPersonRibbon.enterChildInformation();
        extendSearch.clickFindButton();
        birthPage.selectSearchResult("Яяжішсикиатпч", "Робот", "Ймнхфабцзщац");
        birthPage.clickCreateExtract();
        ExtractPage extractPage = new ExtractPage(driver);
        extractPage.typeReason();
        extractPage.generatePreview();
        extractPage.generateExtract();
        ExtractPrint extractPrint = new ExtractPrint(driver);
        extractPrint.printExtract();
    }


}
