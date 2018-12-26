package ua.gov.nais.dracs.pages.register.actRecordsTab.acts.deathPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.pages.register.actRecordsTab.acts.deathPage.deathPageTabs.DeathPageTabGeneralTab;
import ua.gov.nais.dracs.pages.register.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.register.modalWindows.extendSearchActRecords.ExtendSearch;

public class DeathPage extends AbstractPage {

    @FindBy(id = "acRegister")
    private WebElement creatNewAct;
    @FindBy(xpath = "(//span[text() = 'Зберегти'])[1]")
    private WebElement saveButton;
    @FindBy(xpath = "//div[@id = 'confirm-message']/following-sibling::div/div/button/span[text() = 'OК']")
    private WebElement okButton;
    @FindBy(xpath = "//div[@id = 'alert-message-info']/following::span[text() = 'OК']")
    private WebElement okAlertButton;
    @FindBy (xpath = "//a[@id = 'searchbox-open']")
    private WebElement extendSearchLink;
    @FindBy (xpath = "//a[@id = 'acCreateExt']")
    private WebElement createExtract;

    public DeathPage(WebDriver driver) {
        super(driver);
    }

    /**
     * .
     * click on Create New Act button
     *
     * @return - DeathPageTabGeneralTab.class object
     */
    public DeathPageTabGeneralTab createNewAct() {
        action.clickOnElement(creatNewAct);
        return new DeathPageTabGeneralTab(driver);
    }

    /**
     * save act record
     */
    public void saveAct() {
        action.clickOnElement(saveButton);
        action.clickOnElement(okButton);
        action.clickOnElement(okAlertButton);
    }
    public ExtendSearch openExtendSearchModalWindow(){
        action.clickOnElement(extendSearchLink);
        return new ExtendSearch(driver);
    }
    public void selectSearchResult(String surname, String name, String fatherName){
        WebElement element = driver.findElement(By.xpath("//td[text() = '"+ surname + " " + name + " " + fatherName+"']"));
        action.clickOnElement(element);
    }
    public ExtractPage clickCreateExtract(){
        action.clickOnElement(createExtract);
        return new ExtractPage(driver);
    }
}
