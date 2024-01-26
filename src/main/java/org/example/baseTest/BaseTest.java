package org.example.baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static final Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeTest
    public void setUp() throws IOException {
        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\log4j\\log4j.properties");
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

    public String getConfigValue(String key) throws IOException {
        FileReader fr = new FileReader(System.getProperty("user.dir")+"/testData/config.properties");
        Properties pr = new Properties();
        pr.load(fr);
        logger.info("Getting Config value for key: "+key);
        return pr.getProperty(key);
    }

    public void launchLoginPage() throws IOException {
        driver.manage().deleteAllCookies();
        String url = getConfigValue("url");
        driver.get(url);
        logger.info("Launching Login Page with URL: "+url);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        logger.info("Closing The driver");
    }

}
