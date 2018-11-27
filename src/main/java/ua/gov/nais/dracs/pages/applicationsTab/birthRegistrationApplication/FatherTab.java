package ua.gov.nais.dracs.pages.applicationsTab.birthRegistrationApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.pages.modalWindows.Address;

public class FatherTab extends AbstractPage {

    @FindBy (xpath = "//a[@href = '#HS1']")
    private WebElement openFatherTab;
    @FindBy (xpath = "(//h3[contains(text(), 'Особові дані')])[1]/following-sibling::div/div/label[text() = 'Прізвище']/following-sibling::input[1]")
    private WebElement surname;
    @FindBy (xpath = "(//h3[contains(text(), 'Особові дані')])[1]/following-sibling::div/div/label[text() = 'Власне ім’я']/following-sibling::input[1]")
    private WebElement name;
    @FindBy (xpath = "(//h3[contains(text(), 'Особові дані')])[1]/following-sibling::div/div/label[text() = 'По батькові']/following-sibling::input[1]")
    private WebElement fatherName;
    @FindBy (xpath = "(//label[text() = 'Дата нар-ня'])[2]/following-sibling::div/div/div/div/input")
    private WebElement birthDate;
    @FindBy (xpath = "(//label[text() = 'Серія та № / Документ №'])[2]/following-sibling::input")
    private WebElement documentNumber;
    @FindBy (xpath = "(//label[text() = 'Дата видачі'])[2]/following-sibling::div/div/input")
    private WebElement documentDate;
    @FindBy (xpath = "(//label[text() = 'Ким виданий (орган, що видав)'])[2]/following-sibling::input")
    private WebElement documentPublisher;
    @FindBy (xpath = "(//span[text() = 'Адреса']/..)[3]")
    private WebElement addressButton;

    public FatherTab(WebDriver driver) {
        super(driver);
    }

    public void enterInformationAboutFather(Person person){
        action.clickOnElement(openFatherTab);
        action.typeText(surname, person.getSurname());
        action.typeText(name, person.getName());
        action.typeText(fatherName, person.getFatherName());
        action.typeText(birthDate, "28.11.1988");
        action.typeText(documentNumber, person.getPassport());
        action.typeText(documentDate, person.getPassportDate());
        action.typeText(documentPublisher, person.getPassportPublisher());
        action.clickOnElement(addressButton);
        Address address = new Address(driver);
        address.enterAddress();

    }

}
