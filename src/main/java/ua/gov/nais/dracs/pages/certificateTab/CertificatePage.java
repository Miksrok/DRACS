package ua.gov.nais.dracs.pages.certificateTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.util.RobotForPrintBox;

public class CertificatePage extends AbstractPage {

    @FindBy (xpath = "//button[@id = 'CreateCertificate']")
    private WebElement createCertificateButton;

    @FindBy (xpath = "//span[text() = 'Так']")
    private WebElement yesButton;

    @FindBy (xpath = "//div[@id = 'alert-message-info']/following::span[text() = 'OК']")
    private WebElement okAlertButton;

    public CertificatePage(WebDriver driver) {
        super(driver);
    }

    public void createCertificate(String number){
        action.clickOnElement(createCertificateButton);
        wait5Sec();
        RobotForPrintBox robot = new RobotForPrintBox();
        robot.saveCertificate(number);
        wait5Sec();
        action.clickOnElement(yesButton);
        action.clickOnElement(okAlertButton);

    }
    private void wait5Sec(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
