package testCases;

import org.example.baseTest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Login extends BaseTest {

    @Test
    public void loginToApplication() throws IOException {
       launchLoginPage();
    }
}
