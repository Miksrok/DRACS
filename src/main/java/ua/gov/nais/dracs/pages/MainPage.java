package ua.gov.nais.dracs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage{

    @FindBy (xpath = "//span[text() = 'Актові записи']")
    private WebElement actRecordsTab;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openActRecordsTab(){
        action.clickOnElement(actRecordsTab);
    }

}
