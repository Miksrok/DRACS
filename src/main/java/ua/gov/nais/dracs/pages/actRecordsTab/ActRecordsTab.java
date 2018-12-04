package ua.gov.nais.dracs.pages.actRecordsTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPage;

public class ActRecordsTab extends AbstractPage {


    @FindBy(xpath = "//a[text() = 'про встановлення батьківства']")
    private WebElement parenthood;

    @FindBy(xpath = "//a[text() = 'про зміну імені']")
    private WebElement nameChange;

    @FindBy(xpath = "//a[text() = 'про народження']")
    private WebElement birth;

    @FindBy(xpath = "//a[text() = 'про розірвання шлюбу']")
    private WebElement divorce;

    @FindBy(xpath = "//a[text() = 'про смерть']")
    private WebElement death;

    @FindBy(xpath = "//a[text() = 'про усиновлення']")
    private WebElement adoption;

    @FindBy(xpath = "//a[text() = 'про шлюб']")
    private WebElement marriage;

    // assert element
    @FindBy(xpath = "//h3")
    private WebElement actRecordTitle;


    public ActRecordsTab(WebDriver driver) {
        super(driver);
    }

    public void selectNameChange() {
        action.clickOnElement(nameChange);
    }

    public BirthPage selectBirth() {
        action.clickOnElement(birth);
        return new BirthPage(driver);
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

    public String getActRecordTitle() {
        return action.getText(actRecordTitle);
    }

}
