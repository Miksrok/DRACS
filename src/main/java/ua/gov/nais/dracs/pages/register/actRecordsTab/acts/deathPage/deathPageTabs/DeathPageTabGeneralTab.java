package ua.gov.nais.dracs.pages.register.actRecordsTab.acts.deathPage.deathPageTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.pages.AbstractPage;

/**
 * class describe death act general tab
 */
public class DeathPageTabGeneralTab extends AbstractPage {

    @FindBy(xpath = "(//label[text() = '№ АЗ']/../input)[1]")
    private WebElement actNoteNumberField;
    @FindBy(xpath = "(//label[text() = 'Дата складання АЗ'])[1]/../div/div[2]/div/div/input")
    private WebElement actNoteDateField;

    public DeathPageTabGeneralTab(WebDriver driver) {
        super(driver);
    }

    /**
     * enter information about act record
     *
     * @param act - information about act record (number and date)
     * @return - DeathPageTabDeadTab.class object, next tab
     * @see ActRecord
     */
    public DeathPageTabDeadTab typeActNoteNumber(ActRecord act) {
        action.typeText(actNoteNumberField, act.getActNumber());
        action.typeText(actNoteDateField, act.getActDate());
        return new DeathPageTabDeadTab(driver);
    }
}
