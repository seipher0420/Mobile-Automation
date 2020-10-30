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

public class Dashboard_0129 extends MobileConnection{

	PropertyFileHandler property = new PropertyFileHandler(Locators.TESTDATA);
	@Test
	public void ViewingofDepositWidget() throws IOException, InterruptedException{
		
		String accountType, accountNumber, accountTag, accountCurrency, accountBalance;
		
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
		if(dashboard.getSessionBrowserIsDisplayed(driver) != null){
			logGeneration.inputLogs(LogType.warning, "Message A session on another browser or device has ended is displayed", TestUtil.getScreenshot(driver));
			dashboard.clickOkBtnSession(driver);
			TestUtil.waitTime(5);
		}
		
		logGeneration.inputLogs(LogType.info, "Dashboard is displayed", null);
		
		TestUtil.waitTime(3);
		accountBalance = dashboard.getDepositAvailableBalanceDashboard(driver);
		accountTag = dashboard.getDepositAccountTagDashboard(driver);
		accountCurrency = dashboard.getDepositAccountCurrencyDashboard(driver);
		accountNumber = dashboard.getDepositaccountDashBoard(driver);
		accountType = dashboard.getDepositAccountTypeDashboard(driver);
		try{
			Assert.assertTrue(dashboard.dashboardWidgetDataIsDisplayed(driver, "AccountType"));
			logGeneration.inputLogs(LogType.pass, "Account Type is Displayed: " + accountType ,  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Account Type is not Displayed" , TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.dashboardWidgetDataIsDisplayed(driver, "AvailableBalance"));
			logGeneration.inputLogs(LogType.pass, "Available Balance is Displayed: " + accountBalance ,  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Available Balance is not Displayed" , TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.dashboardWidgetDataIsDisplayed(driver, "Currency"));
			logGeneration.inputLogs(LogType.pass, "Currency is Displayed: "+ accountCurrency ,  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Currency is not Displayed" , TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.dashboardWidgetDataIsDisplayed(driver, "Account Number"));
			logGeneration.inputLogs(LogType.pass, "Account Number is Displayed: " + accountNumber ,  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Account Number is not Displayed" , TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.dashboardWidgetDataIsDisplayed(driver, "AccountTag"));
			logGeneration.inputLogs(LogType.pass, "Account Tag is Displayed: " + accountTag ,  TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Account Tag is not Displayed" , TestUtil.getScreenshot(driver));
		}
		
		
		logGeneration.extentFlush();
		driver.quit();
	
	
	}
}
