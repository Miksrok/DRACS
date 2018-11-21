package ua.gov.nais.dracs.pages.actRecordsTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class ActRecordsTab extends AbstractPage {

    @FindBy (xpath = "//a[text() = 'про встановлення батьківства']")
    private WebElement parenthood;
    private WebElement nameChange;
    private WebElement birth;
    private WebElement divorce;
    private WebElement death;
    private WebElement adoption;
    private WebElement marriage;

    public ActRecordsTab(WebDriver driver) {
        super(driver);
    }

    public void selectParenthood(){
        action.clickOnElement(parenthood);
    }

}
