package ua.gov.nais.dracs.tests.createActRecordsTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.nameChangePage.NameChangePage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.nameChangePage.nameChangePageTabs.NameChangeTabGeneralTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.nameChangePage.nameChangePageTabs.NameChangeTabSubjectTab;
import ua.gov.nais.dracs.tests.MainTest;

public class ChangeNameARTest extends MainTest {

    private ActRecordsTab actRecordsTab;
    private NameChangePage nameChangePage;
    private NameChangeTabGeneralTab nameChangeGeneralTab;
    private NameChangeTabSubjectTab nameChangeSubjectTab;

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
