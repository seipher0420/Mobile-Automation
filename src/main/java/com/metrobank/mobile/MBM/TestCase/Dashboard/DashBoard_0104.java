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

public class DashBoard_0104 extends MobileConnection {

	
	PropertyFileHandler property = new PropertyFileHandler(Locators.TESTDATA);
	@Test
	public void DashBoardMenuValidationHamburgerMenu0104() throws IOException, InterruptedException{
		
		LogGeneration logGeneration = new LogGeneration();
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		
		logGeneration.generateReport("0104 Dashboard Hamburger Menu");
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
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "DashBoard Menu is not Displayed on Hamburger Menu", TestUtil.getScreenshot(driver));
		}
		
		try{
	
			Assert.assertTrue(dashboard.hamburgerMyAccountMenuIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "MyAccounts Menu is Displayed on Hamburger Menu",  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "MyAccounts Menu is not Displayed on Hamburger Menu", TestUtil.getScreenshot(driver));
		}
		
		
		try{

			Assert.assertTrue(dashboard.hamburgerLoansMenuIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Loans Menu is Displayed on Hamburger Menu",  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Loans Menu is not Displayed on Hamburger Menu", TestUtil.getScreenshot(driver));
		}
		
		
		try{

			Assert.assertTrue(dashboard.hamburgerUITFIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "UITF Menu is Displayed on Hamburger Menu",  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "UITF Menu is not Displayed on Hamburger Menu", TestUtil.getScreenshot(driver));
		}
		
		
		try{
	
			Assert.assertTrue(dashboard.hamburgerWealthManagerIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Wealth Manager Menu is Displayed on Hamburger Menu",  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Wealth Manager Menu is not Displayed on Hamburger Menu", TestUtil.getScreenshot(driver));
		}
		
		
		try{
	
			Assert.assertTrue(dashboard.hamburgerEnrolledAccountsMenuIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Enrolled Accounts Menu is Displayed on Hamburger Menu",  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Enrolled Accounts Menu is not Displayed on Hamburger Menu", TestUtil.getScreenshot(driver));
		}
		
		
		try{
	
			Assert.assertTrue(dashboard.hamburgerBillersMenuIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Billers Menu is Displayed on Hamburger Menu",  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Billers Menu is not Displayed on Hamburger Menu", TestUtil.getScreenshot(driver));
		}
		
		
		try{
	
			Assert.assertTrue(dashboard.hamburgerSchedulesMenuIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "DashBoard Menu is Displayed on Hamburger Menu",  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "DashBoard Menu is not Displayed on Hamburger Menu", TestUtil.getScreenshot(driver));
		}
		
		try{
	
			Assert.assertTrue(dashboard.hamburgerAllRequestsMenuIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "All Request Menu is Displayed on Hamburger Menu",  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "All Request Menu is not Displayed on Hamburger Menu", TestUtil.getScreenshot(driver));
		}
		
		try{

			Assert.assertTrue(dashboard.hamburgerLogOutMenuIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "All LogOut Menu is Displayed on Hamburger Menu",  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "All LogOut Menu is not Displayed on Hamburger Menu", TestUtil.getScreenshot(driver));
		}
		
		logGeneration.extentFlush();
		driver.close();
		
	}
	
}
