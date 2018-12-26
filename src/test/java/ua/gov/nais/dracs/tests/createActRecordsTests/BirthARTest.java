package ua.gov.nais.dracs.tests.createActRecordsTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.register.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.register.actRecordsTab.acts.birthPage.BirthPage;
import ua.gov.nais.dracs.pages.register.actRecordsTab.acts.birthPage.BirthPageTabs.BirthTabChildTab;
import ua.gov.nais.dracs.pages.register.actRecordsTab.acts.birthPage.BirthPageTabs.BirthTabFatherTab;
import ua.gov.nais.dracs.pages.register.actRecordsTab.acts.birthPage.BirthPageTabs.BirthTabGeneralTab;
import ua.gov.nais.dracs.pages.register.actRecordsTab.acts.birthPage.BirthPageTabs.BirthTabMotherTab;
import ua.gov.nais.dracs.tests.MainTest;

import java.io.IOException;

public class BirthARTest extends MainTest {

    private ActRecordsTab actRecordsTab;
    private BirthPage birthPage;
    private BirthTabGeneralTab generalTab;
    private BirthTabChildTab childTab;
    private BirthTabFatherTab fatherTab;
    private BirthTabMotherTab motherTab;

    protected BirthARTest() throws IOException {
    }


    @Test
    public void creatBirthActTest(){
        ActRecord act = new ActRecord();
        Person child = new Person();
        Person father = new Person();
        Person mother = new Person();
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
