package ua.gov.nais.dracs.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import ua.gov.nais.dracs.pages.register.LoginPage;
import ua.gov.nais.dracs.pages.register.MainPage;
import ua.gov.nais.dracs.util.PropertiesFileReader;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class MainTest {

    private final String CHROME_PATH = PropertiesFileReader.getPropValues("chrome-driver-path");
    private final String URL = PropertiesFileReader.getPropValues("url");
    private final String DIR_PATH = "c:\\users\\d.huhushkin\\ideaprojects\\dracstests\\target\\surefire-reports\\extracts\\";
    public static WebDriver driver;
    protected MainPage mainPage;

    protected MainTest() throws IOException {
    }

    @BeforeSuite
    public void prepareDir() {
        new File(DIR_PATH).mkdirs();
    }

    @BeforeTest
    @Parameters({"login", "password", "key"})
    public void setUp(String login, String password, String key) {
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
    public void setMainPage() {
        mainPage = new MainPage(driver);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void openReports() {
        try {
            Desktop.getDesktop().open(new File("C:\\Users\\d.huhushkin\\IdeaProjects" +
                    "\\DracsTests\\target\\surefire-reports" +
                    "\\index.html"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
