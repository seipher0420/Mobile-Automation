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

public class Dashboard_0119 extends MobileConnection{
	
	PropertyFileHandler property = new PropertyFileHandler(Locators.TESTDATA);
	
	@Test
	public void ViewingMainOptionNavigationBar0119() throws IOException, InterruptedException{
		LogGeneration logGeneration = new LogGeneration();
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		
		logGeneration.generateReport("0119 Viewing Main Option Navigation Bar");
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
		
		dashboard.clickHamburgerMenu(driver);
		logGeneration.inputLogs(LogType.info, "Click Hamburger Menu", null);
		
		try{
			TestUtil.waitTime(3);
			Assert.assertTrue(dashboard.hamburgerDashboardMenuIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "DashBoard Menu is Displayed on Hamburger Menu",  TestUtil.getScreenshot(driver));
			dashboard.clickDashBoard(driver);
			logGeneration.inputLogs(LogType.info, "Click Dashboard Hamburger Menu", null);
			try{
				TestUtil.waitTime(2);
				Assert.assertTrue(dashboard.navigationDashBoardIsDisplayed(driver));
				logGeneration.inputLogs(LogType.pass, "DashBoard Menu is Displayed upon clicking Dashboard choice on Hamburger Menu",  TestUtil.getScreenshot(driver));
			}catch(AssertionError e){
				logGeneration.inputLogs(LogType.fail, "DashBoard is not displayed upon clicking Dashboard choice on Hamburger", TestUtil.getScreenshot(driver));
			}
			
			
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "DashBoard Menu is not Displayed on Hamburger Menu", TestUtil.getScreenshot(driver));
		}

		dashboard.clickHamburgerMenu(driver);
		logGeneration.inputLogs(LogType.info, "Click Hamburger Menu", null);
		
		try{
			TestUtil.waitTime(3);
			Assert.assertTrue(dashboard.hamburgerMyAccountMenuIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "MyAccounts Menu is Displayed on Hamburger Menu",  TestUtil.getScreenshot(driver));
			dashboard.clickMyAccounts(driver);
			logGeneration.inputLogs(LogType.info, "Click MyAccounts Hamburger Menu", null);
			try{
				TestUtil.waitTime(2);
				Assert.assertTrue(dashboard.hamburgerMyAccountMenuIsDisplayed(driver));
				logGeneration.inputLogs(LogType.pass, "My Accounts Page is displayed",  TestUtil.getScreenshot(driver));
			}catch(AssertionError e){
				logGeneration.inputLogs(LogType.fail, "", TestUtil.getScreenshot(driver));
			}
	
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "MyAccounts Menu is not Displayed on Hamburger Menu", TestUtil.getScreenshot(driver));
		}
		
		try{
			TestUtil.waitTime(3);
			Assert.assertTrue(dashboard.myAccountDepositMenuIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "My Accounts Deposit Menu is displayed",  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "My Accounts Deposit Menu is not displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.myAccountCreditMenuIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "My Accounts Credit Menu is displayed",  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "My Accounts Credit Menu is not displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.myAccountPrepaidMenuIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "My Accounts Prepaid Menu is displayed",  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "My Accounts Prepaid Menu is not displayed", TestUtil.getScreenshot(driver));
		}
		
		logGeneration.extentFlush();
		driver.quit();
	}
	
	
}
