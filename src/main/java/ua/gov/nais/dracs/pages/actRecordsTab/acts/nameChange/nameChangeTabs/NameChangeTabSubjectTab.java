package ua.gov.nais.dracs.pages.actRecordsTab.acts.nameChange.nameChangeTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;

public class NameChangeTabSubjectTab extends AbstractPage {

    @FindBy(xpath = "//a[@href = '#tPerson']")
    private WebElement openSubjectTab;

    @FindBy(xpath = "(//label[text() = 'Прізвище'])[1]/following-sibling::input")
    private WebElement beforeName;

    @FindBy(xpath = "(//label[text() = 'Власне ім’я'])[1]/following-sibling::input")
    private WebElement beforeSurname;

    @FindBy(xpath = "(//label[text() = 'По батькові'])[1]/following-sibling::input")
    private WebElement beforeFatherName;

    @FindBy(xpath = "(//label[text() = 'Прізвище'])[2]/following-sibling::input")
    private WebElement afterName;

    @FindBy(xpath = "(//label[text() = 'Власне ім’я'])[2]/following-sibling::input")
    private WebElement afterSurname;

    @FindBy(xpath = "(//label[text() = 'По батькові'])[2]/following-sibling::input")
    private WebElement afterFatherName;

    @FindBy(xpath = "(//label[text() = 'Дата нар-ня'])[1]/following-sibling::div/div[2]/div/div/input")
    private WebElement birthdayDate;

    @FindBy(xpath = "(//label[text() = 'Серія та № / Документ №'])[1]/following-sibling::input")
    private WebElement documentNumber;

    @FindBy(xpath = "(//label[text() = 'Дата видачі'])[1]/following-sibling::div/div/input")
    private WebElement documentDate;

    @FindBy(xpath = "(//label[text() = 'Ким виданий (орган, що видав)'])[1]/following-sibling::input")
    private WebElement documentPublisher;

    public NameChangeTabSubjectTab(WebDriver driver) {
        super(driver);
    }

    public void enterInformationAboutNameChange(){
        Person person = new Person();
        action.clickOnElement(openSubjectTab);
        action.typeText(beforeName, person.getName());
        action.typeText(beforeSurname, person.getSurname());
        action.typeText(beforeFatherName, person.getFatherName());
        action.typeText(afterName, person.getName());
        action.typeText(afterSurname, person.getSurname());
        action.typeText(afterFatherName, person.getFatherName());
        action.typeText(birthdayDate, "04.04.1988");
        action.typeText(documentNumber, person.getPassport());
        action.typeText(documentDate, person.getPassportDate());
        action.typeText(documentPublisher, person.getPassportPublisher());
    }
}
