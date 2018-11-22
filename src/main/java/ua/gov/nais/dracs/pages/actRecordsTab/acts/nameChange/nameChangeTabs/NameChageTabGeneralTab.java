package ua.gov.nais.dracs.pages.actRecordsTab.acts.nameChange.nameChangeTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.Person;
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
        Person person = new Person();
        action.typeText(actNoteNumberField,person.getActNumber());
        action.typeText(actNoteDateField,person.getActDate());
    }

    public void typeDateOfRegOfNameChange() {
        action.typeText(dateOfRegistrationOfNameChangeField,"08.04.2018");
    }
}
