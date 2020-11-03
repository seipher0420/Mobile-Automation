package main.java.com.metrobank.mobile.MBM.TestCase.Enroll_Deposit_189;

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
 * Login Enroll Deposit_189 01.01 
 * Validation of enroll account screen when no data in account number and alias
 * @author testuser
 *
 */

public class Enroll_Deposit_189_0101 extends MobileConnection {

	private PropertyFileHandler property;
	private String username, password;
	AppiumDriver<MobileElement> driver;
	
	@Test
	public void connectionMobile() throws InterruptedException, IOException{
		
		property = new PropertyFileHandler(TestData.ENROLL_DEPOSIT);
		username = property.GetValue("username");
		password = property.GetValue("password");
		
		// Setup Logger
		LogGeneration logGeneration = new LogGeneration();
		logGeneration.generateReport("Enroll Deposit_189 01.01");
		
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
		
		if (myAccountsPage.isErrorDisplayed(driver) == true) {
			String errMsg = myAccountsPage.getAccountNumberErrorMessage(driver);
			logGeneration.inputLogs(LogType.pass, errMsg,  null);
		} else {
			logGeneration.inputLogs(LogType.fail, 
					"Error Message NOT FOUND. Enroll button is NOT ENABLED",  
					TestUtil.getScreenshot(driver));
//			logGeneration.inputLogs(LogType.fail, "Enroll button is DISABLED",  TestUtil.getScreenshot(driver));
		}
			
//		CommonMethods.Logout(driver);
		
		// Quitting app and driver
		logGeneration.extentFlush();
		driver.quit();
	}
	
}
