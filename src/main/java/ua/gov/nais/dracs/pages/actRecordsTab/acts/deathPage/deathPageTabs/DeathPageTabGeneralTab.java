package ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.deathPageTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class DeathPageTabGeneralTab extends AbstractPage {

    @FindBy (xpath = "(//label[text() = '№ АЗ']/../input)[1]")
    private WebElement actNoteNumberField;
    @FindBy (xpath = "(//label[text() = 'Дата складання АЗ'])[1]/../div/div[2]/div/div/input")
    private WebElement actNoteDateFideld;

    public DeathPageTabGeneralTab(WebDriver driver) {
        super(driver);
    }

    public void typeActNoteNumber(){
        action.typeText(actNoteNumberField, "1234567890");
        action.typeText(actNoteDateFideld, "11.11.2018");
    }
}
