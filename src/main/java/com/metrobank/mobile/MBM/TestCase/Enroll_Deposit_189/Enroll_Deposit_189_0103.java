package main.java.com.metrobank.mobile.MBM.TestCase.Enroll_Deposit_189;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.java.com.metrobank.mobile.MBM.DashBoard.DashBoard;
import main.java.com.metrobank.mobile.MBM.LoginPage.LoginPage;
import main.java.com.metrobank.mobile.MBM.MyAccounts.MyAccountsPage;
import main.java.com.metrobank.mobile.MBM.TestCase.Common.CommonMethods;
import main.java.com.metrobank.mobile.MBM.TestCase.Common.TestData;
import main.java.com.metrobank.mobile.core.base.MobileConnection;
import main.java.com.metrobank.mobile.core.base.Enums.LogType;
import main.java.com.metrobank.mobile.core.logger.LogGeneration;
import main.java.com.metrobank.mobile.core.utilities.PropertyFileHandler;
import main.java.com.metrobank.mobile.core.utilities.TestUtil;

/**
 * @Description
 * Login Enroll Deposit_189 01.03 
 * Enroll account screen when user entered an account number that is not acceptable to be enrolled
 * @author testuser
 *
 */

public class Enroll_Deposit_189_0103 extends MobileConnection {

	private PropertyFileHandler property;
	private String username, password;
	AppiumDriver<MobileElement> driver;
	
	@Test
	public void connectionMobile() throws InterruptedException, IOException{
		
		property = new PropertyFileHandler(TestData.ENROLL_DEPOSIT);
		username = property.GetValue("username");
		password = property.GetValue("password");
		String unacceptableAccountNumber = property.GetValue("unacceptableAccountNumber");
		String accountAlias = property.GetValue("accountAlias");
		
		// Setup Logger
		LogGeneration logGeneration = new LogGeneration();
		logGeneration.generateReport("Enroll Deposit_189 01.03");
		
		// Setup mobile connection
		driver = mobileOS("Android");	
		Thread.sleep(5000);
		
		// Setup Pages
		DashBoard dashboard = new DashBoard();
		MyAccountsPage myAccountsPage = new MyAccountsPage();
		
		CommonMethods.Login(driver, username, password);
		
		dashboard.clickHamburgerMenu(driver);
			TestUtil.waitTime(1);
		dashboard.clickMyAccounts(driver);
			TestUtil.waitTime(1);
		dashboard.clickMyAccountsEnroll(driver);
			TestUtil.waitTime(2);
			
		// My Accounts Page
		myAccountsPage.inputAccountNumber(driver, unacceptableAccountNumber);
			logGeneration.inputLogs(LogType.info, 
				String.format("Input Account Number : {%s}", unacceptableAccountNumber),  null);
			TestUtil.waitTime(1);
			// Defect found ^
		myAccountsPage.inputAccountAlias(driver, accountAlias);
			logGeneration.inputLogs(LogType.info, 
				String.format("Input Account Alias : {%s}", accountAlias),  null);
			TestUtil.waitTime(1);
		myAccountsPage.clickEnrollBtn(driver);
			logGeneration.inputLogs(LogType.info, "Click on ENROLL button",  null);
			TestUtil.waitTime(3);
		
//		if (myAccountsPage.isErrorAccountDoesNotExistDisplayed(driver) == true) {
		if (myAccountsPage.isErrorCannotValidateDisplayed(driver) == true) {
			String errMsg = myAccountsPage.getAccountNumberErrorMessage(driver);
			logGeneration.inputLogs(LogType.pass, 
					String.format("Error Message found : {%s}", errMsg),  TestUtil.getScreenshot(driver));
		} else {
			logGeneration.inputLogs(LogType.fail, 
					"Error Message NOT FOUND.",  
					TestUtil.getScreenshot(driver));
		}
			
//		CommonMethods.Logout(driver);
		
		// Quitting app and driver
		logGeneration.extentFlush();
		driver.quit();
	}
	
}
