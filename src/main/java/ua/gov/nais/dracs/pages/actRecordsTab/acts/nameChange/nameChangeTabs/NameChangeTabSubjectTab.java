package ua.gov.nais.dracs.pages.actRecordsTab.acts.nameChange.nameChangeTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class NameChangeTabSubjectTab extends AbstractPage {

    @FindBy(xpath = "//a[@href = '#tPerson']")
    private WebElement openSubjectTab;

    @FindBy(xpath = "(//label[text() = 'Прізвище'])[1]/following-sibling::input")
    private WebElement name;

    @FindBy(xpath = "(//label[text() = 'Власне ім’я'])[1]/following-sibling::input")
    private WebElement surname;

    @FindBy(xpath = "(//label[text() = 'По батькові'])[1]/following-sibling::input")
    private WebElement fatherName;

    @FindBy(xpath = "(//label[text() = 'Дата нар-ня'])[1]/following-sibling::div/div[2]/div/div/input")
    private WebElement birthdayDate;

    @FindBy(xpath = "(//label[text() = 'Серія та № / Документ №'])[1]/following-sibling::input")
    private WebElement documentNumber;

    @FindBy(xpath = "(//label[text() = 'Дата видачі'])[1]/following-sibling::div/div/input")
    private WebElement documentDate;

    @FindBy(xpath = "(//label[text() = 'Ким виданий (орган, що видав)'])[1]/following-sibling::input")
    private WebElement documentPublisher;

    public NameChangeTabSubjectTab(WebDriver driver) {
        super(driver);
    }
}
