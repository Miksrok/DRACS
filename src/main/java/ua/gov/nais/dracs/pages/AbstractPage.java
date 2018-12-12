package ua.gov.nais.dracs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ua.gov.nais.dracs.util.ActionsWithElement;

public abstract class AbstractPage {

    public WebDriver driver;
    public ActionsWithElement action;
    public final String PATH = "c:\\users\\d.huhushkin\\ideaprojects\\dracstests\\target\\surefire-reports\\extracts\\";

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.action = new ActionsWithElement(driver);
        PageFactory.initElements(driver, this);
    }

}
