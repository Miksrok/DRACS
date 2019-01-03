package ua.gov.nais.dracs.pages.portal.marriage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class MarriagePaymentStepPage extends AbstractPage {

    @FindBy(xpath = "//input[@id ='ap_is_exemption_pay']")
    private WebElement paymentFreeCheckbox;
    @FindBy(xpath = "//a[@id = 'step3']")
    private WebElement goToApplicationButton;

    public MarriagePaymentStepPage(WebDriver driver) {
        super(driver);
    }

    public void checkPaymentFreeCheckbox(){
        action.clickOnElement(paymentFreeCheckbox);
    }
    public MarriageApplicationStepPage clickGoToApplicationButtton(){
        action.clickOnElement(goToApplicationButton);
        return new MarriageApplicationStepPage(driver);
    }
}
