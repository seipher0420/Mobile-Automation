package main.java.com.metrobank.mobile.MBM.TestCase.RecoverAccess_248;

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
 * Recover Access_248 01.04
 * Validation of Forgot password screen
 * @author testuser
 *
 */

public class RecoverAccess_248_0104 extends MobileConnection {

	private PropertyFileHandler property;
	private String username, password;
	AppiumDriver<MobileElement> driver;
	
	@Test
	public void connectionMobile() throws InterruptedException, IOException{
		
		property = new PropertyFileHandler(TestData.RECOVER_ACCESS);
		username = property.GetValue("username");
		password = property.GetValue("password");
		
		// Setup Logger
		LogGeneration logGeneration = new LogGeneration();
		logGeneration.generateReport("Recover Access_248 01.04");
		
		// Setup mobile connection
		driver = mobileOS("Android");	
		TestUtil.waitTime(5);
		
		// Setup Pages
		LoginPage loginPage = new LoginPage();
		
		if (loginPage.isRecoverAccessDisplayed(driver) == true) {
			logGeneration.inputLogs(LogType.pass, "Recover Access link FOUND",  TestUtil.getScreenshot(driver));
		} else {
			logGeneration.inputLogs(LogType.fail, "Recover Access link NOT FOUND", TestUtil.getScreenshot(driver));
		}
			
		loginPage.clickRecoverAccess(driver);
			logGeneration.inputLogs(LogType.info, "Click on RECOVER ACCESS link",  null);
			TestUtil.waitTime(2);
		// TODO : Tap 'I forgot my password'
			// TODO : Validate username or email field is displayed
		
			
		// Quitting app and driver
		logGeneration.extentFlush();
		driver.quit();
	}
	
}