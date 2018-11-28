package ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class BirthPage extends AbstractPage {

    @FindBy(id = "acRegister")
    private WebElement createNewAct;
    @FindBy (xpath = "//span[text() = 'Зберегти та друкувати']/parent::button")
    private WebElement saveAndPrintButton;
    @FindBy (xpath = "(//span[text() = 'Зберегти'])[1]")
    private WebElement saveButton;
    @FindBy (xpath = "//div[@id = 'confirm-message']/following-sibling::div/div/button/span[text() = 'OК']")
    private WebElement okButton;
    @FindBy (xpath = "//div[@id = 'alert-message-info']/following::span[text() = 'OК']")
    private WebElement okAlertButton;

    public BirthPage(WebDriver driver) {super(driver);}

    public void createNewAct(){
        action.clickOnElement(createNewAct);
    }
    public void saveAct() {
        action.clickOnElement(saveButton);
        action.clickOnElement(okButton);
        action.clickOnElement(okAlertButton);
    }
    public void saveAndPrint(){
        action.clickOnElement(saveAndPrintButton);
        action.clickOnElement(okButton);
        action.clickOnElement(okAlertButton);
    }
}

