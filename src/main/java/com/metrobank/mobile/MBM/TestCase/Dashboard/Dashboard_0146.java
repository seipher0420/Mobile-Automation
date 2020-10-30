package main.java.com.metrobank.mobile.MBM.TestCase.Dashboard;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;

import main.java.com.metrobank.mobile.MBM.DashBoard.DashBoard;
import main.java.com.metrobank.mobile.MBM.LoginPage.LoginPage;
import main.java.com.metrobank.mobile.core.base.MobileConnection;
import main.java.com.metrobank.mobile.core.base.Enums.LogType;
import main.java.com.metrobank.mobile.core.locator.Locators;
import main.java.com.metrobank.mobile.core.logger.LogGeneration;
import main.java.com.metrobank.mobile.core.utilities.PropertyFileHandler;
import main.java.com.metrobank.mobile.core.utilities.TestUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dashboard_0146 extends MobileConnection{

	PropertyFileHandler property = new PropertyFileHandler(Locators.TESTDATA);
	@Test
	public void RemovingInboxWidget() throws IOException, InterruptedException{
		
		LogGeneration logGeneration = new LogGeneration();
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		
		logGeneration.generateReport("0146 Removing of Inbox Widget");
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
		if(dashboard.getSessionBrowserIsDisplayed(driver) != null){
			logGeneration.inputLogs(LogType.warning, "Message A session on another browser or device has ended is displayed", TestUtil.getScreenshot(driver));
			dashboard.clickOkBtnSession(driver);
			TestUtil.waitTime(5);
		}
		logGeneration.inputLogs(LogType.info, "Dashboard is displayed", null);
		
		dashboard.clickCustomizeMenu(driver);
		logGeneration.inputLogs(LogType.info, "Click Customize Menu button", null);
		
		TestUtil.waitTime(5);
		try{
			Assert.assertTrue(dashboard.customizeMenuIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Customize Menu is Displayed",  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Customize Menu does not displayed", TestUtil.getScreenshot(driver));
		}
		
		TestUtil.waitTime(2);
		dashboard.clickWidgetInbox(driver);
		logGeneration.inputLogs(LogType.info, "Click Widget Inbox widget from customize menu", null);
		
		TestUtil.waitTime(2);
		dashboard.clickDonebtn(driver);
		logGeneration.inputLogs(LogType.info, "Click Done Button on Customize menu", null);
		
		TestUtil.waitTime(2);
		for (int i=0;  i<6;i++) {
		    TestUtil.swipeDown(driver, -1);
		}
		TestUtil.waitTime(3);
		try{
			Assert.assertTrue(dashboard.dashboardInboxIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Inbox is displayed on dashboard",  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Inbox in dashboard not displayed", TestUtil.getScreenshot(driver));
		}
		
		
		dashboard.clickDisplayOptionsMenu(driver);
		TestUtil.waitTime(3);
		
		dashboard.clickInboxWidgetData(driver, "Move");
		logGeneration.inputLogs(LogType.info, "Click Move on display Options Menu", null);
		TestUtil.waitTime(3);
		
		TestUtil.waitTime(2);
		dashboard.clickWidgetInbox(driver);
		logGeneration.inputLogs(LogType.info, "Click Widget Inbox widget from customize menu", null);
		
		dashboard.clickDonebtn(driver);
		logGeneration.inputLogs(LogType.info, "Click Done button on display Options Menu", null);
		
		TestUtil.waitTime(2);
		for (int i=0;  i<6;i++) {
		    TestUtil.swipeDown(driver, -1);
		}
		
		try{
			Assert.assertFalse(dashboard.dashboardInboxIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Inbox in dashboard not displayed",  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Inbox in dashboard is displayed", TestUtil.getScreenshot(driver));
		}
		logGeneration.extentFlush();
		driver.quit();
	}
 

}
