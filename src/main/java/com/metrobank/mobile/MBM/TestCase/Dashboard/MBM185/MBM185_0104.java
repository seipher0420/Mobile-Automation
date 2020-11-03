package main.java.com.metrobank.mobile.MBM.TestCase.Dashboard.MBM185;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;

import main.java.com.metrobank.mobile.MBM.DashBoard.DashBoard;
import main.java.com.metrobank.mobile.MBM.Enrollment.EnrollmentPage;
import main.java.com.metrobank.mobile.MBM.LoginPage.LoginPage;
import main.java.com.metrobank.mobile.core.base.MobileConnection;
import main.java.com.metrobank.mobile.core.base.Enums.LogType;
import main.java.com.metrobank.mobile.core.locator.Locators;
import main.java.com.metrobank.mobile.core.logger.LogGeneration;
import main.java.com.metrobank.mobile.core.utilities.PropertyFileHandler;
import main.java.com.metrobank.mobile.core.utilities.TestUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MBM185_0104 extends MobileConnection{

	PropertyFileHandler property = new PropertyFileHandler(Locators.TESTDATA);

	@Test
	public void DashBoardViewDepositAccountOnly0102() throws IOException, InterruptedException{
		

		
		LogGeneration logGeneration = new LogGeneration();
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		EnrollmentPage enrollmentPage = new EnrollmentPage();
		
		logGeneration.generateReport("MBM 183 Validation of Next button in 'Verification' screen when user does not yet entered an OTP code 0102");
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
		dashboard.clickOkBtnSession(driver);
		TestUtil.waitTime(5);
		
		dashboard.clickHamburgerMenu(driver);
		logGeneration.inputLogs(LogType.info, "Click Hamburger Menu", null);
		
		TestUtil.waitTime(3);
		dashboard.clickMyAccounts(driver);
		
		TestUtil.waitTime(5);
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
		
		enrollmentPage.clickEnrollBtn(driver);
		logGeneration.inputLogs(LogType.pass, "Click Enroll Button on My Accounts Page", null);
		TestUtil.waitTime(3);
		try{
			Assert.assertTrue(enrollmentPage.isAccountNumberDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Input Account Number is displayed and blank", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Input Account Number is not displayed", TestUtil.getScreenshot(driver));
		}
		
		try{
			Assert.assertTrue(enrollmentPage.isAccountAliasDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Input Account Alias is displayed and blank", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Input Account Alias is not displayed", TestUtil.getScreenshot(driver));
		}

		
		enrollmentPage.clickEnrollBtn(driver);
		TestUtil.waitTime(3);
		
		String accountNumber = property.GetValue("AccountNumber_185102");
		String alias = property.GetValue("AccountAlias_185102");
		enrollmentPage.inputAccountNumberEnrollment(driver, accountNumber);
		enrollmentPage.ClickEnrollAccountBtn(driver);
		logGeneration.inputLogs(LogType.info, "Input Account Number: " + accountNumber, null);
		TestUtil.waitTime(2);
		enrollmentPage.inputAccountAlias(driver, alias);
		logGeneration.inputLogs(LogType.info, "Input Alias: " + alias, null);
		TestUtil.waitTime(5);
		enrollmentPage.ClickEnrollAccountBtn(driver);
		TestUtil.waitTime(5);
		
		try{
			Assert.assertTrue(enrollmentPage.enrollmentVerifyOtpPageSendCodeBtnIsDisplayed(driver));
			logGeneration.inputLogs(LogType.pass, "Verify OTP Page send another code button is Displayed and Enabled", null);
		}catch(AssertionError e){
			logGeneration.inputLogs(LogType.fail, "Verify OTP Page send another code button is not Displayed", TestUtil.getScreenshot(driver));
			
		}
		TestUtil.waitTime(3);

		
		
		TestUtil.waitTime(3);
		logGeneration.extentFlush();
		driver.quit();
	}
}
