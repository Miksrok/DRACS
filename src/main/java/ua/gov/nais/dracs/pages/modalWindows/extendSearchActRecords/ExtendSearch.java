package ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;

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

    public ExtendSearch(WebDriver driver) {
        super(driver);
    }

    public SearchByPersonRibbon openPersonRibbon() {
        action.clickOnElement(openPersonRibbon);
        return new SearchByPersonRibbon(driver);
    }

    public void clickFindButton() {
        action.clickOnElement(findButton);
    }
    public void clickExtFindButton(){
        action.clickOnElement(extfindButton);
    }
    public void clickAcceptButton(){
        action.clickOnElement(searchResult);
        action.clickOnElement(acceptButton);
    }
}
