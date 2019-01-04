package ua.gov.nais.dracs.pages.portal.marriage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class MarriageApplicationStepPage extends AbstractPage {

    @FindBy(xpath = "//input[@id = 'AP_RECEPT_DT']")
    private WebElement comfortDate;
    @FindBy(xpath = "//a[@id = 'ui-id-5']")
    private WebElement fianceTab;
    @FindBy(xpath = "//a[@id = 'ui-id-6']")
    private WebElement fianceeTab;

    @FindBy(xpath = "(//label[text() = 'Прізвище до реєстрації шлюбу']/following-sibling::input)[1]")
    private WebElement fianceSurnameBefore;
    @FindBy(xpath = "(//label[text() = 'Прізвище після реєстрації шлюбу']/following-sibling::input)[1]")
    private WebElement fianceSurnameAfter;
    @FindBy(xpath = "(//label[text() = 'Власне ім’я']/following-sibling::input)[1]")
    private WebElement fianceName;
    @FindBy(xpath = "(//label[text() = 'По батькові']/following-sibling::input)[1]")
    private WebElement fianceFatherName;
    @FindBy(xpath = "(//label[text() = 'Дата народження']/following-sibling::div/input)[1]")
    private WebElement fianceBirthDate;

    @FindBy(xpath = "(//label[text() = 'Прізвище до реєстрації шлюбу']/following-sibling::input)[2]")
    private WebElement fianceeSurnameBefore;
    @FindBy(xpath = "(//label[text() = 'Прізвище після реєстрації шлюбу']/following-sibling::input)[2]")
    private WebElement fianceeSurnameAfter;
    @FindBy(xpath = "(//label[text() = 'Власне ім’я']/following-sibling::input)[2]")
    private WebElement fianceeName;
    @FindBy(xpath = "(//label[text() = 'По батькові']/following-sibling::input)[2]")
    private WebElement fianceeFatherName;
    @FindBy(xpath = "(//label[text() = 'Дата народження']/following-sibling::div/input)[2]")
    private WebElement fianceeBirthDate;

    public MarriageApplicationStepPage(WebDriver driver) {
        super(driver);
    }
}
