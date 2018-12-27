package ua.gov.nais.dracs.pages.register.actRecordsTab.acts.birthPage.BirthPageTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;

public class BirthTabFatherTab extends AbstractPage {

    @FindBy(xpath = "//a[@href = '#tFather']")
    private WebElement openFatherTab;

    @FindBy(xpath = "(//label[text() = 'Власне ім’я']/following-sibling::input)[3]")
    private WebElement name;

    @FindBy(xpath = "(//label[text() = 'Прізвище']/following-sibling::input)[4]")
    private WebElement surname;

    @FindBy(xpath = "(//label[text() = 'По батькові']/following-sibling::input)[2]")
    private WebElement fatherName;

    @FindBy(xpath = "(//label[text() = 'Дата нар-ня'])[2]/following-sibling::div/div/div/div/input")
    private WebElement birthdayDate;

    @FindBy(xpath = "//label[text() = 'Підстава запису відомостей про батька']/following-sibling::textarea")
    private WebElement reasonAboutFather;

    public BirthTabFatherTab(WebDriver driver) {
        super(driver);
    }

    public void enterInformationAboutFather(Person person) {
        action.typeText(name, person.getName());
        action.typeText(surname, person.getSurname());
        action.typeText(fatherName, person.getFatherName());
        action.typeText(birthdayDate, "04.04.1988");
    }

    public void openFatherTab() {
        action.clickOnElement(openFatherTab);
    }

    public BirthTabMotherTab typeReason() {
        action.typeText(reasonAboutFather, "Заява матері");
        return new BirthTabMotherTab(driver);
    }
}

