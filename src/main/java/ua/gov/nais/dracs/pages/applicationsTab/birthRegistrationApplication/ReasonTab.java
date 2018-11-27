package ua.gov.nais.dracs.pages.applicationsTab.birthRegistrationApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;

public class ReasonTab extends AbstractPage {

    @FindBy  (xpath = "//a[@href = '#baseRecordAboutFather']")
    private WebElement reasonTab;
    @FindBy (xpath = "//label[text() = '№ АЗ']/following-sibling::input")
    private WebElement actRecordNumber;
    @FindBy (xpath = "//label[text() = 'Дата складання АЗ']/following-sibling::div/descendant::input[1]")
    private WebElement actRecordDate;

    public ReasonTab(WebDriver driver) {
        super(driver);
    }

    public void enterInformationAboutReason(Person person){

        action.clickOnElement(reasonTab);
        action.typeText(actRecordNumber, person.getActNumber());
        action.typeText(actRecordDate, person.getActDate());

    }
}
