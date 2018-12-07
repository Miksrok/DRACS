package ua.gov.nais.dracs.tests.createActRecordsTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.marriagePage.MarriagePage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.marriagePage.marriagePageTabs.MarriagePageTabFianceTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.marriagePage.marriagePageTabs.MarriagePageTabFianceeTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.marriagePage.marriagePageTabs.MarriagePageTabGeneralTab;
import ua.gov.nais.dracs.tests.MainTest;

public class MarriageARTest extends MainTest {

    private ActRecordsTab actRecordsTab;
    private MarriagePage marriagePage;
    private MarriagePageTabGeneralTab marriageGeneralTab;
    private MarriagePageTabFianceTab fianceTab;
    private MarriagePageTabFianceeTab fianceeTab;

    @Test
    public void createMarriageAct(){
        Person fiance = new Person();
        Person fiancee = new Person();
        ActRecord act= new ActRecord();
        actRecordsTab = mainPage.openActRecordsTab();
        marriagePage = actRecordsTab.selectMarriage();
        marriageGeneralTab = marriagePage.createNewAct();
        fianceTab = marriageGeneralTab.typeActInformation(act);
        fianceeTab = fianceTab.addFiance(fiance);
        fianceeTab.addFiancee(fiancee, fiance);
        marriagePage.saveAct();
    }

}
