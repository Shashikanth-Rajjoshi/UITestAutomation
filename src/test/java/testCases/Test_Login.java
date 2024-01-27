package testCases;

import org.example.baseTest.BaseTest;
import org.example.pages.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Login extends BaseTest {

    @Test
    public void loginToApplication() throws IOException, InterruptedException {
        launchLoginPage();
        LoginPage lg = new LoginPage(driver);
        lg.clickOnSignIn().enterUserLogin().clickOnNext().enterUserPwd().clickOnLogIn().verifyNavigateToProductsPage();
    }
}
