package ua.gov.nais.dracs.pages.actRecordsTab.acts.birthPage.BirthPageTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.ActRecord;
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

    @FindBy (xpath = "//label[text() = 'Реєстрація народження проводиться']/following-sibling::select")
    private WebElement birthRegistrationReasonList;

    @FindBy (xpath = "//label[text() = 'Реєстрація народження проводиться']" +
            "/following-sibling::select" +
            "/option[@value = '2']")
    private WebElement articleOfLaw133;

    public BirthTabGeneralTab(WebDriver driver) {super(driver);}

    public BirthTabChildTab typeActNoteNumber(ActRecord act){
        action.typeText(actNoteNumberField,act.getActNumber());
        action.typeText(actNoteDateField,act.getActDate());
        action.clickOnElement(birthRegistrationReasonList);
        action.clickOnElement(articleOfLaw133);
        return new BirthTabChildTab(driver);
    }
    public void clickSearchAppButton(String number){
        action.clickOnElement(searchApplication);
        SearchApplication searchApplication = new SearchApplication(driver);
        searchApplication.searchApp(number);
    }
}
