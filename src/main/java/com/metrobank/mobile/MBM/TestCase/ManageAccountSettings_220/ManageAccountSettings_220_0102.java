package main.java.com.metrobank.mobile.MBM.TestCase.ManageAccountSettings_220;

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
 * Manage Account Settings_220 01.02
 * Validation of Passcode Modal available options [button]
 * @author JVP
 */

public class ManageAccountSettings_220_0102 extends MobileConnection {

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
		logGeneration.generateReport("Manage Account Settings_220 01.02");
		
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
		myAccountsPage.clickPrimaryAccount(driver);
			logGeneration.inputLogs(LogType.info, "Click on PRIMARY ACCOUNT link",  null);
			TestUtil.waitTime(2);
		
		if (myAccountsPage.isPrimaryAccountDisplayed(driver) == true) {
			logGeneration.inputLogs(LogType.pass, "Primary Account is displayed",  TestUtil.getScreenshot(driver));
		} else {
			logGeneration.inputLogs(LogType.fail, "Primary Account is NOT Displayed", TestUtil.getScreenshot(driver));
		}
		
		//TODO : Tap 'Manage Account' button (gear icon)
		// TODO : Continue with steps
			
		
		// Quitting app and driver
		logGeneration.extentFlush();
		driver.quit();
	}
	
}
