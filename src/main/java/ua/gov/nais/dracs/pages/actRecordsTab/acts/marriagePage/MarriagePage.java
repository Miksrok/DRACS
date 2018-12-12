package ua.gov.nais.dracs.pages.actRecordsTab.acts.marriagePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.marriagePage.marriagePageTabs.MarriagePageTabGeneralTab;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;

public class MarriagePage extends AbstractPage {

    @FindBy(id = "acRegister")
    private WebElement creatNewAct;
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

    public MarriagePage(WebDriver driver) {
        super(driver);
    }

    public MarriagePageTabGeneralTab createNewAct(){
        action.clickOnElement(creatNewAct);
        return new MarriagePageTabGeneralTab(driver);
    }
    public void saveAct(){
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
