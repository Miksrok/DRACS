package ua.gov.nais.dracs.pages.applicationsTab.birthRegistrationApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;

public class ChildTab extends AbstractPage {

    @FindBy (xpath = "//a[@href = '#newBorn']")
    private WebElement openChildTab;
    @FindBy (xpath = "//h3[contains(text(), 'Відомості про дитину')]/following-sibling::div/div/label[text() = 'Прізвище']/following-sibling::input[1]")
    private WebElement surname;
    @FindBy (xpath = "//h3[contains(text(), 'Відомості про дитину')]/following-sibling::div/div/label[text() = 'Власне ім’я']/following-sibling::input[1]")
    private WebElement name;
    @FindBy (xpath = "//h3[contains(text(), 'Відомості про дитину')]/following-sibling::div/div/label[text() = 'По батькові']/following-sibling::input[1]")
    private WebElement fatherName;
    @FindBy (xpath = "(//label[text() = 'Дата нар-ня'])[1]/following-sibling::div/div/div/div/input")
    private WebElement birthDate;
    @FindBy (xpath = "//label[text() = 'Стать']/following-sibling::div/descendant::select")
    private WebElement genderList;
    @FindBy (xpath = "//option[text() = 'Ч']")
    private WebElement genderBoy;

    public ChildTab(WebDriver driver) {
        super(driver);
    }

    public void enterInformationAboutChild(Person person, ActRecord act){
        action.clickOnElement(openChildTab);
        action.typeText(surname, person.getSurname());
        action.typeText(name, person.getName() + person.getSurname());
        action.typeText(fatherName, person.getFatherName());
        action.typeText(birthDate, act.getActDate());
        action.clickOnElement(genderList);
        action.clickOnElement(genderBoy);
        Reporter.log("enter info about child");
    }


}
