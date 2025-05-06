package testCases;

import org.example.baseTest.BaseTest;
import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Dashboard extends BaseTest {

    @Test(enabled = true)
    public void test_WidgetInDashboardPage() throws IOException, InterruptedException {
        loginAsAdmin();
        String[] widgetNames = {"Buzz Latest Posts","Employee Distribution by Location"};
        DashboardPage db = new DashboardPage(driver);
        for(String widget : widgetNames){
            db.verifyWidgetPresentInDashboardPage(widget);
        }
    }

}
