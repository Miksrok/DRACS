package ua.gov.nais.dracs.pages.applicationsTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class ApplicationsTab extends AbstractPage {

    @FindBy(xpath = "//label[text() = 'Вхідний № заяви:']/../input")
    private WebElement actNoteNumberField;

    @FindBy (xpath = "//label[text() = 'Вхідна дата заяви:']/../div/div/input")
    private WebElement actNoteDateField;

    public ApplicationsTab(WebDriver driver) {
        super(driver);
    }
}
