package ua.gov.nais.dracs.pages.actRecordsTab.acts.deathPage.deathPageTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class DeathPageTabDeadTab extends AbstractPage {

    @FindBy(xpath = "//a[@href = '#tPerson']")
    private WebElement openDeadTab;

    private WebElement name;
    private WebElement surname;
    private WebElement fatherName;
    private WebElement birthdayDate;
    private WebElement deathDate;

    public DeathPageTabDeadTab(WebDriver driver) {
        super(driver);
    }
}
