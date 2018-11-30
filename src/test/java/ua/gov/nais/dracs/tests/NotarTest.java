package ua.gov.nais.dracs.tests;

import org.testng.Reporter;
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

public class NotarTest extends MainTest {

    @Test
    public void notarTest(){
        CustomReporter.log("open page");
        driver.get("https://regdracs.test.nais.gov.ua/");
        CustomReporter.log("start to enter login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        CustomReporter.log("login completed");
        CustomReporter.log("Open main page and act record tab");
        MainPage mainPage = new MainPage(driver);
        mainPage.openActRecordsTab();
        ActRecordsTab actRecordsTab = new ActRecordsTab(driver);
        actRecordsTab.selectBirth();
        BirthPage birthPage = new BirthPage(driver);
        birthPage.openExtendSearchModalWindow();
        ExtendSearch extendSearch = new ExtendSearch(driver);
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
