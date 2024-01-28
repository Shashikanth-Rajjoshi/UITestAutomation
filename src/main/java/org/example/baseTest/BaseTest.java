package org.example.baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.example.utilities.ReadConfig.getConfigValue;

public class BaseTest {

    public static WebDriver driver;
    public static final Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() throws IOException {
        //Getting logger properties file
        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\resources\\log4j\\log4j.properties");
        if (getConfigValue("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            logger.info("Launching Chrome Browser");
        } else if (getConfigValue("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            logger.info("Launching FireFox Browser");
        }
    }

    public void launchLoginPage() throws IOException {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        String url = getConfigValue("url");
        driver.get(url);
        logger.info("Launching Login Page with URL: "+url);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        logger.info("Closing The driver");
    }

}
