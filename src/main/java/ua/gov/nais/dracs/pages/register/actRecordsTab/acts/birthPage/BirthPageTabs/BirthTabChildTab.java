package ua.gov.nais.dracs.pages.register.actRecordsTab.acts.birthPage.BirthPageTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;

public class BirthTabChildTab extends AbstractPage {

    @FindBy(xpath = "//a[@href = '#tChild']")
    private WebElement openChildTab;

    @FindBy(xpath = "(//label[text() = 'Власне ім’я']/following-sibling::input)[1]")
    private WebElement name;

    @FindBy(xpath = "(//label[text() = 'Прізвище']/following-sibling::input)[1]")
    private WebElement surname;

    @FindBy(xpath = "(//label[text() = 'По батькові']/following-sibling::input)[1]")
    private WebElement fatherName;

    @FindBy(xpath = "(//label[text() = 'Дата нар-ня'])[1]/following-sibling::div/div/div/div/input")
    private WebElement birthdayDate;

    public BirthTabChildTab(WebDriver driver) {
        super(driver);
    }

    public BirthTabFatherTab enterInformationAboutChild(Person person) {
        action.clickOnElement(openChildTab);
        action.typeText(name, person.getName());
        action.typeText(surname, person.getSurname());
        action.typeText(fatherName, person.getFatherName());
        action.typeText(birthdayDate, "04.04.2018");
        return new BirthTabFatherTab(driver);
    }
}