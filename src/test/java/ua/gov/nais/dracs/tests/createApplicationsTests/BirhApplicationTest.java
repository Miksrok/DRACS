package ua.gov.nais.dracs.tests.createApplicationsTests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.register.applicationsTab.ApplicationsTab;
import ua.gov.nais.dracs.pages.register.applicationsTab.birthRegistrationApplication.ChildTab;
import ua.gov.nais.dracs.pages.register.applicationsTab.birthRegistrationApplication.FatherTab;
import ua.gov.nais.dracs.pages.register.applicationsTab.birthRegistrationApplication.MotherTab;
import ua.gov.nais.dracs.pages.register.applicationsTab.birthRegistrationApplication.ReasonTab;
import ua.gov.nais.dracs.tests.MainTest;

import java.io.IOException;

public class BirhApplicationTest extends MainTest {

    ApplicationsTab at;
    ChildTab child;
    FatherTab father;
    MotherTab mother;
    ReasonTab reason;

    protected BirhApplicationTest() throws IOException {
    }

    @Test
    public void tt(){
        ActRecord ar = new ActRecord();
        Person c = new Person();
        Person f = new Person();
        Person m = new Person();
        at= mainPage.openApplicationTab();
        at.creatNewApplication();
        child = new ChildTab(driver);
        child.enterInformationAboutChild(c, ar);
        father = new FatherTab(driver);
        father.enterInformationAboutFather(f);
        mother = new MotherTab(driver);
        mother.enterInformationAboutMother(m);
        reason = new ReasonTab(driver);
        reason.enterInformationAboutReason(ar);
    }

}
