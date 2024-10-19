package testCases;

import org.example.baseTest.BaseTest;
import org.example.pages.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Login extends BaseTest {

    @Test(enabled = true)
    public void loginToApplication() throws IOException, InterruptedException {
        launchLoginPage();
        LoginPage lg = new LoginPage(driver);
        lg.enterUserLogin().enterUserPwd().clickOnLogIn().verifyNavigateToDashboardPage();
    }

    /*This Testcase is to demonstrate capturing of Screenshot for Failure and
     this needs to be run from testng to get extent report and screenshots*/
    @Test(enabled = true)
    public void loginToApplicationWithUserNameAndPassword() throws IOException, InterruptedException {
        launchLoginPage();
        LoginPage lg = new LoginPage(driver);
        lg.loginWithUserNameAndPwd("wrongUser@gmail.com","pwd");
    }
}
