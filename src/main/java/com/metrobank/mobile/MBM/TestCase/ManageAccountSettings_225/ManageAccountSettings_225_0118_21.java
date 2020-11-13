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
 * Manage Account Settings_225 
 * 01.18 - Validation of 'Proceed' button in Account Setting - Passcode Modal when user entered a valid or invalid code
 * 01.21 - Validation of Account Setting - Passcode Modal function when user inputs a complete passcode but incorrect
 * @author JVP
 */

public class ManageAccountSettings_225_0118_21 extends MobileConnection {

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
		logGeneration.generateReport("Manage Account Settings_225 01.18");
		
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
		// TODO : Tap 'Delete or Unenroll Account' button and validate prompt modal notification
		// TODO : Tap 'Delete' button and validate Passcode Modal is displayed	
		// TODO : Enter passcode (invalid)
		// TODO : Validate 'Proceed' button is enabled
		
			
		/* TC 01.12 */
		logGeneration.generateReport("Manage Account Settings_225 01.21");	
		// TODO : Validate the prompt modal error message
			
		
		// Quitting app and driver
		logGeneration.extentFlush();
		driver.quit();
	}
	
}
