package main.java.com.metrobank.mobile.MBM.TestCase.Dashboard.DepositAccOverview;

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

public class DepositAccountOverview_0107 extends MobileConnection{

	PropertyFileHandler property = new PropertyFileHandler(Locators.TESTDATA);

	@Test
	public void DepositAccountOverview0107() throws IOException, InterruptedException{
		

		
		LogGeneration logGeneration = new LogGeneration();
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		
		logGeneration.generateReport("Dashboard Viewing of Enrolled Active Deposit Account List via Menu Navigation button 0103");
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
		
		dashboard.clickDashboardDepositMyAccountOverview(driver);
		logGeneration.inputLogs(LogType.info, "Click Deposit Account for Overview", null);
		
		try{
			Assert.assertTrue(dashboard.dashboardDepositOverviewIsDisplayed(driver, "AvailableBalance"));
			logGeneration.inputLogs(LogType.pass, "Deposit Account Overview Available Balance is displayed", TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Deposit Account Overview Available Balance is not displayed", TestUtil.getScreenshot(driver));
		}
		
		
		try{
			Assert.assertTrue(dashboard.dashboardDepositOverviewIsDisplayed(driver, "CurrentBalance"));
			logGeneration.inputLogs(LogType.pass, "Deposit Account Overview CurrentBalance is displayed", TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Deposit Account Overview CurrentBalance is not displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.dashboardDepositOverviewIsDisplayed(driver, "Alias"));
			logGeneration.inputLogs(LogType.pass, "Deposit Account Overview Alias is displayed", TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Deposit Account Overview Alias is not displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.dashboardDepositOverviewIsDisplayed(driver, "Currency"));
			logGeneration.inputLogs(LogType.pass, "Deposit Account Overview Currency is displayed", TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Deposit Account Overview Currency is not displayed", TestUtil.getScreenshot(driver));
		}
		
		
		
		try{
			Assert.assertTrue(dashboard.dashboardDepositOverviewIsDisplayed(driver, "AccountType"));
			logGeneration.inputLogs(LogType.pass, "Deposit Account Overview AccountType is displayed", TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Deposit Account Overview AccountType is not displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.dashboardDepositOverviewIsDisplayed(driver, "AccountNumber"));
			logGeneration.inputLogs(LogType.pass, "Deposit Account Overview AccountNumber is displayed", TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Deposit Account Overview AccountNumber is not displayed", TestUtil.getScreenshot(driver));
		}
		
		
		try{
			Assert.assertTrue(dashboard.dashboardDepositOverviewIsDisplayed(driver, "AccountNumberImage"));
			logGeneration.inputLogs(LogType.pass, "Deposit Account Overview AccountNumberImage is displayed", TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Deposit Account Overview AccountNumberImage is not displayed", TestUtil.getScreenshot(driver));
		}
		
		
		try{
			Assert.assertTrue(dashboard.dashboardDepositOverviewIsDisplayed(driver, "AliasImage"));
			logGeneration.inputLogs(LogType.pass, "Deposit Account Overview AliasImage is displayed", TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Deposit Account Overview AliasImage is not displayed", TestUtil.getScreenshot(driver));
		}
		
		TestUtil.waitTime(2);
		for (int i=0;  i<4;i++) {
		    TestUtil.swipeDown(driver, 0.1);
		}
		
		try{
			Assert.assertTrue(dashboard.dashboardDepositOverviewActionIsDisplayed(driver, "PayBills"));
			logGeneration.inputLogs(LogType.pass, "Deposit Account Overview Action Paybills is displayed", TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Deposit Account Overview Action Paybills is not displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(dashboard.dashboardDepositOverviewActionIsDisplayed(driver, "SendMoney"));
			logGeneration.inputLogs(LogType.pass, "Deposit Account Overview Action SendMoney is displayed", TestUtil.getScreenshot(driver));
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Deposit Account Overview  Action SendMoney is not displayed", TestUtil.getScreenshot(driver));
		}
		
		
		logGeneration.extentFlush();
		driver.quit();
		
	}


}
