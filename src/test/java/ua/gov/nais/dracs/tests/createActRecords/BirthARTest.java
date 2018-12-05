package ua.gov.nais.dracs.tests.createActRecords;

import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.MainPage;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPageTabs.BirthTabChildTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPageTabs.BirthTabFatherTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPageTabs.BirthTabGeneralTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPageTabs.BirthTabMotherTab;
import ua.gov.nais.dracs.tests.MainTest;

public class BirthARTest extends MainTest {

    //private MainPage mainPage;
    private ActRecordsTab actRecordsTab;
    private BirthPage birthPage;
    private BirthTabGeneralTab generalTab;
    private BirthTabChildTab childTab;
    private BirthTabFatherTab fatherTab;
    private BirthTabMotherTab motherTab;

    @Test
    public void creatBirthActTest(){
        ActRecord act = new ActRecord();
        Person child = new Person();
        Person father = new Person();
        Person mother = new Person();
        //mainPage = new MainPage(driver);
        System.out.println(mainPage.toString());
        actRecordsTab = mainPage.openActRecordsTab();
        birthPage = actRecordsTab.selectBirth();
        generalTab = birthPage.createNewAct();
        childTab = generalTab.typeActNoteNumber(act);
        fatherTab =childTab.enterInformationAboutChild(child);
        fatherTab.openFatherTab();
        fatherTab.enterInformationAboutFather(father);
        motherTab = fatherTab.typeReason();
        motherTab.enterInformationAboutMother(mother);
        birthPage.saveAct();
    }


}
