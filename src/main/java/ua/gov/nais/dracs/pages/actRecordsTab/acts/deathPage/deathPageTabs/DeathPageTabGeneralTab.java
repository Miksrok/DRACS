package ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.deathPageTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;

public class DeathPageTabGeneralTab extends AbstractPage {

    @FindBy (xpath = "(//label[text() = '№ АЗ']/../input)[1]")
    private WebElement actNoteNumberField;
    @FindBy (xpath = "(//label[text() = 'Дата складання АЗ'])[1]/../div/div[2]/div/div/input")
    private WebElement actNoteDateField;

    public DeathPageTabGeneralTab(WebDriver driver) {
        super(driver);
    }

    public void typeActNoteNumber(ActRecord act){
        action.typeText(actNoteNumberField, act.getActNumber());
        action.typeText(actNoteDateField, act.getActDate());
    }
}
