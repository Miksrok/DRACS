package ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class SearchByPersonRibbon extends AbstractPage {

    @FindBy(xpath = "//label[text() = 'Роль:']/following-sibling::select")
    //@FindBy(xpath = "//select[@id = 'HU_RC_HU_ROLE_ar']")
    private WebElement rolesList;
    @FindBy(xpath = "//input[@id = 'HU_SURNAME']")
    private WebElement surname;
    @FindBy(xpath = "//input[@id = 'HU_NAME']")
    private WebElement name;
    @FindBy(xpath = "//input[@id = 'HU_PATRONYMIC']")
    private WebElement fatherName;


    public SearchByPersonRibbon(WebDriver driver) {
        super(driver);
    }

    public void selectPersonRole(String role) {
        action.selectElementFromListByText(rolesList, role);
    }

    public void enterPersonInformation(String surnameText, String nameText, String fatherNameText) {
        action.typeText(surname, surnameText);
        action.typeText(name, nameText);
        action.typeText(fatherName, fatherNameText);

    }
}
