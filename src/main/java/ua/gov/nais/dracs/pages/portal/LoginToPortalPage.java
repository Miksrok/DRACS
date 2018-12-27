package ua.gov.nais.dracs.pages.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class LoginToPortalPage extends AbstractPage {

    @FindBy (xpath = "//input[@id = 'UserName']")
    private WebElement loginField;
    @FindBy (xpath = "//input[@id = 'fake_password']")
    private WebElement passwordField;
    @FindBy (xpath = "//span[text() = 'Вхід'] ")
    private WebElement enterButton;

    public LoginToPortalPage(WebDriver driver) {
        super(driver);
    }

    public void enterLogin(String login){
        action.typeText(loginField, login);
    }
    public void enterPassword(String password){
        action.typeText(passwordField, password);
    }
    public void clickEnterButton(){
        action.clickOnElement(enterButton);
    }

    /**
     * this method includes actions:
     *  - enter login
     *  - enter password
     *  - click submit button
     * @param login - user login
     * @param password - user password
     */
    public void loginAction(String login, String password){
        enterLogin(login);
        enterPassword(password);
        clickEnterButton();
    }
}
