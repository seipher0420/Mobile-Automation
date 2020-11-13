package main.java.com.metrobank.mobile.MBM.TestCase.ManageAccountSettings_225;

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
 * Manage Account Settings_225 01.20
 * Validation of Account Setting - Passcode Modal when user inputs an invalid passcode (e.g. incomplete)
 * @author JVP
 */

public class ManageAccountSettings_225_0128 extends MobileConnection {

	private PropertyFileHandler property;
	private String username, password;
	AppiumDriver<MobileElement> driver;
	
	@Test
	public void connectionMobile() throws InterruptedException, IOException {
		
		property = new PropertyFileHandler(TestData.MANAGE_ACCOUNT_SETTINGS);
		username = property.GetValue("username");
		password = property.GetValue("password");
		String accountNumber = property.GetValue("accountNumber");
		String accountAlias = property.GetValue("accountAlias");
		String OTP = "XXXXXX";
		
		// Setup Logger
		LogGeneration logGeneration = new LogGeneration();
		logGeneration.generateReport("Manage Account Settings_225 01.20");
		
		// Setup mobile connection
		driver = mobileOS("Android");	
		TestUtil.waitTime(5);
		
		// Setup Pages
		DashBoard dashboard = new DashBoard();
		MyAccountsPage myAccountsPage = new MyAccountsPage();
		
		CommonMethods.Login(driver, username, password);
		
		dashboard.clickHamburgerMenu(driver);
			logGeneration.inputLogs(LogType.info, "Click on MENU BAR",  null);
			TestUtil.waitTime(1);
		dashboard.clickMyAccounts(driver);
			logGeneration.inputLogs(LogType.info, "Click on MY ACCOUNTS link",  null);
		dashboard.clickMyAccountsEnroll(driver);
			logGeneration.inputLogs(LogType.info, "Click on ENROLL button",  null);
			TestUtil.waitTime(2);
			
		// My Accounts Page
		myAccountsPage.inputAccountNumber(driver, accountNumber);
			logGeneration.inputLogs(LogType.info, 
				String.format("Input Account Number : {%s}", accountNumber),  null);
			TestUtil.waitTime(1);
			// Defect found ^
		myAccountsPage.inputAccountAlias(driver, accountAlias);
			logGeneration.inputLogs(LogType.info, 
				String.format("Input Account Alias : {%s}", accountAlias),  null);
			TestUtil.waitTime(1);
		myAccountsPage.clickEnrollBtn(driver);
			logGeneration.inputLogs(LogType.info, "Click on ENROLL button",  null);
			TestUtil.waitTime(3);
		myAccountsPage.clickEnrollBtn(driver);			// first click to lose focus
		myAccountsPage.clickEnrollBtn(driver);
			logGeneration.inputLogs(LogType.info, "Click on ENROLL button",  null);
			TestUtil.waitTime(5);
		if (myAccountsPage.isVerificationTitleDisplayed(driver) == true) {
			logGeneration.inputLogs(LogType.pass, "Verification Screen FOUND",  null);
			TestUtil.waitTime(15);  // delay for input of OTP manually
				logGeneration.inputLogs(LogType.info, String.format("Input OTP : {%s}", OTP),  null);
			myAccountsPage.clickNextBtn(driver);
				logGeneration.inputLogs(LogType.info, "Click on NEXT button",  null);
				TestUtil.waitTime(10);
		} else {
			logGeneration.inputLogs(LogType.fail, 
					"Verification Screen NOT FOUND",  
					TestUtil.getScreenshot(driver));
		}
		
		
		// Quitting app and driver
		logGeneration.extentFlush();
		driver.quit();
	}
	
}
