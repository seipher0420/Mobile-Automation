package main.java.com.metrobank.mobile.MBM.TestCase.Dashboard.MBM183;

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

public class MBM183_0101 extends MobileConnection{

	PropertyFileHandler property = new PropertyFileHandler(Locators.TESTDATA);

	@Test
	public void DashBoardViewDepositAccountOnly0101() throws IOException, InterruptedException{
		

		
		LogGeneration logGeneration = new LogGeneration();
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		
		logGeneration.generateReport("MBM183 Accessibility of Enroll Account screen 0102");
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
		
		dashboard.clickHamburgerMenu(driver);
		logGeneration.inputLogs(LogType.info, "Click Hamburger Menu", null);
		
		TestUtil.waitTime(3);
		dashboard.clickMyAccounts(driver);
		
		TestUtil.waitTime(3);
		try{
			Assert.assertTrue(dashboard.myAccountDepositMenuIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "My Accounts Deposit Menu Tab is Displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "My Accounts Deposit Menu Tab is not Displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.myAccountCreditMenuIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "My Accounts Credit Menu Tab is Displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "My Accounts Credit Menu Tab is not Displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.myAccountPrepaidMenuIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "My Accounts Prepaid Menu Tab is Displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "My Accounts Prepaid Menu Tab is not Displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.myAccountCheckAndSavingsIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "My Accounts Checking and Savings on Deposit Tab is Displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "My Accounts Checking and Savings on Deposit Tab is not Displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.dashboardWidgetDataIsDisplayed(driver, "AccountType"));
			logGeneration.inputLogs(LogType.pass, "My Account Type on Deposit Tab is Displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "My Account Type on Deposit Tab is not Displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.dashboardWidgetDataIsDisplayed(driver, "AvailableBalance"));
			logGeneration.inputLogs(LogType.pass, "My Account Available Balance on Deposit Tab is Displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "My Account Available Blalance on Deposit Tab is not Displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.dashboardWidgetDataIsDisplayed(driver, "Currency"));
			logGeneration.inputLogs(LogType.pass, "My Account Currency on Deposit Tab is Displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "My Account Currency on Deposit Tab is not Displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.dashboardWidgetDataIsDisplayed(driver, "Account Number"));
			logGeneration.inputLogs(LogType.pass, "My Account Currency on Deposit Tab is Displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "My Account Currency on Deposit Tab is not Displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.dashboardWidgetDataIsDisplayed(driver, "AccountTag"));
			logGeneration.inputLogs(LogType.pass, "My Account Tag on Deposit Tab is Displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "My Account Tag on Deposit Tab is not Displayed", TestUtil.getScreenshot(driver));
		}
		
		
		
		logGeneration.extentFlush();
		driver.quit();
		
	}
	
	
}
