package main.java.com.metrobank.mobile.MBM.TestCase.Dashboard;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;

import main.java.com.metrobank.mobile.MBM.DashBoard.DashBoard;
import main.java.com.metrobank.mobile.MBM.LoginPage.LoginPage;
import main.java.com.metrobank.mobile.core.base.Enums.LogType;
import main.java.com.metrobank.mobile.core.base.MobileConnection;
import main.java.com.metrobank.mobile.core.locator.Locators;
import main.java.com.metrobank.mobile.core.logger.LogGeneration;
import main.java.com.metrobank.mobile.core.utilities.PropertyFileHandler;
import main.java.com.metrobank.mobile.core.utilities.TestUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dashboard_0126 extends MobileConnection{

	PropertyFileHandler property = new PropertyFileHandler(Locators.TESTDATA);
	@Test
	public void ValidationCustomizeDashboard0126() throws IOException, InterruptedException{
		
		LogGeneration logGeneration = new LogGeneration();
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		
		logGeneration.generateReport("0126 Removing multiple widget");
		AppiumDriver<MobileElement> driver = mobileOS("Android");	
		TestUtil.waitTime(5);
		loginPage.inputUsername(driver, property.GetValue("username"));
		logGeneration.inputLogs(LogType.info, "Input Username", null);
		TestUtil.waitTime(5);
		loginPage.inputPassword(driver, property.GetValue("password"));
		logGeneration.inputLogs(LogType.info, "Input Password", null);
		TestUtil.waitTime(5);
		loginPage.clickLoginBtn(driver);
		logGeneration.inputLogs(LogType.info, "Click Login Button", null);
		Thread.sleep(15000);
		
		logGeneration.inputLogs(LogType.info, "Dashboard is displayed", null);
		
		dashboard.clickCustomizeMenu(driver);
		logGeneration.inputLogs(LogType.info, "Click Customize Menu button", null);
		
		TestUtil.waitTime(5);
		try{
			Assert.assertTrue(dashboard.customizeMenuIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Customize Menu is Displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Customize Menu does not displayed", TestUtil.getScreenshot(driver));
		}
		
		
		TestUtil.waitTime(3);
		dashboard.clickDonebtn(driver);
		logGeneration.inputLogs(LogType.info, "Click Back Button", null);
		
		try{
			TestUtil.waitTime(3);
			Assert.assertTrue(dashboard.navigationDashBoardIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "DashBoard is displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Dashboard is not displayed", TestUtil.getScreenshot(driver));
		}
		
		TestUtil.waitTime(2);
		dashboard.clickCustomizeMenu(driver);
		logGeneration.inputLogs(LogType.info, "Click Customize Menu button", null);
	
		TestUtil.waitTime(2);
		dashboard.clickWidgetCredit(driver);
		logGeneration.inputLogs(LogType.info, "Click Credit Card Widget", null);
		
		TestUtil.waitTime(2);
		dashboard.clickDonebtn(driver);
		logGeneration.inputLogs(LogType.info, "Click Done Button on Customize menu", null);
		
		try{
			TestUtil.waitTime(2);
			Assert.assertTrue(dashboard.dashboardCreditCardIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Credit Card was added on Dashboard", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Credit Card was not added on Dashboard", TestUtil.getScreenshot(driver));
		}
		
		TestUtil.waitTime(2);
		dashboard.clickCustomizeMenu(driver);
		logGeneration.inputLogs(LogType.info, "Click Customize Menu button", null);
		
		TestUtil.waitTime(2);
		dashboard.clickWidgetCredit(driver);
		logGeneration.inputLogs(LogType.info, "Click Credit Card Widget again to remove", null);
		
		TestUtil.waitTime(2);
		dashboard.clickWidgetShortcut(driver);
		logGeneration.inputLogs(LogType.info, "Click Shortcut Widget again to remove", null);
		
		TestUtil.waitTime(2);
		dashboard.clickDonebtn(driver);
		logGeneration.inputLogs(LogType.info, "Click Done Button on Customize menu", null);
		
		try{
			TestUtil.waitTime(2);
			Assert.assertFalse(dashboard.dashboardCreditCardIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Credit Card was remove from dashboard", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Credit Card was not remove from Dashboard", TestUtil.getScreenshot(driver));
		}
		
		try{
			TestUtil.waitTime(2);
			Assert.assertFalse(dashboard.dashboardShortCutIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Shortcut was remove from dashboard", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Shortcut was not remove from Dashboard", TestUtil.getScreenshot(driver));
		}
		
		logGeneration.extentFlush();
		driver.quit();
	}
		
}
