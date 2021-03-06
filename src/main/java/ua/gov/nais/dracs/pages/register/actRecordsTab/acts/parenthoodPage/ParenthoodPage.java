package ua.gov.nais.dracs.pages.register.actRecordsTab.acts.parenthoodPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.pages.register.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.register.modalWindows.extendSearchActRecords.ExtendSearch;

public class ParenthoodPage extends AbstractPage {

    @FindBy (id = "acRegister")
    private WebElement creatNewAct;
    @FindBy (xpath = "//a[@href = '#tmain']")
    private WebElement generalTab;
    @FindBy (xpath = "//a[@href = '#tChild']")
    private WebElement childTab;
    @FindBy (xpath = "//a[@href = '#tFather']")
    private WebElement fatherTab;
    @FindBy ( xpath = "//a[@href = '#tMather']")
    private WebElement motherTab;
    private WebElement notesTab;
    private WebElement certificatesTab;
    @FindBy (xpath = "//a[@id = 'searchbox-open']")
    private WebElement extendSearchLink;
    @FindBy (xpath = "//a[@id = 'acCreateExt']")
    private WebElement createExtract;

    public ParenthoodPage(WebDriver driver) {
        super(driver);
    }

    public void creatNewAct(){
        action.clickOnElement(creatNewAct);
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
