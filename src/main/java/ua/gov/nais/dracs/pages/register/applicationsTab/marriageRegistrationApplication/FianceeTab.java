package ua.gov.nais.dracs.pages.register.applicationsTab.marriageRegistrationApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;

public class FianceeTab extends AbstractPage {

    @FindBy (xpath = "//a[@href = '#HS5']")
    private WebElement fianceeTab;
    @FindBy (xpath = "(//label[text() = 'Прізвище до реєстрації шлюбу'])[2]/following-sibling::input")
    private WebElement beforeSurname;
    @FindBy (xpath = "(//label[text() = 'Прізвище після реєстрації шлюбу'])[2]/following-sibling::input")
    private WebElement afterSurname;
    @FindBy (xpath = "(//label[text() = 'Власне ім’я'])[2]/following-sibling::input")
    private WebElement name;
    @FindBy (xpath = "(//label[text() = 'По батькові'])[2]/following-sibling::input")
    private WebElement fatherName;
    @FindBy (xpath = "(//label[text() = 'Дата нар-ня'])[2]/following-sibling::div/div[2]/div/div/input")
    private WebElement dateOfBirth;
    @FindBy (xpath = "(//label[text() = 'Вік'])[2]/following-sibling::input")
    private WebElement age;
    @FindBy (xpath = "(//label[text() = 'Серія та № / Документ №'])[2]/following-sibling::input")
    private WebElement documentNumber;
    @FindBy (xpath = "(//label[text() = 'Дата видачі'])[2]/following-sibling::div/div/input")
    private WebElement documentDate;
    @FindBy (xpath = "(//label[text() = 'Ким виданий (орган, що видав)'])[2]/following-sibling::input")
    private WebElement documentPublisher;

    public FianceeTab(WebDriver driver) {super(driver);}

    public void addFiance(Person person){
        action.clickOnElement(fianceeTab);
        action.typeText(beforeSurname, person.getSurname());
        action.typeText(afterSurname, person.getSurname());
        action.typeText(name, person.getName());
        action.typeText(fatherName, person.getFatherName());
        action.typeText(dateOfBirth, "12.12.1998");
        action.typeText(age, "19");
        action.typeText(documentNumber, person.getPassport());
        action.typeText(documentDate, person.getPassportDate());
        action.typeText(documentPublisher, person.getPassportPublisher());
    }
}
