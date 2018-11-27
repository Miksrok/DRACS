package ua.gov.nais.dracs.pages.modalWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class SearchApplication extends AbstractPage {

    @FindBy (id = "legend-filter-petition")
    private WebElement applicationRibbon;
    @FindBy (id = "incNumb")
    private  WebElement incomingNumber;
    @FindBy (xpath = "(//span[text() = 'Знайти'])[2]")
    private WebElement searchButton;

    public SearchApplication(WebDriver driver) {
        super(driver);
    }

    public void searchApp(String number){
        action.clickOnElement(applicationRibbon);
        //incomingNumber.sendKeys(number);
        action.typeText(incomingNumber, number);
        action.clickOnElement(searchButton);
    }

}
