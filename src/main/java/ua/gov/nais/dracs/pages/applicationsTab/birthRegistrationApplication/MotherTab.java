package ua.gov.nais.dracs.pages.applicationsTab.birthRegistrationApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.pages.modalWindows.Address;

public class MotherTab extends AbstractPage {

    @FindBy (xpath = "//a[@href = '#HS2']")
    private WebElement openMotherTab;
    @FindBy(xpath = "(//h3[contains(text(), 'Особові дані')])[2]/following-sibling::div/div/label[text() = 'Прізвище']/following-sibling::input[1]")
    private WebElement surname;
    @FindBy (xpath = "(//h3[contains(text(), 'Особові дані')])[2]/following-sibling::div/div/label[text() = 'Власне ім’я']/following-sibling::input[1]")
    private WebElement name;
    @FindBy (xpath = "(//h3[contains(text(), 'Особові дані')])[2]/following-sibling::div/div/label[text() = 'По батькові']/following-sibling::input[1]")
    private WebElement fatherName;
    @FindBy (xpath = "(//label[text() = 'Дата нар-ня'])[3]/following-sibling::div/div/div/div/input")
    private WebElement birthDate;
    @FindBy (xpath = "(//label[text() = 'Серія та № / Документ №'])[3]/following-sibling::input")
    private WebElement documentNumber;
    @FindBy (xpath = "(//label[text() = 'Дата видачі'])[3]/following-sibling::div/div/input")
    private WebElement documentDate;
    @FindBy (xpath = "(//label[text() = 'Ким виданий (орган, що видав)'])[3]/following-sibling::input")
    private WebElement documentPublisher;
    @FindBy (xpath = "(//span[text() = 'Копіювати'])[4]")
    private WebElement copyAddress;

    public MotherTab(WebDriver driver) {
        super(driver);
    }

    public void enterInformationAboutMother(Person person){
        action.clickOnElement(openMotherTab);
        action.typeText(surname, person.getSurname());
        action.typeText(name, person.getName() + person.getSurname());
        action.typeText(fatherName, person.getFatherName());
        action.typeText(birthDate, "28.11.1988");
        action.typeText(documentNumber, person.getPassport().replace('9', '0'));
        action.typeText(documentDate, person.getPassportDate());
        action.typeText(documentPublisher, person.getPassportPublisher());
        action.clickOnElement(copyAddress);
        Reporter.log("about mother"+"<br>");
    }

}
