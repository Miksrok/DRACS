package ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPageTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.pages.modalWindows.SearchApplication;

public class BirthTabGeneralTab extends AbstractPage {

    @FindBy(xpath = "(//label[text() = '№ АЗ']/../input)[1]")
    private WebElement actNoteNumberField;

    @FindBy (xpath = "(//label[text() = 'Дата складання АЗ'])[1]/../div/div[2]/div/div/input")
    private WebElement actNoteDateField;

    @FindBy (xpath = "(//span[text() = 'Пошук'])[1]")
    private WebElement searchApplication;

    public BirthTabGeneralTab(WebDriver driver) {super(driver);}

    public void typeActNoteNumber(Person person){
        action.typeText(actNoteNumberField,person.getActNumber());
        action.typeText(actNoteDateField,person.getActDate());
    }
    public void clickSearchAppButton(String number){
        action.clickOnElement(searchApplication);
        SearchApplication searchApplication = new SearchApplication(driver);
        searchApplication.searchApp(number);
    }
}
