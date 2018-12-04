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
    @FindBy(xpath = "//option[text() = 'I:\\']")
    private WebElement deviceNameI;

    @FindBy(id = "edtPass")
    private WebElement keyPasswordField;

    @FindBy(xpath = "//button[contains(text(), 'Увійти')]")
    private WebElement enterButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage login(String login, String password, String key) {
        action.waitUntilDisappear(loadingAnimation);
        action.typeText(loginField, login);
        action.typeText(passwordField, password);
        action.clickOnElement(selectAcskList);
        action.clickOnElement(acskListItem);
        action.clickOnElement(selectAcskList);
        action.clickOnElement(selectKeyDeviceList);
        action.clickOnElement(keyDevice);
        action.clickOnElement(selectKeyDeviceList);
        action.clickOnElement(deviceNamesList);
        action.clickOnElement(deviceName);
        action.clickOnElement(deviceNamesList);
        action.typeText(keyPasswordField, key);
        action.clickOnElement(enterButton);
        return new MainPage(driver);
    }

}
