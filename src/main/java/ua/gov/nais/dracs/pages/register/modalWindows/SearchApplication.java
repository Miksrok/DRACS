package ua.gov.nais.dracs.pages.register.modalWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class SearchApplication extends AbstractPage {

    @FindBy (id = "legend-filter-petition")
    private WebElement applicationRibbon;
    @FindBy (xpath = "//div[@id = 'incNumb']/input")
    private  WebElement incomingNumber;
    @FindBy (xpath = "(//span[text() = 'Знайти'])[2]")
    private WebElement searchButton;

    @FindBy (xpath = "(//span[text() = 'Прийняти']/parent::button)[9]")
    private WebElement acceptButton;

    private WebElement result;

    @FindBy (xpath = "//div[text() = 'Змінити дані блоку \"Відомості про заявника\"']" +
            "/ancestor::div[@id = 'confirm-message']" +
            "/following-sibling::div" +
            "/descendant::span[text() = 'OК']")
    private WebElement okAboutApplicant;
    @FindBy (xpath = "//div[text() = 'Замінити відомості щодо матері відомостями про заявника \"Матір\"?']" +
            "/../../.." +
            "/following-sibling::div" +
            "/descendant::span[text() = 'OK']")
    private WebElement okAboutMother;

    @FindBy (xpath = "//div[text() = 'Змінити відомості щодо батька відомостями про заявника \"Батько\"?']" +
            "/../../.." +
            "/following-sibling::div" +
            "/descendant::span[text() = 'OK']")
    private WebElement okAboutFather;
    @FindBy (xpath = "//div[text() = 'Замінити відомості щодо  дитини відомостями  з заяви про \"Дитину\"?']" +
            "/../../.." +
            "/following-sibling::div" +
            "/descendant::span[text() = 'OK']")
    private WebElement okAboutChild;

    public SearchApplication(WebDriver driver) {
        super(driver);
    }

    public void searchApp(String number){
        action.clickOnElement(applicationRibbon);
        action.typeText(incomingNumber, number);
        action.clickOnElement(searchButton);
        result = driver.findElement(By.xpath("//td[text() = '"+number+"']"));
        action.clickOnElement(result);
        action.clickOnElement(acceptButton);
        action.clickOnElement(okAboutApplicant);
        action.clickOnElement(okAboutMother);
        action.clickOnElement(okAboutFather);
        action.clickOnElement(okAboutChild);

    }

}
