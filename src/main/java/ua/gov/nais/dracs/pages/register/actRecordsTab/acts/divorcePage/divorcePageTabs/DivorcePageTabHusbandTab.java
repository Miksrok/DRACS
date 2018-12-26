package ua.gov.nais.dracs.pages.register.actRecordsTab.acts.divorcePage.divorcePageTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;

public class DivorcePageTabHusbandTab extends AbstractPage {

    @FindBy(xpath = "//a[@href = '#tBoy']")
    private WebElement fianceTab;
    @FindBy (xpath = "(//label[text() = 'Прізвище до розірвання шлюбу'])[1]/following-sibling::input")
    private WebElement beforeSurname;
    @FindBy (xpath = "(//label[text() = 'Прізвище після розірвання шлюбу'])[1]/following-sibling::input")
    private WebElement afterSurname;
    @FindBy (xpath = "(//label[text() = 'Власне ім’я'])[1]/following-sibling::input")
    private WebElement name;
    @FindBy (xpath = "(//label[text() = 'По батькові'])[1]/following-sibling::input")
    private WebElement fatherName;
    @FindBy (xpath = "(//label[text() = 'Дата нар-ня'])[1]/following-sibling::div/div[2]/div/div/input")
    private WebElement dateOfBirth;
    @FindBy (xpath = "(//label[text() = 'Серія та № / Документ №'])[1]/following-sibling::input")
    private WebElement documentNumber;
    @FindBy (xpath = "(//label[text() = 'Дата видачі'])[1]/following-sibling::div/div/input")
    private WebElement documentDate;
    @FindBy (xpath = "(//label[text() = 'Ким виданий (орган, що видав)'])[1]/following-sibling::input")
    private WebElement documentPublisher;

    public DivorcePageTabHusbandTab(WebDriver driver) {
        super(driver);
    }

    public DivorcePageTabWifeTab addHusband(Person person){
        action.clickOnElement(fianceTab);
        action.typeText(beforeSurname, person.getSurname());
        action.typeText(afterSurname, person.getSurname());
        action.typeText(fatherName, person.getFatherName());
        action.typeText(name, person.getName()+person.getSurname());
        action.typeText(dateOfBirth, "12.12.1988");
        action.typeText(documentNumber, person.getPassport());
        action.typeText(documentDate, person.getPassportDate());
        action.typeText(documentPublisher, person.getPassportPublisher());
        return new DivorcePageTabWifeTab(driver);
    }
}
