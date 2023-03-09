package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;


public abstract class BasicTest {


    protected WebDriver driver;

    protected String baseUrl = "https://www.etsy.com";
    protected SignInPage signInPage;

    protected NavPage navPage;
    protected SearchPage searchPage;

    protected RegistrationPage registrationPage;

    protected CartPage cartPage;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception {

        if (browser.equalsIgnoreCase("edge")) {

            System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");

            driver = new EdgeDriver();

        } else if (browser.equalsIgnoreCase("chrome")) {

            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/chromedriver.exe");

            driver = new ChromeDriver();
        } else {
            throw new Exception("Browser is not correct");
        }
    }


    @BeforeClass
    public void beforeClass() {


        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        signInPage = new SignInPage(driver);
        navPage = new NavPage(driver);
        searchPage = new SearchPage(driver);
        registrationPage = new RegistrationPage(driver);
        cartPage = new CartPage(driver);


    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

