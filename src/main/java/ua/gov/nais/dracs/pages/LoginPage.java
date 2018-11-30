package ua.gov.nais.dracs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

    @FindBy(id = "loading_animation_all")
    private WebElement loadingAnimation;

    @FindBy(id = "edtLogin")
    private WebElement loginField;

    @FindBy(id = "edtLPass")
    private WebElement passwordField;

    @FindBy(id = "selACSK")
    private WebElement selectAcskList;

    @FindBy(xpath = "//option[@value = 'ca.informjust.ua']")
    private WebElement acskListItem;

    @FindBy(id = "selDevType")
    private WebElement selectKeyDeviceList;

    @FindBy(xpath = "//option[@value = '1']")
    private WebElement keyDevice;

    @FindBy(id = "selDevName")
    private WebElement deviceNamesList;

    @FindBy(xpath = "//option[text() = 'J:\\']")
    private WebElement deviceName;

    @FindBy(id = "edtPass")
    private WebElement keyPasswordField;

    @FindBy(xpath = "//button[contains(text(), 'Увійти')]")
    private WebElement enterButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        action.waitUntilDisappear(loadingAnimation);
        action.typeText(loginField, "testnot");
        action.typeText(passwordField, "123456789");
        action.clickOnElement(selectAcskList);
        action.clickOnElement(acskListItem);
        action.clickOnElement(selectAcskList);
        action.clickOnElement(selectKeyDeviceList);
        action.clickOnElement(keyDevice);
        action.clickOnElement(selectKeyDeviceList);
        action.clickOnElement(deviceNamesList);
        action.clickOnElement(deviceName);
        action.clickOnElement(deviceNamesList);
        action.typeText(keyPasswordField, "KJ146apb");
        action.clickOnElement(enterButton);
    }

}
