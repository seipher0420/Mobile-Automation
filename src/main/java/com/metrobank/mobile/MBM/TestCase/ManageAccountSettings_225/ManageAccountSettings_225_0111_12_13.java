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
 * Manage Account Settings_225 01.11-13
 * 01.11 - Validation of the prompt message when user taps on the remove/delete account button to delete his/her other accounts
 * 01.12 - Validation of function by tapping 'Cancel' button on the delete account prompt modal
 * 01.13 - Validation of user's redirection when tapping the "Go Back" button in error message
 * @author JVP
 */

public class ManageAccountSettings_225_0111_12_13 extends MobileConnection {

	private PropertyFileHandler property;
	private String username, password;
	AppiumDriver<MobileElement> driver;
	
	@Test
	public void connectionMobile() throws InterruptedException, IOException{
		
		property = new PropertyFileHandler(TestData.MANAGE_ACCOUNT_SETTINGS);
		username = property.GetValue("username");
		password = property.GetValue("password");
		
		// Setup Logger
		LogGeneration logGeneration = new LogGeneration();
		logGeneration.generateReport("Manage Account Settings_225 01.11");
		
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
			TestUtil.waitTime(1);
			if (myAccountsPage.isMyAccountsTitleDisplayed(driver) == true) {
				logGeneration.inputLogs(LogType.pass, "'My Accounts' title is displayed",  TestUtil.getScreenshot(driver));
			} else {
				logGeneration.inputLogs(LogType.fail, "'My Accounts' title is NOT Displayed", TestUtil.getScreenshot(driver));
			}
			
		myAccountsPage.clickPrimaryAccount(driver);
			logGeneration.inputLogs(LogType.info, "Click on PRIMARY ACCOUNT link",  null);
			TestUtil.waitTime(2);
			if (myAccountsPage.isPrimaryAccountDisplayed(driver) == true) {
				logGeneration.inputLogs(LogType.pass, "Primary Account is displayed",  TestUtil.getScreenshot(driver));
			} else {
				logGeneration.inputLogs(LogType.fail, "Primary Account is NOT Displayed", TestUtil.getScreenshot(driver));
			}
		
		// TODO : Tap 'Manage Account' button (gear icon)
		// TODO : Tap 'Delete or Unenroll Account' button and validate prompt modal message
			
		/* TC 01.12 */
		logGeneration.generateReport("Manage Account Settings_225 01.12");	
		// TODO : Tap 'Cancel' button and validate redirect to Account Settings Screen
		
		
		/* TC 01.13 */
		logGeneration.generateReport("Manage Account Settings_225 01.13");
		// TODO : Repeat steps to delete/unenroll account
		// TODO : Tap 'Delete' button and validate Passcode Modal is displayed	
			
		
		
		// Quitting app and driver
		logGeneration.extentFlush();
		driver.quit();
	}
	
}
