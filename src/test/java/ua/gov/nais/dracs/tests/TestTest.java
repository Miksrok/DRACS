package ua.gov.nais.dracs.tests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.DeathPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.deathPageTabs.DeathPageTabDeadTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.deathPageTabs.DeathPageTabGeneralTab;


public class TestTest extends MainTest{

    DeathPage deathPage;
    DeathPageTabDeadTab deadTab;
    DeathPageTabGeneralTab generalTab;
    ActRecordsTab actRecordsTab;
    @Test
    public void test() {
       /* ActRecord act = new ActRecord();
        Person person = new Person();
        actRecordsTab = mainPage.openActRecordsTab();
        deathPage = actRecordsTab.selectDeath();
        generalTab = deathPage.createNewAct();
        deadTab = generalTab.typeActNoteNumber(act);
        deadTab.enterInformationAboutDead(person);
        deathPage.saveAct();*/

        /*driver.get("https://regdracs.test.nais.gov.ua/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();*/

        //MainPage mainPage = new MainPage(driver);
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

        /*Person child = new Person();
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
        motherTab.enterInformationAboutMother(mother);
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
        BirthTabFatherTab birthTabFatherTab = new BirthTabFatherTab(driver);
        birthTabFatherTab.openFatherTab();
        birthTabFatherTab.typeReason();
        birthPage.saveAndPrint();
        ActRecordPrint actRecordPrint = new ActRecordPrint(driver);
        actRecordPrint.printActRecord(num);
        CertificatePage certificatePage = new CertificatePage(driver);
        certificatePage.createCertificate(num);*/
       // birthPage.saveAct();




        /*mainPage.openActRecordsTab();
        actRecordsTab.selectDeath();
        deathPage.createNewAct();
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
