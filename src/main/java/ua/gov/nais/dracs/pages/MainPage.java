package ua.gov.nais.dracs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage{

    @FindBy (xpath = "//span[text() = 'Актові записи']")
    private WebElement actRecordsTab;
    @FindBy (xpath = "//span[text() = 'Заяви']")
    private WebElement apllicationsTab;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openActRecordsTab(){
        action.clickOnElement(actRecordsTab);
    }

    public void openApplicationTab(){
        action.clickOnElement(apllicationsTab);
    }

}
