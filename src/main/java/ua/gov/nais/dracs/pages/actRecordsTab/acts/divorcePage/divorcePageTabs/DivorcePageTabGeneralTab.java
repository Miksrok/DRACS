package ua.gov.nais.dracs.pages.actRecordsTab.acts.divorcePage.divorcePageTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;

public class DivorcePageTabGeneralTab extends AbstractPage {

    @FindBy(xpath = "(//label[text() = '№ АЗ']/../input)[1]")
    private WebElement actNoteNumberField;
    @FindBy (xpath = "(//label[text() = 'Дата складання АЗ'])[1]/../div/div[2]/div/div/input")
    private WebElement actNoteDateField;
    @FindBy (xpath = "(//label[text() = 'Дата реєстрації розірвання шлюбу'])[1]/../div/div[2]/div/div/input")
    private WebElement dateOfDivorceRegistration;
    @FindBy (xpath = "//label[text() = 'Підстава реєстрації розірвання шлюбу']/following-sibling::textarea")
    private WebElement reason;
    @FindBy (xpath = "//label[text() = 'Кількість (спільних) неповнолітніх дітей']/following-sibling::select")
    private WebElement amountOfChildrenList;
    @FindBy (xpath = "//option[text() = 'Немає']")
    private WebElement amountOfChildrenIsNone;

    public DivorcePageTabGeneralTab(WebDriver driver) {
        super(driver);
    }

    public DivorcePageTabHusbandTab typeActInformation(ActRecord act){
        action.typeText(actNoteNumberField, act.getActNumber());
        action.typeText(actNoteDateField, act.getActDate());
        action.typeText(dateOfDivorceRegistration, act.getActDate());
        action.typeText(reason, "Прошла лубофф, зав'яли помідорки");
        action.clickOnElement(amountOfChildrenList);
        action.clickOnElement(amountOfChildrenIsNone);
        return new DivorcePageTabHusbandTab(driver);
    }

}
