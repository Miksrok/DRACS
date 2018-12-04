package ua.gov.nais.dracs.pages.actRecordsTab.acts.marriagePage.marriagePageTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;

public class MarriagePageTabFianceeTab extends AbstractPage {

    @FindBy(xpath = "//a[@href = '#tGirl']")
    private WebElement fianceeTab;
    @FindBy (xpath = "(//label[text() = 'Прізвище до реєстрації шлюбу'])[2]/following-sibling::input")
    private WebElement beforeSurname;
    @FindBy (xpath = "(//label[text() = 'Прізвище після реєстрації шлюбу'])[2]/following-sibling::input")
    private WebElement afterSurname;
    @FindBy (xpath = "(//label[text() = 'Власне ім’я'])[2]/following-sibling::input")
    private WebElement name;
    @FindBy (xpath = "(//label[text() = 'По батькові'])[2]/following-sibling::input")
    private WebElement fatherName;
    @FindBy (xpath = "(//label[text() = 'Дата нар-ня'])[1]/following-sibling::div/div[2]/div/div/input")
    private WebElement dateOfBirth;
    @FindBy (xpath = "(//label[text() = 'Серія та № / Документ №'])[2]/following-sibling::input")
    private WebElement documentNumber;
    @FindBy (xpath = "(//label[text() = 'Дата видачі'])[2]/following-sibling::div/div/input")
    private WebElement documentDate;
    @FindBy (xpath = "(//label[text() = 'Ким виданий (орган, що видав)'])[2]/following-sibling::input")
    private WebElement documentPublisher;

    public MarriagePageTabFianceeTab(WebDriver driver) {
        super(driver);
    }

    public void addFiancee(Person person, Person boy){
        action.clickOnElement(fianceeTab);
        action.typeText(beforeSurname, person.getSurname());
        action.typeText(afterSurname, boy.getSurname());
        action.typeText(name, person.getName());
        action.typeText(fatherName, person.getFatherName());
        action.typeText(dateOfBirth, "12.12.1988");
        action.typeText(documentNumber, person.getPassport().replace('9','0'));
        action.typeText(documentDate, person.getPassportDate());
        action.typeText(documentPublisher, person.getPassportPublisher());
    }

}
