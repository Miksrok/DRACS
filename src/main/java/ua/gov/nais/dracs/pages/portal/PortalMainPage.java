package ua.gov.nais.dracs.pages.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.pages.portal.marriage.MarriageDateStepPage;
import ua.gov.nais.dracs.pages.register.actRecordsTab.acts.marriagePage.MarriagePage;

public class PortalMainPage extends AbstractPage {

    private WebElement marriageRegistration;
    private WebElement birthRegistration;
    private WebElement deathRegistration;
    private WebElement divorceRegistration;
    private WebElement changeNameRegistration;
    private WebElement otherApplicationRegistration;

    public PortalMainPage(WebDriver driver) {
        super(driver);
    }

    public MarriageDateStepPage openMarriageDateStepPage(){
        action.clickOnElement(marriageRegistration);
        return new MarriageDateStepPage(driver);
    }
}
