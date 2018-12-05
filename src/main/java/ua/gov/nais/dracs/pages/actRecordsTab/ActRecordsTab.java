package ua.gov.nais.dracs.pages.actRecordsTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.DeathPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.divorcePage.DivorcePage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.marriagePage.MarriagePage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.nameChangePage.NameChangePage;

/**
 * class describe act records tab
 * this element (list) appears after user clicks on Act Records tab
 */
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

    /**
     * select name change act record
     *
     * @return - NameChangePage.class object
     */
    public NameChangePage selectNameChange() {
        action.clickOnElement(nameChange);
        return new NameChangePage(driver);
    }

    /**
     * select birth act record
     *
     * @return - BirthPage.class object
     */
    public BirthPage selectBirth() {
        action.clickOnElement(birth);
        return new BirthPage(driver);
    }

    public void selectParenthood() {
        action.clickOnElement(parenthood);
    }

    /**
     * select death act record
     *
     * @return - DeathPage.class object
     */
    public DeathPage selectDeath() {
        action.clickOnElement(death);
        return new DeathPage(driver);
    }

    public void selectAdoption() {
        action.clickOnElement(adoption);
    }

    /**
     * select marriage act record
     *
     * @return - MarriagePage.class object
     */
    public MarriagePage selectMarriage() {
        action.clickOnElement(marriage);
        return new MarriagePage(driver);
    }

    /**
     * select divorce act record
     *
     * @return - DivorcePage.class object
     */
    public DivorcePage selectDivorce() {
        action.clickOnElement(divorce);
        return new DivorcePage(driver);
    }

    /**
     * technical element for asserts
     *
     * @return - String with act record title
     */
    public String getActRecordTitle() {
        return action.getText(actRecordTitle);
    }

}
