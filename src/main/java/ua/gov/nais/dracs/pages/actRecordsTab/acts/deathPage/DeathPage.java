package ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class DeathPage extends AbstractPage {

    @FindBy(id = "acRegister")
    private WebElement creatNewAct;

    private WebElement generalTab;

    private WebElement informationAboutDocuments;
    private WebElement notesTab;
    private WebElement certificatesTab;

    public DeathPage(WebDriver driver) {
        super(driver);
    }

    public void creatNewAct(){
        action.clickOnElement(creatNewAct);
    }
}
