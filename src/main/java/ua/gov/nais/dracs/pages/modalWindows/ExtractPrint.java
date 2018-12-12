package ua.gov.nais.dracs.pages.modalWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.models.Person;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.util.RobotForPrintBox;

import java.awt.*;

public class ExtractPrint extends AbstractPage {

    @FindBy (xpath = "//span[text() = 'Друкувати']/parent::button")
    private WebElement printButton;
    @FindBy (xpath = "(//span[text() = 'OК'])[2]")
    private WebElement okButton;

    public ExtractPrint(WebDriver driver) {
        super(driver);
    }

    public void printExtract(String name){
        ActRecord act = new ActRecord();
        action.clickOnElement(printButton);
        action.clickOnElement(okButton);
        wait10Sec();
        RobotForPrintBox robot = new RobotForPrintBox();
        robot.saveExtract(PATH, act.getActNumber(), name);
        wait3Sec();
    }
    private void wait10Sec(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void wait3Sec(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
