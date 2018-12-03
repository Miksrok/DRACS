package ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;

public class ExtendSearch extends AbstractPage {

    @FindBy(xpath = "//fieldset[@id = 'extFilterPerson']")
    private WebElement openPersonRibbon;

    @FindBy (xpath = "//span[text() = 'Розширений пошук АЗ']" +
            "/parent::div/following-sibling::div" +
            "/descendant::span[text() ='Знайти']")
    private WebElement findButton;

    public ExtendSearch(WebDriver driver) {
        super(driver);
    }

    public SearchByPersonRibbon openPersonRibbon(){
        action.clickOnElement(openPersonRibbon);
        return new SearchByPersonRibbon(driver);
    }
    public void clickFindButton(){
        action.clickOnElement(findButton);
    }
}
