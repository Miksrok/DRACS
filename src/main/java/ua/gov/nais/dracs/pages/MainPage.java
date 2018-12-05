package ua.gov.nais.dracs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.applicationsTab.ApplicationsTab;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;

/**
 * Class describe main page.
 * Next page after login page.
 */
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

    /**
     * click and open act records tab
     * @return - ActRecordsTat.class object
     */
    public ActRecordsTab openActRecordsTab(){
        action.clickOnElement(actRecordsTab);
        return new ActRecordsTab(driver);
    }

    /**
     * click and open application tab
     * @return - ApplicationTab.class object
     */
    public ApplicationsTab openApplicationTab(){
        action.clickOnElement(apllicationsTab);
        return new ApplicationsTab(driver);
    }

    /**
     * click and open extract tab
     * @return - ExtractTab.class object
     */
    public ExtractPage openExtractTab(){
        action.clickOnElement(extractTab);
        return new ExtractPage(driver);
    }

}
