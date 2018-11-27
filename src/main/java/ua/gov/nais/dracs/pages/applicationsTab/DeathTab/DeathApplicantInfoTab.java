package ua.gov.nais.dracs.pages.applicationsTab.DeathTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;

public class DeathApplicantInfoTab extends AbstractPage {

    @FindBy(xpath = "//b[text()= 'Відомості про заявника']")
    private WebElement openApplicationInfoTab;

    @FindBy(xpath = "(//label[text() = 'Власне ім’я'])[1]/following-sibling::input[1]")
    private WebElement Name;

    @FindBy(xpath = "(//label[text() = 'Прізвище'])[1]/following-sibling::input[1]")
    private WebElement Surname;

    @FindBy(xpath = "(//label[text() = 'По батькові'])[1]/following-sibling::input[1]")
    private WebElement FatherName;

    @FindBy(xpath = "(//label[text() = 'Дата нар-ня'])[1]/following-sibling::div/div[2]/div/div/input")
    private WebElement dateOfBirth;

    @FindBy(xpath = "(//label[text() = 'Дата смерті'])[1]/following-sibling::div/div[2]/div/div/input")
    private WebElement dateOfDeath;

    @FindBy(xpath = "(//label[text() = 'Серія та № / Документ №'])[2]/following-sibling::input")
    private WebElement documentNumber;

    @FindBy(xpath = "(//label[text() = 'Дата видачі'])[2]/following-sibling::div/div/input")
    private WebElement documentDate;

    @FindBy(xpath = "(//label[text() = 'Ким виданий (орган, що видав)'])[2]/following-sibling::input")
    private WebElement documentPublisher;

    public DeathApplicantInfoTab(WebDriver driver) {super(driver);}

    public void enterInformationAboutNameChange(Person person){
        action.clickOnElement(openApplicationInfoTab);
        action.typeText(Name, person.getName());
        action.typeText(Surname, person.getSurname());
        action.typeText(FatherName, person.getFatherName());
        action.typeText(dateOfBirth, "04.04.1988");
        action.typeText(dateOfDeath, "04.04.2018");
        action.typeText(documentNumber, person.getPassport());
        action.typeText(documentDate, person.getPassportDate());
        action.typeText(documentPublisher, person.getPassportPublisher());
    }
}
