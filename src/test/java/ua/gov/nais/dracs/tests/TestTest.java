package ua.gov.nais.dracs.tests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.DeathPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.deathPageTabs.DeathPageTabGeneralTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.parenthoodPage.ParenthoodPage;
import ua.gov.nais.dracs.pages.LoginPage;
import ua.gov.nais.dracs.pages.MainPage;

public class TestTest extends MainTest{

    @Test
    public void test(){
        driver.get("https://regdracs.test.nais.gov.ua/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        MainPage mainPage = new MainPage(driver);
        mainPage.openActRecordsTab();
        ActRecordsTab actRecordsTab = new ActRecordsTab(driver);
        actRecordsTab.selectDeath();
        DeathPage deathPage = new DeathPage(driver);
        deathPage.creatNewAct();
        DeathPageTabGeneralTab generalTab = new DeathPageTabGeneralTab(driver);
        generalTab.typeActNoteNumber();
    }

}