package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.example.baseTest.BaseTest.getConfigValue;
import static org.example.baseTest.BaseTest.logger;

public class LoginPage {
    public static Logger log = Logger.getLogger(LoginPage.class);
    public WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="login_id")
    public WebElement txtBxLogin;

    @FindBy(id="password")
    public WebElement txtBxPwd;

    @FindBy(id="nextbtn")
    public WebElement btnNext;

    @FindBy(xpath="//a[contains(text(),'Sign in')]")
    public WebElement btnSignIn;

    @FindBy(xpath = "//*[@id='nextbtn']//span[text()='Sign in']")
    public WebElement btnLogin;

    public LoginPage enterUserLogin() throws IOException, InterruptedException {
        Thread.sleep(4000);
        txtBxLogin.sendKeys(getConfigValue("UserLogin"));
        log.info("Entered User Login Details: "+ getConfigValue("UserLogin"));
        return this;
    }

    public LoginPage clickOnNext() throws IOException {
        btnNext.click();
        log.info("Clicked on Next Button");
        return this;
    }

    public LoginPage clickOnSignIn() throws IOException, InterruptedException {
        Thread.sleep(4000);
        btnSignIn.click();
        log.info("Clicked on Sign in Button");
        return this;
    }

    public LoginPage enterUserPwd() throws IOException, InterruptedException {
        Thread.sleep(4000);
        txtBxPwd.sendKeys(getConfigValue("UserPwd"));
        log.info("Entered User Pwd Details: ***** ");
        return this;
    }

    public LoginPage clickOnLogIn() throws IOException, InterruptedException {
        Thread.sleep(4000);
        btnLogin.click();
        log.info("Clicked on Sign in Button");
        return this;
    }
    public void verifyNavigateToProductsPage() throws IOException, InterruptedException {
        Thread.sleep(5000);
        String currenturl = driver.getCurrentUrl();
        String expectedurl = getConfigValue("url")+"all-products.html";
        Assert.assertEquals(currenturl,expectedurl);
        logger.info("Verified currenturl: "+currenturl+"and Expected url: "+expectedurl);
        System.out.println("Verified currenturl: "+currenturl+" Expected url: "+expectedurl);
    }
}
