package ua.gov.nais.dracs.pages.actRecordsTab.acts.nameChange.nameChangeTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class NameChageTabGeneralTab extends AbstractPage {

    @FindBy(xpath = "(//label[text() = '№ АЗ']/../input)[1]")
    private WebElement actNoteNumberField;

    @FindBy (xpath = "(//label[text() = 'Дата складання АЗ'])[1]/../div/div[2]/div/div/input")
    private WebElement actNoteDateField;

    @FindBy (xpath = "(//label[text() = 'Дата реєстрації зміни імені'])[1]/../div/div[2]/div/div/input")
    private WebElement dateOfRegistrationOfNameChangeField;

    public NameChageTabGeneralTab(WebDriver driver) {
        super(driver);
    }

    public void typeActNoteNumber(){
        action.typeText(actNoteNumberField, "1448567890");
        action.typeText(actNoteDateField, "04.08.2018");
    }

    public void typeDateOfRegOfNameChange() {
        action.typeText(dateOfRegistrationOfNameChangeField,"08.04.2018");
    }
}
