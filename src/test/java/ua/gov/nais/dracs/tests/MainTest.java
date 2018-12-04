package ua.gov.nais.dracs.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ua.gov.nais.dracs.pages.LoginPage;
import ua.gov.nais.dracs.pages.MainPage;

import java.util.concurrent.TimeUnit;

public abstract class MainTest {

    private final String CHROME_PATH = "src\\main\\resources\\chromedriver.exe";
    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", CHROME_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-print-preview");
       // WebDriver driver = new ChromeDriver(options);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://regdracs.test.nais.gov.ua/");
        LoginPage loginPage = new LoginPage(driver);
        mainPage = loginPage.login();

    }
   /* @AfterClass
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }*/



}
