package ua.gov.nais.dracs.pages.register.actRecordsTab.acts.birthPage.BirthPageTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;

public class BirthTabMotherTab extends AbstractPage {

    @FindBy(xpath = "//a[@href = '#tMather']")
    private WebElement openMotherTab;

    @FindBy(xpath = "(//label[text() = 'Власне ім’я']/following-sibling::input)[5]")
    private WebElement name;

    @FindBy(xpath = "(//label[text() = 'Прізвище']/following-sibling::input)[7]")
    private WebElement surname;

    @FindBy(xpath = "(//label[text() = 'По батькові']/following-sibling::input)[3]")
    private WebElement fatherName;

    @FindBy(xpath = "(//label[text() = 'Дата нар-ня'])[3]/following-sibling::div/div/div/div/input")
    private WebElement birthdayDate;

    public BirthTabMotherTab(WebDriver driver) {super(driver); }

    public void enterInformationAboutMother(Person person) {
        action.clickOnElement(openMotherTab);
        action.typeText(name, person.getName());
        action.typeText(surname, person.getSurname());
        action.typeText(fatherName, person.getFatherName());
        action.typeText(birthdayDate, "04.04.1988");
    }

}
