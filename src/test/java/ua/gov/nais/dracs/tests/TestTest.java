package ua.gov.nais.dracs.tests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.LoginPage;
import ua.gov.nais.dracs.pages.MainPage;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.DeathPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.deathPageTabs.DeathPageTabDeadTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.deathPageTabs.DeathPageTabGeneralTab;


import ua.gov.nais.dracs.pages.actRecordsTab.acts.marriagePage.MarriagePage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.marriagePage.marriagePageTabs.MarriagePageTabFianceTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.marriagePage.marriagePageTabs.MarriagePageTabFianceeTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.marriagePage.marriagePageTabs.MarriagePageTabGeneralTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.nameChangePage.NameChangePage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.nameChangePage.nameChangePageTabs.NameChangeTabGeneralTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.nameChangePage.nameChangePageTabs.NameChangeTabSubjectTab;


public class TestTest extends MainTest{


    @Test
    public void test() {
        driver.get("https://regdracs.test.nais.gov.ua/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        MainPage mainPage = new MainPage(driver);
        ActRecordsTab actRecordsTab = new ActRecordsTab(driver);
        DeathPage deathPage = new DeathPage(driver);
        DeathPageTabGeneralTab generalTab = new DeathPageTabGeneralTab(driver);
        DeathPageTabDeadTab deadTab = new DeathPageTabDeadTab(driver);
        NameChangePage nameChangePage = new NameChangePage(driver);
        NameChangeTabGeneralTab nameChangeTabGeneralTab = new NameChangeTabGeneralTab(driver);
        NameChangeTabSubjectTab nameChangeTabSubjectTab = new NameChangeTabSubjectTab(driver);
        MarriagePage marriagePage = new MarriagePage(driver);
        MarriagePageTabGeneralTab marriagePageTabGeneralTab = new MarriagePageTabGeneralTab(driver);
        MarriagePageTabFianceTab marriagePageTabFianceTab = new MarriagePageTabFianceTab(driver);
        MarriagePageTabFianceeTab marriagePageTabFianceeTab = new MarriagePageTabFianceeTab(driver);


        /*mainPage.openActRecordsTab();
        actRecordsTab.selectDeath();
        deathPage.creatNewAct();
        generalTab.typeActNoteNumber();
        deadTab.enterInformationAboutDead();
        deathPage.saveAct();

        mainPage.openActRecordsTab();
        actRecordsTab.selectNameChange();
        nameChangePage.createNewAct();
        nameChageTabGeneralTab.typeActNoteNumber();
        nameChageTabGeneralTab.typeDateOfRegOfNameChange();
        nameChangeTabSubjectTab.enterInformationAboutNameChange();
        nameChangePage.saveAct();*/

        Person boy = new Person();
        Person girl = new Person();
        mainPage.openActRecordsTab();
        actRecordsTab.selectMarriage();
        marriagePage.createNewAct();
        marriagePageTabGeneralTab.typeActInformation(boy);
        marriagePageTabFianceTab.addFiance(boy);
        marriagePageTabFianceeTab.addFiancee(girl, boy);
        marriagePage.saveAct();

        

    }

}
