package ua.gov.nais.dracs.pages.register.actRecordsTab.acts.nameChangePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.pages.register.actRecordsTab.acts.nameChangePage.nameChangePageTabs.NameChangeTabGeneralTab;
import ua.gov.nais.dracs.pages.register.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.register.modalWindows.extendSearchActRecords.ExtendSearch;

public class NameChangePage extends AbstractPage {

    @FindBy(id = "acRegister")
    private WebElement createNewAct;
    @FindBy (xpath = "(//span[text() = 'Зберегти'])[1]")
    private WebElement saveButton;
    @FindBy (xpath = "//div[@id = 'confirm-message']/following-sibling::div/div/button/span[text() = 'OК']")
    private WebElement okButton;
    @FindBy (xpath = "//div[@id = 'alert-message-info']/following::span[text() = 'OК']")
    private WebElement okAlertButton;
    @FindBy (xpath = "//a[@id = 'searchbox-open']")
    private WebElement extendSearchLink;
    @FindBy (xpath = "//a[@id = 'acCreateExt']")
    private WebElement createExtract;

    public NameChangePage(WebDriver driver) {
        super(driver);
    }

    public NameChangeTabGeneralTab createNewAct(){
        action.clickOnElement(createNewAct);
        return new NameChangeTabGeneralTab(driver);
    }
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
