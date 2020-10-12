package main.java.com.metrobank.mobile.MBM.TestCase.Dashboard;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.java.com.metrobank.mobile.MBM.DashBoard.DashBoard;
import main.java.com.metrobank.mobile.MBM.LoginPage.LoginPage;
import main.java.com.metrobank.mobile.core.base.MobileConnection;
import main.java.com.metrobank.mobile.core.base.Enums.LogType;
import main.java.com.metrobank.mobile.core.locator.Locators;
import main.java.com.metrobank.mobile.core.logger.LogGeneration;
import main.java.com.metrobank.mobile.core.utilities.PropertyFileHandler;
import main.java.com.metrobank.mobile.core.utilities.TestUtil;

public class Dashboard_0133 extends MobileConnection{
	
	PropertyFileHandler property = new PropertyFileHandler(Locators.TESTDATA);
	@Test
	public void ViewingofDepositWidget() throws IOException, InterruptedException{
	
		LogGeneration logGeneration = new LogGeneration();
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		
		logGeneration.generateReport("0129 Viewing of deposit Widget");
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
		
		TestUtil.waitTime(3);
		dashboard.clickDonebtn(driver);
		logGeneration.inputLogs(LogType.info, "Click Back Button", null);
		
		try{
			TestUtil.waitTime(3);
			Assert.assertTrue(dashboard.navigationDashBoardIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "DashBoard is displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Dashboard was removed", TestUtil.getScreenshot(driver));
		}
		
		TestUtil.waitTime(2);
		dashboard.clickCustomizeMenu(driver);
		logGeneration.inputLogs(LogType.info, "Click Customize Menu button", null);
		
		TestUtil.waitTime(2);
		dashboard.clickWidgetDeposit(driver);
		logGeneration.inputLogs(LogType.info, "Click Deposit widget to remove from dashboard", null);
		
		TestUtil.waitTime(2);
		dashboard.clickDonebtn(driver);
		logGeneration.inputLogs(LogType.info, "Click Done Button", null);
		
		TestUtil.waitTime(3);
		try{
			Assert.assertFalse(dashboard.dashboardWidgetDataIsDisplayed(driver, "Deposits"));
			logGeneration.inputLogs(LogType.pass, "Deposit Widget was removed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.pass, "Deposit Widget is displayed", TestUtil.getScreenshot(driver));
		}
		
		
		logGeneration.extentFlush();
		driver.quit();
		
	}
}
