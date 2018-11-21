package ua.gov.nais.dracs.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithElement {

    private WebDriver driver;
    private WebDriverWait wait;

    public ActionsWithElement(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public void clickOnElement(WebElement element){
        wait.until(ExpectedConditions.and(
                ExpectedConditions.not(ExpectedConditions.invisibilityOf(element)),
                ExpectedConditions.elementToBeClickable(element)));
        element.click();
    }

    public void typeText(WebElement element, String text){

        element.click();
        element.clear();
        element.sendKeys(text);
    }
    public void waitUntilDisappear(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }


}
