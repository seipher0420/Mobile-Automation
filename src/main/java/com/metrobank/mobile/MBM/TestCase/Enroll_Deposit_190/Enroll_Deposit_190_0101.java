package main.java.com.metrobank.mobile.MBM.TestCase.Enroll_Deposit_190;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.java.com.metrobank.mobile.MBM.DashBoard.DashBoard;
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
 * Login Enroll Deposit_190 01.01 
 * Validation of incorrect attempts for OTP Entry 2-4 times
 * @author testuser
 *
 */

public class Enroll_Deposit_190_0101 extends MobileConnection {

	private PropertyFileHandler property;
	private String username, password;
	AppiumDriver<MobileElement> driver;
	
	@Test
	public void connectionMobile() throws InterruptedException, IOException{
		
		property = new PropertyFileHandler(TestData.ENROLL_DEPOSIT);
		username = property.GetValue("username");
		password = property.GetValue("password");
		String accountNumber = property.GetValue("accountNumber");
		String commonAlias = property.GetValue("commonAlias");
		String OTP = property.GetValue("OTP");
		
		// Setup Logger
		LogGeneration logGeneration = new LogGeneration();
		logGeneration.generateReport("Enroll Deposit_190 01.01");
		
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
		myAccountsPage.inputAccountNumber(driver, accountNumber);
			logGeneration.inputLogs(LogType.info, 
				String.format("Input Account Number : {%s}", accountNumber),  null);
			TestUtil.waitTime(1);
		myAccountsPage.inputAccountAlias(driver, commonAlias);
			logGeneration.inputLogs(LogType.info, 
				String.format("Input Account Alias : {%s}", commonAlias),  null);
			TestUtil.waitTime(1);
		myAccountsPage.clickEnrollBtn(driver);			// first click to lose focus
		myAccountsPage.clickEnrollBtn(driver);
			logGeneration.inputLogs(LogType.info, "Click on ENROLL button",  null);
			TestUtil.waitTime(5);
			
		// Validation of Verification Screen
		if (myAccountsPage.isVerificationTitleDisplayed(driver) == true) {
				logGeneration.inputLogs(LogType.pass, "Verification Screen FOUND",  TestUtil.getScreenshot(driver));
				TestUtil.waitTime(2);
			/*
			 * Repeat steps 2-4 times
			 */
			for (int index = 0; index < 4; index++) {
				myAccountsPage.inputOTP(driver, OTP);
				logGeneration.inputLogs(LogType.info, String.format("Input OTP : {%s}", OTP),  null);
			myAccountsPage.clickNextBtn(driver);
				logGeneration.inputLogs(LogType.info, "Click on NEXT button",  null);
				TestUtil.waitTime(10);
				if (myAccountsPage.isErrorInvalidPasscodeExceededDisplayed(driver) == true) {
					String errMsg = myAccountsPage.getAccountNumberErrorMessage(driver);
					logGeneration.inputLogs(LogType.pass, 
							String.format("Error Message found : {%s}", errMsg),  TestUtil.getScreenshot(driver));
					if (myAccountsPage.clickNextBtn(driver) == true) {
						logGeneration.inputLogs(LogType.info, "Click on NEXT button",  null);
					} else {
						logGeneration.inputLogs(LogType.fail, "NEXT button is not ENABLED",  TestUtil.getScreenshot(driver));
					}
					
				} else {
					logGeneration.inputLogs(LogType.fail, "Error Message NOT FOUND", TestUtil.getScreenshot(driver));
					if (myAccountsPage.clickNextBtn(driver) == true) {
						logGeneration.inputLogs(LogType.info, "Click on NEXT button",  null);
					} else {
						logGeneration.inputLogs(LogType.fail, "NEXT button is not ENABLED",  TestUtil.getScreenshot(driver));
					}
				}
			}
			/*
			 * Repeat steps 2-4 times
			 */
		} else {
			logGeneration.inputLogs(LogType.fail, 
					"Verification Screen NOT FOUND",  
					TestUtil.getScreenshot(driver));
		}
			
//		CommonMethods.Logout(driver);
		
		// Quitting app and driver
		logGeneration.extentFlush();
		driver.quit();
	}
	
}
