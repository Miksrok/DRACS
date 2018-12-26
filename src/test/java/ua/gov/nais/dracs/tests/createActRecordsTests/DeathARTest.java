package ua.gov.nais.dracs.tests.createActRecordsTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.register.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.register.actRecordsTab.acts.deathPage.DeathPage;
import ua.gov.nais.dracs.pages.register.actRecordsTab.acts.deathPage.deathPageTabs.DeathPageTabDeadTab;
import ua.gov.nais.dracs.pages.register.actRecordsTab.acts.deathPage.deathPageTabs.DeathPageTabGeneralTab;
import ua.gov.nais.dracs.tests.MainTest;

import java.io.IOException;

public class DeathARTest extends MainTest {

    private DeathPage deathPage;
    private DeathPageTabDeadTab deadTab;
    private DeathPageTabGeneralTab generalTab;
    private ActRecordsTab actRecordsTab;

    protected DeathARTest() throws IOException {
    }

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
}
