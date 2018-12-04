package ua.gov.nais.dracs.pages.modalWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;

public class Address extends AbstractPage {

    @FindBy (xpath = "(//label[text() = 'Регіон:'])[1]/following-sibling::select")
    private WebElement regionList;
    @FindBy (xpath = "(//label[text() = 'Регіон:'])[1]/following-sibling::select/option[text() = 'Волинська обл.']")
    private WebElement regionVolin;
    @FindBy (xpath = "(//label[text() = 'Район/місто:'])[1]/following-sibling::select")
    private WebElement districtOrCityList;
    @FindBy (xpath = "(//label[text() = 'Район/місто:'])[1]/following-sibling::select/option[text() = 'Горохівський р.']")
    private WebElement districtOrCityGorohivDistrict;
    @FindBy (xpath = "(//label[text() = 'Нас. пункт:'])[1]/following-sibling::select")
    private WebElement townList;
    @FindBy (xpath = "(//label[text() = 'Нас. пункт:'])[1]/following-sibling::select/option[text() = 'Горохів м.']")
    private WebElement townGorohiv;
    @FindBy (xpath = "(//label[text() = 'Вулиця:'])[1]/following-sibling::select")
    private WebElement streetList;
    @FindBy (xpath = "(//label[text() = 'Вулиця:'])[1]/following-sibling::select/option[text() = 'Артема вул.']")
    private WebElement streetArtema;
    @FindBy (xpath = "(//label[text() = '№ будинку:'])[1]/following-sibling::input")
    private WebElement buildingNumber;
    @FindBy (xpath = "(//span[text() = 'Прийняти']/parent::button)[1]")
    private WebElement acceptButton;

    public Address(WebDriver driver) {
        super(driver);
    }
    public void enterAddress(){
        action.clickOnElement(regionList);
        action.clickOnElement(regionVolin);
        action.clickOnElement(districtOrCityList);
        action.clickOnElement(districtOrCityGorohivDistrict);
        action.clickOnElement(townList);
        action.clickOnElement(townGorohiv);
        action.clickOnElement(streetList);
        action.clickOnElement(streetArtema);
        action.typeText(buildingNumber, "99");
        action.clickOnElement(acceptButton);
    }


}
