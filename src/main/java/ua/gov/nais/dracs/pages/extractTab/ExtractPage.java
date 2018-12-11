package ua.gov.nais.dracs.pages.extractTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.pages.modalWindows.PreviewExtractModal;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;

import java.util.Set;

public class ExtractPage extends AbstractPage {

    @FindBy(id = "acRegister")
    private WebElement creatNewExtract;

    @FindBy(id = "ActRecordTypeSelect")
    private WebElement actRecordsTypeList;

    @FindBy(id = "ExtractTypeSelect")
    private WebElement extractTypeList;

    //@FindBy(xpath = "(//span[text() = 'Пошук']/parent::button)[2]")
    @FindBy (xpath = "(//span/parent::button[contains(@class, 'btn-search')])[2]")
    private WebElement searchActRecordButton;

    /*@FindBy(xpath = "//label[contains(text(), 'Норми закону та реквізити справи')]" +
            "/following-sibling::input")*/
    @FindBy(xpath = "//input[@data-bind = 'value: JURIDICAL_NAME']")
    private WebElement reason;
    @FindBy(xpath = "//button[text() = 'Попередній перегляд витягу']")
    private WebElement previewButton;
    @FindBy(xpath = "//button[text() = 'Сформувати']")
    private WebElement generateExtractButton;
    @FindBy(xpath = "//div[@id = 'confirm-message']/following-sibling::div//span[text() = 'OК']")
    private WebElement confirmMessageOkButton;
    @FindBy(xpath = "//div[@id = 'alert-message-info']/following::span[text() = 'OК']")
    private WebElement okAlertButton;

    public ExtractPage(WebDriver driver) {
        super(driver);
    }

    public void typeReason(String text) {

        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        for (String handle : handles) {

            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
            }
        }
        action.typeText(reason, text);
    }

    public void generatePreview() {
        action.clickOnElement(previewButton);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PreviewExtractModal previewExtractModal = new PreviewExtractModal(driver);
        previewExtractModal.closePreviewWindow();
    }

    public void generateExtract() {
        action.clickOnElement(generateExtractButton);
        action.clickOnElement(confirmMessageOkButton);
        action.clickOnElement(okAlertButton);
    }

    public void createNewExtract() {
        action.clickOnElement(creatNewExtract);
    }

    public void selectActRecordType(String value) {
        action.selectElementFromListByValue(actRecordsTypeList, value);
    }

    public void selectExtractType(String value) {
        action.selectElementFromListByValue(extractTypeList, value);
    }

    public ExtendSearch clickSearchButton() {
        action.clickOnElement(searchActRecordButton);
        return new ExtendSearch(driver);
    }

}
