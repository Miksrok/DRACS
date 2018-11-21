package ua.gov.nais.dracs.pages.actRecordsTab.acts.parenthoodPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

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

    public ParenthoodPage(WebDriver driver) {
        super(driver);
    }

    public void creatNewAct(){
        action.clickOnElement(creatNewAct);
    }

}
