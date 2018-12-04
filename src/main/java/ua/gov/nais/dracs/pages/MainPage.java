package ua.gov.nais.dracs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;

public class MainPage extends AbstractPage{

    @FindBy (xpath = "//span[text() = 'Актові записи']")
    private WebElement actRecordsTab;
    @FindBy (xpath = "//span[text() = 'Заяви']")
    private WebElement apllicationsTab;
    @FindBy (xpath = "//span[text() = 'Витяги']")
    private WebElement extractTab;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public ActRecordsTab openActRecordsTab(){
        action.clickOnElement(actRecordsTab);
        return new ActRecordsTab(driver);
    }

    public void openApplicationTab(){
        action.clickOnElement(apllicationsTab);
        Reporter.log("open app tab");
    }

    public ExtractPage openExtractTab(){
        action.clickOnElement(extractTab);
        return new ExtractPage(driver);
    }

}
