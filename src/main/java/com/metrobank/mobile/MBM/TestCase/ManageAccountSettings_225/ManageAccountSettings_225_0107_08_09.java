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
 * Manage Account Settings_225 01.07-09
 * 01.07 - Validation of Account Setting screen accessibility
 * 01.08 - Validation of 'Delete or Unenroll Account' button function in Account Setting Screen when user has only 1 account
 * 01.09 - Validation of user's redirection when tapping the "Go Back" button in error message
 * @author JVP
 */

public class ManageAccountSettings_225_0107_08_09 extends MobileConnection {

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
		logGeneration.generateReport("Manage Account Settings_225 01.07");
		
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
		
		//TODO : Tap 'Manage Account' button (gear icon)
			
		/* TC 01.08 */
		logGeneration.generateReport("Manage Account Settings_225 01.08");	
		// TODO : Tap 'Delete or Unenroll Account' button and validate error message
		
		
		/* TC 01.09 */
		logGeneration.generateReport("Manage Account Settings_225 01.09");	
		// TODO : Tap 'Go back' button and validate redirect to Account Settings Screen	
			
		
		
		// Quitting app and driver
		logGeneration.extentFlush();
		driver.quit();
	}
	
}
