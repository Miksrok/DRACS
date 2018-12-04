package ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.deathPageTabs.DeathPageTabGeneralTab;

public class DeathPage extends AbstractPage {

    @FindBy(id = "acRegister")
    private WebElement creatNewAct;
    @FindBy (xpath = "(//span[text() = 'Зберегти'])[1]")
    private WebElement saveButton;
    @FindBy (xpath = "//div[@id = 'confirm-message']/following-sibling::div/div/button/span[text() = 'OК']")
    private WebElement okButton;
    @FindBy (xpath = "//div[@id = 'alert-message-info']/following::span[text() = 'OК']")
    private WebElement okAlertButton;

    private WebElement generalTab;

    private WebElement informationAboutDocuments;
    private WebElement notesTab;
    private WebElement certificatesTab;

    public DeathPage(WebDriver driver) {
        super(driver);
    }

    public DeathPageTabGeneralTab creatNewAct(){
        action.clickOnElement(creatNewAct);
        return new DeathPageTabGeneralTab(driver);
    }
    public void saveAct(){
        action.clickOnElement(saveButton);
        action.clickOnElement(okButton);
        action.clickOnElement(okAlertButton);
    }
}
