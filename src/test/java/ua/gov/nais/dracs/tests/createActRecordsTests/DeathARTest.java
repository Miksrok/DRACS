package ua.gov.nais.dracs.tests.createActRecordsTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.DeathPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.deathPageTabs.DeathPageTabDeadTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.deathPageTabs.DeathPageTabGeneralTab;
import ua.gov.nais.dracs.tests.MainTest;

public class DeathARTest extends MainTest {

    //MainPage mainPage;
    DeathPage deathPage;
    DeathPageTabDeadTab deadTab;
    DeathPageTabGeneralTab generalTab;
    ActRecordsTab actRecordsTab;

    @Test
    public void createDeathActRecord(){
        ActRecord act = new ActRecord();
        Person person = new Person();
        //mainPage = new MainPage(driver);
        System.out.println(driver.toString());
        System.out.println(mainPage.toString());
        actRecordsTab = mainPage.openActRecordsTab();
        deathPage = actRecordsTab.selectDeath();
        generalTab = deathPage.createNewAct();
        deadTab = generalTab.typeActNoteNumber(act);
        deadTab.enterInformationAboutDead(person);
        deathPage.saveAct();
    }
}
