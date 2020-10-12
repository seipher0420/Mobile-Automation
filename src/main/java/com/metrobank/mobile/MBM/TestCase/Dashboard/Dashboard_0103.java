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

public class Dashboard_0103 extends MobileConnection{
	
	
	PropertyFileHandler property = new PropertyFileHandler(Locators.TESTDATA);
	
	@Test
	public void DashBoardViewPrepaidAccountOnly0102() throws IOException, InterruptedException{
		
		String prepaidWidget;
		String depositWidget;
		String depositAccountNumberWidget;
		String availableBalance;
		String depositText = "Deposits";
		
		LogGeneration logGeneration = new LogGeneration();
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		
		logGeneration.generateReport("0103 Dashboard Prepaid Card and Deposits");
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
		TestUtil.waitTime(10);
		
		depositWidget = dashboard.getDepositWidgetText(driver);
		
		dashboard.clickCustomizeMenu(driver);
		logGeneration.inputLogs(LogType.info, "Click Customize Menu", null);
		
		TestUtil.waitTime(3);
		dashboard.clickWidgetCredit(driver);
		logGeneration.inputLogs(LogType.info, "Remove Widget Credit", null);
		
		dashboard.clickWidgetShortcut(driver);
		logGeneration.inputLogs(LogType.info, "Remove Widget ShortCut", null);
		
		dashboard.clickWidgetPrepaid(driver);
		logGeneration.inputLogs(LogType.info, "Click Widget Prepaid", null);
		TestUtil.waitTime(3);
		dashboard.clickDonebtn(driver);
		logGeneration.inputLogs(LogType.info, "Click Done Button", null);
		TestUtil.waitTime(3);
		
		
		try{
			Assert.assertTrue(depositWidget.equals(depositText));
			logGeneration.inputLogs(LogType.pass, "Account Displayed Deposit Widget", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Account not displaying , screenshot", TestUtil.getScreenshot(driver));
		}
		
		depositAccountNumberWidget = dashboard.getDepositaccountDashBoard(driver).replaceAll("\\s+","");;
		availableBalance = dashboard.getDepositAvailableBalanceDashboard(driver);
		
		try{
			Assert.assertTrue(depositAccountNumberWidget.equals(property.GetValue("account_number_deposit")));
			logGeneration.inputLogs(LogType.pass, "Deposit Account on widget matches the customer account number: " + depositAccountNumberWidget, null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Deposit Account on widget doesn't match the customer account number", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(availableBalance != null);
			logGeneration.inputLogs(LogType.pass, "Available balance is: " + availableBalance, null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Available balance of customer is null: " + e , TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.PrepaidWidgetIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Prepaid Widget is Displayed ", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Prepaid Widget is not displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.navigationDashBoardIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Navigation bar dashboard is displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Navigation bar dashboard is not displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.navigationSendMoneyIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Navigation bar Send Money is displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Navigation bar Send Money is not displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.navigationSendLoadIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Navigation bar Send Load is displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Navigation bar Send Load is not displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.navigationPayBillsIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Navigation bar Pay Bills is displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Navigation bar Pay Bills is not displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.navigationMoreIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Navigation bar More button is displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Navigation bar More Button is not displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.hamburgerMenuIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Hamburger Menu is Displayed", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Hamburger Menu is not displayed", TestUtil.getScreenshot(driver));
		}
		
		logGeneration.extentFlush();
		driver.quit();
		
	}
}
