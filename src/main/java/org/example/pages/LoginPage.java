package org.example.pages;

import org.example.baseTest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.example.baseTest.BaseTest.logger;
import static org.example.utilities.ReadConfig.getConfigValue;

public class LoginPage {
    public static Logger log = Logger.getLogger(LoginPage.class);
    BaseTest baseTest = new BaseTest();
    public WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name="username")
    public WebElement txtBxLogin;

    @FindBy(name="password")
    public WebElement txtBxPwd;


    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    public WebElement btnLogin;

    public LoginPage enterUserLogin() throws IOException, InterruptedException {
        baseTest.waitUntilElementIsVisible(txtBxLogin);
        txtBxLogin.sendKeys(getConfigValue("UserLogin"));
        log.info("Entered User Login Details: "+ getConfigValue("UserLogin"));
        return this;
    }

    public LoginPage enterUserPwd() throws IOException, InterruptedException {
        baseTest.waitUntilElementIsVisible(txtBxPwd);
        txtBxPwd.sendKeys(getConfigValue("UserPwd"));
        log.info("Entered User Pwd Details: ***** ");
        return this;
    }

    public LoginPage clickOnLogIn() throws IOException, InterruptedException {
        baseTest.waitUntilElementIsVisible(btnLogin);
        btnLogin.click();
        log.info("Clicked on Sign in Button");
        return this;
    }
    public void verifyNavigateToDashboardPage() throws IOException, InterruptedException {
        Thread.sleep(5000);
        String currenturl = driver.getCurrentUrl();
        String expectedurl = getConfigValue("url")+"web/index.php/dashboard/index";
        Assert.assertEquals(currenturl,expectedurl);
        logger.info("Verified currenturl: "+currenturl+"and Expected url: "+expectedurl);
        System.out.println("Verified currenturl: "+currenturl+" Expected url: "+expectedurl);
    }

    public LoginPage loginWithUserNameAndPwd(String userLogin, String password) throws IOException, InterruptedException {
        baseTest.waitUntilElementIsVisible(txtBxLogin);
        txtBxLogin.sendKeys(userLogin);
        log.info("Entered User Login Details: "+ userLogin);
        baseTest.waitUntilElementIsVisible(txtBxPwd);
        txtBxPwd.sendKeys(password);
        log.info("Entered User Pwd Details: ***** ");
        clickOnLogIn();
        return this;
    }
}
