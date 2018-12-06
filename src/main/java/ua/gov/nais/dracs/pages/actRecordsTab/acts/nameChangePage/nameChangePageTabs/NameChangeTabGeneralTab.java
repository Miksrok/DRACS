package ua.gov.nais.dracs.pages.actRecordsTab.acts.nameChangePage.nameChangePageTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;

public class NameChangeTabGeneralTab extends AbstractPage {

    @FindBy(xpath = "(//label[text() = '№ АЗ']/../input)[1]")
    private WebElement actNoteNumberField;

    @FindBy (xpath = "(//label[text() = 'Дата складання АЗ'])[1]/../div/div[2]/div/div/input")
    private WebElement actNoteDateField;

    @FindBy (xpath = "(//label[text() = 'Дата реєстрації зміни імені'])[1]/../div/div[2]/div/div/input")
    private WebElement dateOfRegistrationOfNameChangeField;



    public NameChangeTabGeneralTab(WebDriver driver) {
        super(driver);
    }

    public NameChangeTabSubjectTab typeActNoteNumber(ActRecord act){
        action.typeText(actNoteNumberField,act.getActNumber());
        action.typeText(actNoteDateField,act.getActDate());
        action.typeText(dateOfRegistrationOfNameChangeField,"08.04.2018");
        return new NameChangeTabSubjectTab(driver);

    }

    public void typeDateOfRegOfNameChange() {
        action.typeText(dateOfRegistrationOfNameChangeField,"08.04.2018");
    }
}
