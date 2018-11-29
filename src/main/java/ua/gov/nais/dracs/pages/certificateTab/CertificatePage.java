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

    }
    private void wait5Sec(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
