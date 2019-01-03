package ua.gov.nais.dracs.pages.portal.marriage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class MarriageApplicationStepPage extends AbstractPage {

    @FindBy(xpath = "//input[@id = 'AP_RECEPT_DT']")
    private WebElement comfortDate;
    @FindBy(xpath = "//a[@id = 'ui-id-5']")
    private WebElement fianceTab;
    @FindBy(xpath = "//a[@id = 'ui-id-6']")
    private WebElement fianceeTab;

    public MarriageApplicationStepPage(WebDriver driver) {
        super(driver);
    }
}
