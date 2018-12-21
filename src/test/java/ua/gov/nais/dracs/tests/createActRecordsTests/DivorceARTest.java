package ua.gov.nais.dracs.tests.createActRecordsTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.divorcePage.DivorcePage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.divorcePage.divorcePageTabs.DivorcePageTabGeneralTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.divorcePage.divorcePageTabs.DivorcePageTabHusbandTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.divorcePage.divorcePageTabs.DivorcePageTabWifeTab;
import ua.gov.nais.dracs.tests.MainTest;

import java.io.IOException;

public class DivorceARTest extends MainTest {

    private ActRecordsTab actRecordsTab;
    private DivorcePage divorcePage;
    private DivorcePageTabGeneralTab divorceGeneralTab;
    private DivorcePageTabHusbandTab divorceHusbandTab;
    private DivorcePageTabWifeTab divorceWifeTab;

    protected DivorceARTest() throws IOException {
    }

    @Test
    public void createDivorceAcrTest(){
        Person husband = new Person();
        Person wife = new Person();
        ActRecord act = new ActRecord();
        actRecordsTab = mainPage.openActRecordsTab();
        divorcePage = actRecordsTab.selectDivorce();
        divorceGeneralTab = divorcePage.createNewAct();
        divorceHusbandTab = divorceGeneralTab.typeActInformation(act);
        divorceWifeTab = divorceHusbandTab.addHusband(husband);
        divorceWifeTab.addWife(husband, wife);
        divorcePage.saveAct();
    }


}
