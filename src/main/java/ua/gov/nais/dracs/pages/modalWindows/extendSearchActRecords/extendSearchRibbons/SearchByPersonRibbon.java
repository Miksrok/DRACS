package ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class SearchByPersonRibbon extends AbstractPage {

    @FindBy (xpath = "//label[text() = 'Роль:']/following-sibling::select")
    private WebElement rolesList;
    @FindBy (xpath = "//label[text() = 'Роль:']/following-sibling::select/option[text() = 'Дитина']")
    private WebElement roleChild;
    @FindBy (xpath = "//input[@id = 'HU_SURNAME']")
    private WebElement surname;
    @FindBy (xpath = "//input[@id = 'HU_NAME']")
    private WebElement name;
    @FindBy (xpath = "//input[@id = 'HU_PATRONYMIC']")
    private WebElement fatherName;


    public SearchByPersonRibbon(WebDriver driver) {
        super(driver);
    }

    public void enterChildInformation(){
       // action.clickOnElement(rolesList);
        //action.selectElementFromListByText(rolesList, "Дитина");
        action.selectElementFromListByText(rolesList, "Померлий");
        //action.clickOnElement(roleChild);
        action.typeText(surname, "Яакйцфдотжтфх");
        action.typeText(name, "РоботЯакйцфдотжтфх");
        action.typeText(fatherName, "Пбфзятнююиив");

    }
}
