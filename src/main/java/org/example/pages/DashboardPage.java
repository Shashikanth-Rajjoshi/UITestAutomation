package org.example.pages;

import org.apache.log4j.Logger;
import org.example.baseTest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

import static org.example.baseTest.BaseTest.logger;
import static org.example.utilities.ReadConfig.getConfigValue;

public class DashboardPage {
    public static Logger log = Logger.getLogger(DashboardPage.class);
    BaseTest baseTest = new BaseTest();
    public WebDriver driver;
    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[text()='Dashboard']")
    public WebElement txtHeaderDashboard;

    @FindBy(xpath = "//*[text()='Time at Work']")
    public WebElement txtTimeAtWorkWidget;

    @FindBy(xpath = "//*[text()='My Actions']")
    public WebElement txtMyActionsWidget;

    @FindBy(xpath = "//*[text()='Quick Launch']")
    public WebElement txtQuickLaunchWidget;

    @FindBy(xpath = "//*[text()='Buzz Latest Posts']")
    public WebElement txtBuzzLatestPostWidget;

    @FindBy(xpath = "//*[text()='Employees on Leave Today']")
    public WebElement txtEmpOnLeaveTdyWidget;

    @FindBy(xpath = "//*[text()='Employee Distribution by Sub Unit']")
    public WebElement txtEmpDistBySubUnitWidget;

    @FindBy(xpath = "//*[text()='Employee Distribution by Location']")
    public WebElement txtEmpDistByLocationWidget;


    public void verifyWidgetPresentInDashboardPage(String expectedWidget) throws IOException {
        String actualWidget="";
        logger.info("Verifying " +expectedWidget +" Widget Present in Dashboard Page ");
        switch (expectedWidget){
            case "Time at Work":
                baseTest.waitUntilElementIsVisible(txtTimeAtWorkWidget);
                actualWidget = txtTimeAtWorkWidget.getText();
                break;
            case "My Actions":
                baseTest.waitUntilElementIsVisible(txtMyActionsWidget);
                actualWidget = txtMyActionsWidget.getText();
                break;
            case "Quick Launch":
                baseTest.waitUntilElementIsVisible(txtQuickLaunchWidget);
                actualWidget = txtQuickLaunchWidget.getText();
                break;
            case "Buzz Latest Posts":
                baseTest.waitUntilElementIsVisible(txtBuzzLatestPostWidget);
                actualWidget = txtBuzzLatestPostWidget.getText();
                break;
            case "Employees on Leave Today":
                baseTest.waitUntilElementIsVisible(txtEmpOnLeaveTdyWidget);
                actualWidget = txtEmpOnLeaveTdyWidget.getText();
                break;
            case "Employee Distribution by Sub Unit":
                baseTest.waitUntilElementIsVisible(txtEmpDistBySubUnitWidget);
                actualWidget = txtEmpDistBySubUnitWidget.getText();
                break;
            case "Employee Distribution by Location":
                baseTest.waitUntilElementIsVisible(txtEmpDistByLocationWidget);
                actualWidget = txtEmpDistByLocationWidget.getText();
                break;
            default:
                logger.info("Provide Valid Widget Name");
        }
        Assert.assertEquals(actualWidget,expectedWidget,"Actual Value:: "+actualWidget+" Expected Value:: "+expectedWidget);
    }

}
