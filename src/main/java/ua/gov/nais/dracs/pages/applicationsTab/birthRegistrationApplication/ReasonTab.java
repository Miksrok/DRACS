package ua.gov.nais.dracs.pages.applicationsTab.birthRegistrationApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;

public class ReasonTab extends AbstractPage {

    @FindBy  (xpath = "//a[@href = '#baseRecordAboutFather']")
    private WebElement reasonTab;
    @FindBy (xpath = "//label[text() = '№ АЗ']/following-sibling::input")
    private WebElement actRecordNumber;
    @FindBy (xpath = "//label[text() = 'Дата складання АЗ']/following-sibling::div/descendant::input[1]")
    private WebElement actRecordDate;

    @FindBy (xpath = "(//label[text() = 'Регіон органу ДРАЦС'])[1]/following-sibling::select")
    private WebElement organizationRregionList;
    @FindBy (xpath = "(//label[text() = 'Регіон органу ДРАЦС'])[1]/following-sibling::select/option[text() = 'Волинська обл.']")
    private WebElement regionVolin;
    @FindBy (xpath = "(//label[text() = 'Орган ДРАЦС'])[1]/following-sibling::select")
    private WebElement organizationList;
    @FindBy (xpath = "//option[@value = '52079']")
    private WebElement organizationGorohivDracs;

    public ReasonTab(WebDriver driver) {
        super(driver);
    }

    public void enterInformationAboutReason(Person person){

        action.clickOnElement(reasonTab);
        action.typeText(actRecordNumber, person.getActNumber());
        action.typeText(actRecordDate, person.getActDate());
        action.clickOnElement(organizationRregionList);
        action.clickOnElement(regionVolin);
        action.clickOnElement(organizationRregionList);
        action.clickOnElement(organizationGorohivDracs);
        Reporter.log("about reason"+"<br>");

    }
}
