package ua.gov.nais.dracs.pages.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.pages.portal.marriage.MarriageDateStepPage;
import ua.gov.nais.dracs.pages.register.actRecordsTab.acts.marriagePage.MarriagePage;

public class PortalMainPage extends AbstractPage {

    @FindBy(xpath = "//a[@href = '/Reserv/StageOne/0']")
    private WebElement marriageRegistration;
    @FindBy(xpath = "//a[@href = '/Main_menu/Birht/0']")
    private WebElement birthRegistration;
    @FindBy(xpath = "//a[@href = '/Main_menu/Death']")
    private WebElement deathRegistration;
    @FindBy(xpath = "//a[@href = '/Main_menu/Divorce']")
    private WebElement divorceRegistration;
    @FindBy(xpath = "//a[@href = '/Main_menu/Name_Change']")
    private WebElement changeNameRegistration;
    @FindBy(xpath = "//a[@href = '/Main_menu/AR']")
    private WebElement otherApplicationRegistration;

    public PortalMainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * open page for creation marriage application
     *
     * @return  - MarriageDateStepPage object
     */
    public MarriageDateStepPage openMarriageDateStepPage(){
        action.clickOnElement(marriageRegistration);
        return new MarriageDateStepPage(driver);
    }
}
