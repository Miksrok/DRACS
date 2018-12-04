package ua.gov.nais.dracs.util;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ActionsWithElement {

    private WebDriver driver;
    private WebDriverWait wait;

    public ActionsWithElement(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.and(
                ExpectedConditions.not(ExpectedConditions.invisibilityOf(element)),
                ExpectedConditions.elementToBeClickable(element)));
        String el = element.getTagName() + " click <br>";
        element.click();
        //ScreenShotsMaker.screenShot(driver);
        Reporter.log(String.format("[%-12s] ACTION: %s",
                LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME),
                el));
    }

    public void typeText(WebElement element, String text) {
        //wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.clear();
        element.sendKeys(Keys.HOME);
        element.sendKeys(text);
        Reporter.log(String.format("[%-12s] ACTION: %s",
                LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME),
                element.getTagName() + " type" + " " + text + "<br>"));
        //ScreenShotsMaker.screenShot(driver);
    }

    public void selectElementFromListByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
        //ScreenShotsMaker.screenShot(driver);
    }
    public void selectElementFromListByText(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
        //ScreenShotsMaker.screenShot(driver);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public void waitUntilDisappear(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }


}
