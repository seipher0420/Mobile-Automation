package main.java.com.metrobank.mobile.MBM.TestCase.Login;

import java.io.IOException;

import org.testng.annotations.Test;

import main.java.com.metrobank.mobile.MBM.DashBoard.DashBoard;
import main.java.com.metrobank.mobile.MBM.LoginPage.LoginPage;
import main.java.com.metrobank.mobile.core.base.MobileConnection;
import main.java.com.metrobank.mobile.core.base.Enums.LogType;
import main.java.com.metrobank.mobile.core.logger.LogGeneration;
import main.java.com.metrobank.mobile.core.utilities.PropertyFileHandler;
import main.java.com.metrobank.mobile.core.utilities.TestUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @Description
 * Login Test Case 01.63
 * Case sensitive username validation
 * @author testuser
 *
 */

public class Login_TCID_01_63 extends MobileConnection{
	
	private PropertyFileHandler property;
	private String username_allcaps, username_smallLetters, username_combination, password;
	
	@Test
	public void connectionMobile() throws InterruptedException, IOException{
		
		property = new PropertyFileHandler(TestData.LOGIN);
		username_allcaps = property.GetValue("username_63a");
		username_smallLetters = property.GetValue("username_63b");
		username_combination = property.GetValue("username_63c");
		password = property.GetValue("password_63");
		
		// Setup Logger
		LogGeneration logGeneration = new LogGeneration();
		logGeneration.generateReport("Login TCID 01.63");
		
		// Setup Pages
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		
		// Setup mobile connection
		AppiumDriver<MobileElement> driver = mobileOS("Android");	
		Thread.sleep(5000);
		
		//Script starts here
		loginPage.inputUsername(driver, username_allcaps);
		Thread.sleep(5000);
		loginPage.inputPassword(driver, password);
		Thread.sleep(5000);
		loginPage.clickLoginBtn(driver);
		Thread.sleep(10000);
		
		// Validations 1 - ALL CAPS
		if (dashboard.VerifySuccessfulLogin(driver) == true) {
			logGeneration.inputLogs(LogType.pass, String.format("Login Successful! {%s}", username_allcaps),  null);
		} else {
			logGeneration.inputLogs(LogType.pass, "Login Failed!",  TestUtil.getScreenshot(driver));
		}
		
		dashboard.clickLogoutBtnDashboard(driver);
			logGeneration.inputLogs(LogType.info, "Click on LOGOUT button",  null);
			TestUtil.waitTime(1);
		dashboard.confirmLogout(driver);
			logGeneration.inputLogs(LogType.info, "Click on CONFIRM LOGOUT button",  null);
			TestUtil.waitTime(3);
		
		// SMALL LETTERS USERNAME
		loginPage.inputUsername(driver, username_smallLetters);
		Thread.sleep(5000);
		loginPage.inputPassword(driver, password);
		Thread.sleep(5000);
		loginPage.clickLoginBtn(driver);
		Thread.sleep(10000);
		
		// Validations 2 - small letters
		if (dashboard.VerifySuccessfulLogin(driver) == true) {
			logGeneration.inputLogs(LogType.pass, String.format("Login Successful! {%s}", username_smallLetters),  null);
		} else {
			logGeneration.inputLogs(LogType.pass, "Login Failed!",  TestUtil.getScreenshot(driver));
		}
		
		dashboard.clickLogoutBtnDashboard(driver);
			logGeneration.inputLogs(LogType.info, "Click on LOGOUT button",  null);
			TestUtil.waitTime(1);
		dashboard.confirmLogout(driver);
			logGeneration.inputLogs(LogType.info, "Click on CONFIRM LOGOUT button",  null);
			TestUtil.waitTime(3);
		
		
		// COMBINATION LETTERS USERNAME
		loginPage.inputUsername(driver, username_combination);
		Thread.sleep(5000);
		loginPage.inputPassword(driver, password);
		Thread.sleep(5000);
		loginPage.clickLoginBtn(driver);
		Thread.sleep(10000);
		
		// Validations 2 - small letters
		if (dashboard.VerifySuccessfulLogin(driver) == true) {
			logGeneration.inputLogs(LogType.pass, String.format("Login Successful! {%s}", username_combination),  null);
		} else {
			logGeneration.inputLogs(LogType.pass, "Login Failed!",  TestUtil.getScreenshot(driver));
		}
		
		dashboard.clickLogoutBtnDashboard(driver);
			logGeneration.inputLogs(LogType.info, "Click on LOGOUT button",  null);
			TestUtil.waitTime(1);
		dashboard.confirmLogout(driver);
			logGeneration.inputLogs(LogType.info, "Click on CONFIRM LOGOUT button",  null);
//			TestUtil.waitTime(3);
		
		logGeneration.extentFlush();
		driver.quit();

	}
}
