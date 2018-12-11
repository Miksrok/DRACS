package ua.gov.nais.dracs.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import ua.gov.nais.dracs.pages.LoginPage;
import ua.gov.nais.dracs.pages.MainPage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class MainTest {

    private final String CHROME_PATH = "src\\main\\resources\\chromedriver.exe";
    private final String URL = "https://regdracs.test.nais.gov.ua/";
    public static WebDriver driver;
    protected MainPage mainPage;

    @BeforeTest
    @Parameters ({"login", "password", "key"})
    public void setUp(String login, String password, String key){
        System.setProperty("webdriver.chrome.driver", CHROME_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-print-preview");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(login, password, key);
    }

    @BeforeClass
    public void setMainPage(){
       mainPage = new MainPage(driver);
    }

    @AfterTest
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
    @AfterSuite
    public void openReports(){
        try {
            Desktop.getDesktop().open(new File("C:\\Users\\d.huhushkin\\IdeaProjects" +
                    "\\DracsTests\\target\\surefire-reports" +
                    "\\index.html"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
