package ua.gov.nais.dracs.pages.register.modalWindows.extendSearchActRecords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.pages.register.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;

/**
 *extend search modal window
 */
public class ExtendSearch extends AbstractPage {

    @FindBy(xpath = "//fieldset[@id = 'extFilterPerson']")
    private WebElement openPersonRibbon;

    @FindBy(xpath = "//span[text() = 'Розширений пошук АЗ']" +
            "/parent::div/following-sibling::div" +
            "/descendant::span[text() ='Знайти']")
    private WebElement extfindButton;

    @FindBy(xpath = "(//span[text() ='Знайти'])[1]")
    private WebElement findButton;

    @FindBy(xpath = "//div[@id = 'ArDlgSearchArea']/table/tbody/tr[1]")
    private WebElement searchResult;

    @FindBy(xpath = "(//span[text() = 'Прийняти']/parent::button)[5]")
    private WebElement acceptButton;

    @FindBy(xpath = "//span[@id = 'ui-id-21']/parent::div/following-sibling::div[2]/div/button[1]")
    private WebElement noResultYesButton;

    public ExtendSearch(WebDriver driver) {
        super(driver);
    }

    /**
     * open ribbon "search by person data"
     * @return - SearchByPersonRibbon object
     */
    public SearchByPersonRibbon openPersonRibbon() {
        action.clickOnElement(openPersonRibbon);
        return new SearchByPersonRibbon(driver);
    }

    /**
     * method clicks the "find" button in the "open AR" window
     */
    public void clickFindButton() {
        action.clickOnElement(findButton);
    }

    /**
     *method clicks the "find" button in the "extend search AR" window
     */
    public void clickExtFindButton(){
        action.clickOnElement(extfindButton);
    }

    /**
     * method clicks button "Accept"
     */
    public void clickAcceptButton(){
        action.clickOnElement(searchResult);
        action.clickOnElement(acceptButton);
    }

    /**
     * method click button "Yes" in "Question" box if result not found
     */
    public void clickNoResultYesButton(){
        action.clickOnElement(noResultYesButton);
    }
}
