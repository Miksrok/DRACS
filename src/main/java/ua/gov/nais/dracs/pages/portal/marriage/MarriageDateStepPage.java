package ua.gov.nais.dracs.pages.portal.marriage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class MarriageDateStepPage extends AbstractPage {

    @FindBy(xpath = "//select[@id = 'xRegions']")
    private WebElement regionsList;
    @FindBy(xpath = "//label[text() = 'Тип органу ДРАЦС']/following-sibling::select")
    private WebElement typesList;
    @FindBy(xpath = "//label[text() = 'Орган ДРАЦС']/following-sibling::select")
    private WebElement departmentsList;
    @FindBy(xpath = "(//input[@name = 'ceremony'])[1]")
    private WebElement ceremonyType;
    @FindBy(xpath = "//input[@name = 'zal']")
    private WebElement hall;
    @FindBy(xpath = "(//span[@class = 'st_not_reserved'])[last()]")
    private WebElement notReservedCeremonyTime;
    @FindBy(xpath = "//span[text() = 'Вибрати']/parent::button")
    private WebElement selectButton;
    @FindBy(xpath = "//span[text() = 'OК']/parent::button")
    private WebElement okButton;
    @FindBy(xpath = "//span[text() = 'Сплата послуги']/parent::button")
    private WebElement goToPaymentButton;

    public MarriageDateStepPage(WebDriver driver) {
        super(driver);
    }

    public void selectRegion(String value){
        action.selectElementFromListByValue(regionsList, value);
    }
    public void selectType(String value){
        action.selectElementFromListByValue(typesList, value);
    }
    public void selectDepartment(String value){
        action.selectElementFromListByValue(departmentsList, value);
    }
    public void selectCeremonyType(){
        action.clickOnElement(ceremonyType);
    }
    public void selectHall(){
        action.clickOnElement(hall);
    }
    public void selectTime(){
        action.clickOnElement(notReservedCeremonyTime);
    }
    public void clickSelectButton(){
        action.clickOnElement(selectButton);
    }
    public void clickOkButton(){
        action.clickOnElement(okButton);
    }
    public MarriagePaymentStepPage clickGoToPaymentButton(){
        action.clickOnElement(goToPaymentButton);
        return new MarriagePaymentStepPage(driver);
    }
}
