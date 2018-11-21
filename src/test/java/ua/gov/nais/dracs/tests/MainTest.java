package ua.gov.nais.dracs.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class MainTest {

    private final String CHROME_PATH = "src\\main\\resources\\chromedriver.exe";
    protected WebDriver driver;


    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", CHROME_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
   /* @AfterClass
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }*/



}
