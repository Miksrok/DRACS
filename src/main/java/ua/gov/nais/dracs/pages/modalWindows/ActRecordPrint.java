package ua.gov.nais.dracs.pages.modalWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.util.RobotForPrintBox;

public class ActRecordPrint extends AbstractPage {

    @FindBy (xpath = "//label[text() = 'Серія']/following-sibling::input")
    private WebElement series;
    @FindBy (xpath = "//label[text() = '№ свідоцтва']/following-sibling::input")
    private WebElement number;
    @FindBy (xpath = "//span[text() = 'Сформувати']/parent::button")
    private WebElement generateButton;

    @FindBy (xpath = "//td[@id = 'ActRecordToolbar_Menu_DXI0_I']")
    private WebElement printButton;

    @FindBy (xpath = "//button[@class = 'destination-settings-change-button']")
    private WebElement destination;

    public ActRecordPrint(WebDriver driver) {
        super(driver);
    }

    public void printActRecord(){
        action.typeText(series, "ФФ");
        action.typeText(number, "123456");
        action.clickOnElement(generateButton);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        action.clickOnElement(printButton);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RobotForPrintBox robot = new RobotForPrintBox();
        robot.enterInfo();
    }

}
