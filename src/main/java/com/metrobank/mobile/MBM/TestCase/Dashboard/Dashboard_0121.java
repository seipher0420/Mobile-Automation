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

public class Dashboard_0121 extends MobileConnection{

	PropertyFileHandler property = new PropertyFileHandler(Locators.TESTDATA);
	
	@Test
	public void ValidationBtnNavigationBar0122() throws IOException, InterruptedException{
		LogGeneration logGeneration = new LogGeneration();
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		
		logGeneration.generateReport("0121 Validation of button Navigation Bar");
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
		
		try{
			Assert.assertTrue(dashboard.navigationDashBoardIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Navigation Dashboard Button is displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Navigation Dashboard button is not displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.navigationSendMoneyIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Navigation Send Money Button is displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Navigation Send Money button is not displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.navigationPayBillsIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Navigation Paybills Button is displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Navigation Paybills button is not displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.navigationSendLoadIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Navigation Send Load Button is displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Navigation Send Load button is not displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.navigationMoreIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Navigation More Button is displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Navigation More button is not displayed", TestUtil.getScreenshot(driver));
		}
		
		logGeneration.extentFlush();
		driver.quit();
		
	}
}
