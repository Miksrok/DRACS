package ua.gov.nais.dracs.pages.applicationsTab.marriageRegistrationApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;

public class FianceTab extends AbstractPage {

    @FindBy (xpath = "//a[@href = '#HS4']")
    private WebElement fianceTab;
    @FindBy (xpath = "(//label[text() = 'Прізвище до реєстрації шлюбу'])[1]/following-sibling::input")
    private WebElement beforeSurname;
    @FindBy (xpath = "(//label[text() = 'Прізвище після реєстрації шлюбу'])[1]/following-sibling::input")
    private WebElement afterSurname;
    @FindBy (xpath = "(//label[text() = 'Власне ім’я'])[1]/following-sibling::input")
    private WebElement name;
    @FindBy (xpath = "(//label[text() = 'По батькові'])[1]/following-sibling::input")
    private WebElement fatherName;
    @FindBy (xpath = "(//label[text() = 'Дата нар-ня'])[1]/following-sibling::div/div[2]/div/div/input")
    private WebElement dateOfBirth;
    @FindBy (xpath = "(//label[text() = 'Вік'])[1]/following-sibling::input")
    private WebElement age;
    @FindBy (xpath = "(//label[text() = 'Серія та № / Документ №'])[1]/following-sibling::input")
    private WebElement documentNumber;
    @FindBy (xpath = "(//label[text() = 'Дата видачі'])[1]/following-sibling::div/div/input")
    private WebElement documentDate;
    @FindBy (xpath = "(//label[text() = 'Ким виданий (орган, що видав)'])[1]/following-sibling::input")
    private WebElement documentPublisher;

    public FianceTab(WebDriver driver) {super(driver);}

    public void addFiance(Person person){
        action.clickOnElement(fianceTab);
        action.typeText(beforeSurname, person.getSurname());
        action.typeText(afterSurname, person.getSurname());
        action.typeText(name, person.getName());
        action.typeText(fatherName, person.getFatherName());
        action.typeText(dateOfBirth, "12.12.1988");
        action.typeText(age, "29");
        action.typeText(documentNumber, person.getPassport());
        action.typeText(documentDate, person.getPassportDate());
        action.typeText(documentPublisher, person.getPassportPublisher());
    }
}
