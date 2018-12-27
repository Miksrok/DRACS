package ua.gov.nais.dracs.pages.register.modalWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.gov.nais.dracs.pages.AbstractPage;
import ua.gov.nais.dracs.util.RobotForPrintBox;

import java.io.File;

public class ExtractPrint extends AbstractPage {

    @FindBy (xpath = "//span[text() = 'Друкувати']/parent::button")
    private WebElement printButton;
    @FindBy (xpath = "(//span[text() = 'OК'])[2]")
    private WebElement okButton;

    public ExtractPrint(WebDriver driver) {
        super(driver);
    }

    public boolean printExtract(String name, String actNumber){

        action.clickOnElement(printButton);
        action.clickOnElement(okButton);
        wait10Sec();
        RobotForPrintBox robot = new RobotForPrintBox();
        robot.saveExtract(PATH, actNumber, name);
        wait3Sec();
        return isFilePresent(actNumber, name);
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
    private boolean isFilePresent(String actNumber, String name){
        System.out.println(PATH+actNumber+name+"-ext.pdf");
        return new File(PATH+actNumber+name+"-ext.pdf").isFile();
    }
}
