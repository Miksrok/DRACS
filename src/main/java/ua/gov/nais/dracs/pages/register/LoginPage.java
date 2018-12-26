package ua.gov.nais.dracs.pages.register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

/**
 * this class describe login page
 * page link  "https://regdracs.test.nais.gov.ua/"
 */
public class LoginPage extends AbstractPage {

    private final String ACSK = "ca.informjust.ua";
    private final String DEVICE_TYPE_USB_DRIVE = "1";
    private final String I_DEVICE_NAME = "I:\\";
    private final String J_DEVICE_NAME = "J:\\";

    @FindBy(id = "loading_animation_all")
    private WebElement loadingAnimation;

    @FindBy(id = "edtLogin")
    private WebElement loginField;

    @FindBy(id = "edtLPass")
    private WebElement passwordField;

    @FindBy(id = "selACSK")
    private WebElement selectAcskList;

    @FindBy(id = "selDevType")
    private WebElement selectKeyDeviceList;

    @FindBy(id = "selDevName")
    private WebElement deviceNamesList;

    @FindBy(id = "edtPass")
    private WebElement keyPasswordField;

    @FindBy(xpath = "//button[@class = 'btn-green']")
    private WebElement enterButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * this method enters login and password, selects ACSK and device type,
     * enters e-key password.
     *
     * user authorization
     *
     * @param login - login
     * @param password - password
     * @param key - password for e-key
     * @return - MainPage.class object
     */
    public MainPage login(String login, String password, String key) {
        action.waitUntilDisappear(loadingAnimation);
        action.typeText(loginField, login);
        action.typeText(passwordField, password);
        action.selectElementFromListByValue(selectAcskList, ACSK);
        action.selectElementFromListByValue(selectKeyDeviceList, DEVICE_TYPE_USB_DRIVE);
        action.clickOnElement(deviceNamesList);
        if (login.equals("testreg")) {
            action.selectElementFromListByText(deviceNamesList, I_DEVICE_NAME);
        } else if (login.equals("testnot")) {
            action.selectElementFromListByText(deviceNamesList, J_DEVICE_NAME);
        }
        action.typeText(keyPasswordField, key);
        action.clickOnElement(enterButton);
        return new MainPage(driver);
    }

    /*
    @FindBy(xpath = "//option[@value = 'ca.informjust.ua']")
    private WebElement acskListItem;
    @FindBy(xpath = "//option[@value = '1']")
    private WebElement keyDevice;
    @FindBy(xpath = "//option[text() = 'J:\\']")
    private WebElement deviceNameJ;
    @FindBy(xpath = "//option[text() = 'I:\\']")
    private WebElement deviceNameI;
    */

}
