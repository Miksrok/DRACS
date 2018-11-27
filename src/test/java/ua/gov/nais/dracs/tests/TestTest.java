package ua.gov.nais.dracs.tests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.LoginPage;
import ua.gov.nais.dracs.pages.MainPage;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPageTabs.BirthTabGeneralTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.divorcePage.DivorcePage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.divorcePage.divorcePageTabs.DivorcePageTabGeneralTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.divorcePage.divorcePageTabs.DivorcePageTabHusbandTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.divorcePage.divorcePageTabs.DivorcePageTabWifeTab;
import ua.gov.nais.dracs.pages.applicationsTab.ApplicationsTab;
import ua.gov.nais.dracs.pages.applicationsTab.birthRegistrationApplication.ChildTab;
import ua.gov.nais.dracs.pages.applicationsTab.birthRegistrationApplication.FatherTab;
import ua.gov.nais.dracs.pages.applicationsTab.birthRegistrationApplication.MotherTab;
import ua.gov.nais.dracs.pages.applicationsTab.birthRegistrationApplication.ReasonTab;


public class TestTest extends MainTest{


    @Test
    public void test() {
        driver.get("https://regdracs.test.nais.gov.ua/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        MainPage mainPage = new MainPage(driver);
        //ActRecordsTab actRecordsTab = new ActRecordsTab(driver);
        /*DeathPage deathPage = new DeathPage(driver);
        DeathPageTabGeneralTab generalTab = new DeathPageTabGeneralTab(driver);
        DeathPageTabDeadTab deadTab = new DeathPageTabDeadTab(driver);
        NameChangePage nameChangePage = new NameChangePage(driver);
        NameChageTabGeneralTab nameChageTabGeneralTab = new NameChageTabGeneralTab(driver);
        NameChangeTabSubjectTab nameChangeTabSubjectTab = new NameChangeTabSubjectTab(driver);
        MarriagePage marriagePage = new MarriagePage(driver);
        MarriagePageTabGeneralTab marriagePageTabGeneralTab = new MarriagePageTabGeneralTab(driver);
        MarriagePageTabFianceTab marriagePageTabFianceTab = new MarriagePageTabFianceTab(driver);
        MarriagePageTabFianceeTab marriagePageTabFianceeTab = new MarriagePageTabFianceeTab(driver);*/
        /*DivorcePage divorcePage = new DivorcePage(driver);
        DivorcePageTabGeneralTab divorcePageTabGeneralTab = new DivorcePageTabGeneralTab(driver);
        DivorcePageTabHusbandTab divorcePageTabHusbandTab = new DivorcePageTabHusbandTab(driver);
        DivorcePageTabWifeTab divorcePageTabWifeTab = new DivorcePageTabWifeTab(driver);*/

        Person child = new Person();
        Person father = new Person();
        Person mother = new Person();
        mainPage.openApplicationTab();
        ApplicationsTab applicationsTab = new ApplicationsTab(driver);
        applicationsTab.creatNewApplication();
        String num = applicationsTab.selectApplicationAndEnterMainInfo();
        ChildTab childTab = new ChildTab(driver);
        childTab.enterInformationAboutChild(child);
        FatherTab fatherTab = new FatherTab(driver);
        fatherTab.enterInformationAboutFather(father);
        MotherTab motherTab = new MotherTab(driver);
        motherTab.enterInformationAboutFather(mother);
        ReasonTab reasonTab = new ReasonTab(driver);
        reasonTab.enterInformationAboutReason(child);
        applicationsTab.saveApllication();

        mainPage.openActRecordsTab();
        ActRecordsTab actRecordsTab = new ActRecordsTab(driver);
        actRecordsTab.selectBirth();
        BirthPage birthPage = new BirthPage(driver);
        birthPage.createNewAct();
        BirthTabGeneralTab birthTabGeneralTab = new BirthTabGeneralTab(driver);
        birthTabGeneralTab.typeActNoteNumber(mother);
        birthTabGeneralTab.clickSearchAppButton(num);




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

        /*Person boy = new Person();
        Person girl = new Person();
        mainPage.openActRecordsTab();
        actRecordsTab.selectDivorce();
        divorcePage.createNewAct();
        divorcePageTabGeneralTab.typeActInformation(boy);
        divorcePageTabHusbandTab.addHusband(boy);
        divorcePageTabWifeTab.addWife(girl, boy);
        divorcePage.saveAct();*/

        

    }

}
