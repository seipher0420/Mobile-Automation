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
 * 01.01 - Accessibility of 'My Accounts' screen
 * 01.02 - Validation of 'My Accounts' screen upon accessed with an enrolled account (Deposit/Credit/Prepaid)
 * 01.03 - Validation of 'My Accounts' screen Elements when user has an enrolled account (Deposit/Credit/Prepaid)
 * 01.06 - Validation of function by tapping the specific enrolled account in 'My Accounts' Screen
 * @author JVP
 */

public class ManageAccountSettings_225_0101_02_03_06 extends MobileConnection {

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
		logGeneration.generateReport("Manage Account Settings_225 01.01");
		
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
		
		/* TC 01.02 */
		logGeneration.generateReport("Manage Account Settings_225 01.02");
		// Deposit Accounts
		if (myAccountsPage.isDepositTabDisplayed(driver) == true) {
			logGeneration.inputLogs(LogType.pass, "'DEPOSIT' Tab is Displayed",  TestUtil.getScreenshot(driver));
		} else {
			logGeneration.inputLogs(LogType.fail, "'DEPOSIT' Tab is NOT Displayed", TestUtil.getScreenshot(driver));
		}
		// Credit Accounts
		if (myAccountsPage.isCreditTabDisplayed(driver) == true) {
			logGeneration.inputLogs(LogType.pass, "'CREDIT' Tab is Displayed",  TestUtil.getScreenshot(driver));
		} else {
			logGeneration.inputLogs(LogType.fail, "'CREDIT' Tab is NOT Displayed", TestUtil.getScreenshot(driver));
		}
		// Prepaid Accounts
		if (myAccountsPage.isPrepaidTabDisplayed(driver) == true) {
			logGeneration.inputLogs(LogType.pass, "'PREPAID' Tab is Displayed",  TestUtil.getScreenshot(driver));
		} else {
			logGeneration.inputLogs(LogType.fail, "'PREPAID' Tab is NOT Displayed", TestUtil.getScreenshot(driver));
		}
		
		
		/* TC 01.03 */
		logGeneration.generateReport("Manage Account Settings_225 01.03");
		
		if (myAccountsPage.isCheckingAndSavingsHeaderDisplayed(driver) == true) {
			logGeneration.inputLogs(LogType.pass, "'CHECKING & SAVINGS' Header is Displayed",  TestUtil.getScreenshot(driver));
		} else {
			logGeneration.inputLogs(LogType.fail, "'CHECKING & SAVINGS' Header is NOT Displayed", TestUtil.getScreenshot(driver));
		}
		
		if (myAccountsPage.isPrimaryAccountDisplayed(driver) == true) {
			logGeneration.inputLogs(LogType.pass, "Primary Account is Displayed",  TestUtil.getScreenshot(driver));
		} else {
			logGeneration.inputLogs(LogType.fail, "Primary Account is NOT Displayed", TestUtil.getScreenshot(driver));
		}
		
		if (myAccountsPage.isEnrollButtonDisplayed(driver) == true) {
			logGeneration.inputLogs(LogType.pass, "Enroll button is Displayed",  TestUtil.getScreenshot(driver));
		} else {
			logGeneration.inputLogs(LogType.fail, "Enroll button is NOT Displayed", TestUtil.getScreenshot(driver));
		}
		
		/* TC 01.06 */
		logGeneration.generateReport("Manage Account Settings_225 01.06");
		
		myAccountsPage.clickPrimaryAccount(driver);
			logGeneration.inputLogs(LogType.info, "Click on PRIMARY ACCOUNT link",  null);
			TestUtil.waitTime(2);
			if (myAccountsPage.isPrimaryAccountDisplayed(driver) == true) {
				logGeneration.inputLogs(LogType.pass, "Primary Account is displayed",  TestUtil.getScreenshot(driver));
			} else {
				logGeneration.inputLogs(LogType.fail, "Primary Account is NOT Displayed", TestUtil.getScreenshot(driver));
			}
		
			
			
		// Quitting app and driver
		logGeneration.extentFlush();
		driver.quit();
	}
	
}
