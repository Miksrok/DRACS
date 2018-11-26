package ua.gov.nais.dracs.pages.actRecordsTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class ActRecordsTab extends AbstractPage {

    @FindBy(xpath = "//a[text() = 'про встановлення батьківства']")
    private WebElement parenthood;

    @FindBy(xpath = "//a[text() = 'про зміну імені']")
    private WebElement nameChange;

    private WebElement birth;

    @FindBy(xpath = "//a[text() = 'про розірвання шлюбу']")
    private WebElement divorce;

    @FindBy(xpath = "//a[text() = 'про смерть']")
    private WebElement death;

    @FindBy(xpath = "//a[text() = 'про усиновлення']")
    private WebElement adoption;

    @FindBy(xpath = "//a[text() = 'про шлюб']")
    private WebElement marriage;

    public ActRecordsTab(WebDriver driver) {
        super(driver);
    }

    public void selectNameChange() {
        action.clickOnElement(nameChange);
    }

    public void selectParenthood() {
        action.clickOnElement(parenthood);
    }

    public void selectDeath() {
        action.clickOnElement(death);
    }

    public void selectAdoption() {
        action.clickOnElement(adoption);
    }

    public void selectMarriage() {
        action.clickOnElement(marriage);
    }

    public void selectDivorce() {
        action.clickOnElement(divorce);
    }

}
