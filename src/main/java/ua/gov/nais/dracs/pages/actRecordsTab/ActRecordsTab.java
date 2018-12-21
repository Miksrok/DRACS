package ua.gov.nais.dracs.pages.actRecordsTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.adoptionPage.AdoptionPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.DeathPage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.divorcePage.DivorcePage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.marriagePage.MarriagePage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.nameChangePage.NameChangePage;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.parenthoodPage.ParenthoodPage;

/**
 * class describe act records tab
 * this element (list) appears after user clicks on Act Records tab
 */
public class ActRecordsTab extends AbstractPage {


    @FindBy(xpath = "//a[@href = '/ActRecord/Index?RC_AR_TYPE=2&RC_MENU=1']")
    private WebElement parenthood;

    @FindBy(xpath = "//a[@href = '/ActRecord/Index?RC_AR_TYPE=4&RC_MENU=1']")
    private WebElement nameChange;

    @FindBy(xpath = "//a[@href = '/ActRecord/Index?RC_AR_TYPE=3&RC_MENU=1']")
    private WebElement birth;

    @FindBy(xpath = "//a[@href = '/ActRecord/Index?RC_AR_TYPE=6&RC_MENU=1']")
    private WebElement divorce;

    @FindBy(xpath = "//a[@href = '/ActRecord/Index?RC_AR_TYPE=5&RC_MENU=1']")
    private WebElement death;

    @FindBy(xpath = "//a[@href = '/ActRecord/Index?RC_AR_TYPE=1&RC_MENU=1']")
    private WebElement adoption;

    @FindBy(xpath = "//a[@href = '/ActRecord/Index?RC_AR_TYPE=7&RC_MENU=1']")
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

    /**
     * select death act record
     *
     * @return - DeathPage.class object
     */
    public DeathPage selectDeath() {
        action.clickOnElement(death);
        return new DeathPage(driver);
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
     * select parenthood act record
     * @return - ParenthoodPage.class object
     */
    public ParenthoodPage selectParenthood() {
        action.clickOnElement(parenthood);
        return new ParenthoodPage(driver);
    }

    /**
     * select adoption act record
     *
     * @return - AdoptionPage.class object
     */
    public AdoptionPage selectAdoption() {
        action.clickOnElement(adoption);
        return new AdoptionPage(driver);
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
