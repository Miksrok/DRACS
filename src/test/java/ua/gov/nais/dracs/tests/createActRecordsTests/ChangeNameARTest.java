package ua.gov.nais.dracs.tests.createActRecordsTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.register.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.register.actRecordsTab.acts.nameChangePage.NameChangePage;
import ua.gov.nais.dracs.pages.register.actRecordsTab.acts.nameChangePage.nameChangePageTabs.NameChangeTabGeneralTab;
import ua.gov.nais.dracs.pages.register.actRecordsTab.acts.nameChangePage.nameChangePageTabs.NameChangeTabSubjectTab;
import ua.gov.nais.dracs.tests.MainTest;

import java.io.IOException;

public class ChangeNameARTest extends MainTest {

    private ActRecordsTab actRecordsTab;
    private NameChangePage nameChangePage;
    private NameChangeTabGeneralTab nameChangeGeneralTab;
    private NameChangeTabSubjectTab nameChangeSubjectTab;

    protected ChangeNameARTest() throws IOException {
    }

    @Test
    public void createNameChangeActTest(){
        Person person = new Person();
        ActRecord act = new ActRecord();
        actRecordsTab = mainPage.openActRecordsTab();
        nameChangePage = actRecordsTab.selectNameChange();
        nameChangeGeneralTab = nameChangePage.createNewAct();
        nameChangeSubjectTab = nameChangeGeneralTab.typeActNoteNumber(act);
        nameChangeSubjectTab.enterInformationAboutNameChange(person);
        nameChangePage.saveAct();

    }

}
