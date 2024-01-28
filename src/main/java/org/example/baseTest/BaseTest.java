package org.example.baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.example.utilities.ReadConfig.getConfigValue;

public class BaseTest {

    public static WebDriver driver;
    public static final Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeClass
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

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
        logger.info("Closing The driver");
    }

    //user method to capture screenshot
    public void captureScreenShot(WebDriver driver,String testName) throws IOException
    {
        //step1: convert webdriver object to TakesScreenshot interface
        TakesScreenshot screenshot = ((TakesScreenshot)driver);

        //step2: call getScreenshotAs method to create image file

        File src = screenshot.getScreenshotAs(OutputType.FILE);

        File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");

        //step3: copy image file to destination
        FileUtils.copyFile(src, dest);
    }

}
