package ua.gov.nais.dracs.pages.register.applicationsTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.testng.Reporter;
import ua.gov.nais.dracs.models.ActRecord;

import ua.gov.nais.dracs.pages.AbstractPage;

public class ApplicationsTab extends AbstractPage {

    @FindBy(id = "acRegister")
    private WebElement creatNewApplication;
    @FindBy (xpath = "//label[text() = 'Вид заяви:']/following-sibling::select")
    private WebElement applicationTypeList;
    @FindBy (xpath = "//option[text() = 'про державну реєстрацію народження']")
    private WebElement birthRegistrationApplicationType;
    @FindBy (xpath = "//label[text() = 'Заповнити заяву для друку:']/following-sibling::input")
    private WebElement applicationForPrint;
    @FindBy (xpath = "//label[text() = 'Вхідний № заяви:']/following-sibling::input")
    private WebElement applicationNumber;
    @FindBy (xpath = "//span[text() = 'Зберегти']/parent::button")
    private WebElement saveButton;
    @FindBy (xpath = "//div[@id = 'confirm-message']/following-sibling::div/div/button/span[text() = 'OК']")
    private WebElement okButton;
    @FindBy (xpath = "//div[@id = 'alert-message-info']/following::span[text() = 'OК']")
    private WebElement okAlertButton;


    public ApplicationsTab(WebDriver driver) {
        super(driver);
    }

    public void creatNewApplication(){
        action.clickOnElement(creatNewApplication);
        Reporter.log("creat new app");
    }
    public String selectApplicationAndEnterMainInfo(ActRecord act){
        action.selectElementFromListByValue(applicationTypeList, "32");
        //action.clickOnElement(applicationTypeList);
       //action.clickOnElement(birthRegistrationApplicationType);
        action.clickOnElement(applicationForPrint);
        action.typeText(applicationNumber, act.getActNumber());
        return act.getActNumber();
    }

    public void saveApllication(){
        action.clickOnElement(saveButton);
        //action.clickOnElement(okButton);
        action.clickOnElement(okAlertButton);
        Reporter.log("save app"+"<br>");
    }
}
