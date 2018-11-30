package ua.gov.nais.dracs.pages.modalWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class PreviewExtractModal extends AbstractPage {

    @FindBy (xpath = "(//span[text() = 'Вихід'])[7]")
    private WebElement exitButton;

    public PreviewExtractModal(WebDriver driver) {
        super(driver);
    }

    public void closePreviewWindow(){
        action.clickOnElement(exitButton);
    }

}
