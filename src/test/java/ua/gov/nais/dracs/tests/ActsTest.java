package ua.gov.nais.dracs.tests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.MainPage;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPageTabs.BirthTabChildTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPageTabs.BirthTabFatherTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPageTabs.BirthTabGeneralTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPageTabs.BirthTabMotherTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.DeathPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.deathPageTabs.DeathPageTabDeadTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.deathPageTabs.DeathPageTabGeneralTab;

public class ActsTest extends MainTest {

    private DeathPage deathPage;
    private DeathPageTabDeadTab deadTab;
    private DeathPageTabGeneralTab generalTab;
    private ActRecordsTab actRecordsTab;
    private BirthPage birthPage;
    private BirthTabGeneralTab birthGeneralTab;
    private BirthTabChildTab childTab;
    private BirthTabFatherTab fatherTab;
    private BirthTabMotherTab motherTab;

    @Test
    public void createDeathActRecord(){
        ActRecord act = new ActRecord();
        Person person = new Person();
        actRecordsTab = mainPage.openActRecordsTab();
        deathPage = actRecordsTab.selectDeath();
        generalTab = deathPage.createNewAct();
        deadTab = generalTab.typeActNoteNumber(act);
        deadTab.enterInformationAboutDead(person);
        deathPage.saveAct();
    }

    @Test
    public void creatBirthActTest(){
        ActRecord act = new ActRecord();
        Person child = new Person();
        Person father = new Person();
        Person mother = new Person();
        actRecordsTab = mainPage.openActRecordsTab();
        birthPage = actRecordsTab.selectBirth();
        birthGeneralTab = birthPage.createNewAct();
        childTab = birthGeneralTab.typeActNoteNumber(act);
        fatherTab =childTab.enterInformationAboutChild(child);
        fatherTab.openFatherTab();
        fatherTab.enterInformationAboutFather(father);
        motherTab = fatherTab.typeReason();
        motherTab.enterInformationAboutMother(mother);
        birthPage.saveAct();

    }


}
