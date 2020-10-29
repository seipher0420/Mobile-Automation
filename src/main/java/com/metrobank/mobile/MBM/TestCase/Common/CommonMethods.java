package main.java.com.metrobank.mobile.MBM.TestCase.Common;

import java.io.IOException;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import main.java.com.metrobank.mobile.MBM.DashBoard.DashBoard;
import main.java.com.metrobank.mobile.MBM.LoginPage.LoginPage;
import main.java.com.metrobank.mobile.MBM.TestCase.Common.TestData;
import main.java.com.metrobank.mobile.core.base.Enums.LogType;
import main.java.com.metrobank.mobile.core.base.MobileConnection;
import main.java.com.metrobank.mobile.core.logger.LogGeneration;
import main.java.com.metrobank.mobile.core.utilities.PropertyFileHandler;
import main.java.com.metrobank.mobile.core.utilities.TestUtil;

public class CommonMethods extends MobileConnection {

	public static boolean Login(AppiumDriver<MobileElement> driver, String username, String password) throws IOException, InterruptedException {
		
		// Setup Logger
		LogGeneration logGeneration = new LogGeneration();
		
		// Setup Pages
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		
		//Script starts here
		loginPage.inputUsername(driver, username);
			logGeneration.inputLogs(LogType.info, String.format("Input username : {%s}", username),  null);
			TestUtil.waitTime(5);
		loginPage.inputPassword(driver, password);
			logGeneration.inputLogs(LogType.info, String.format("Input password : {%s}", password),  null);
			TestUtil.waitTime(5);
		loginPage.clickLoginBtn(driver);
			logGeneration.inputLogs(LogType.info, "Click on LOGIN button",  null);
			TestUtil.waitTime(15);
		
		
		// Check if 'Session on another browser has ended' error is encountered
		if (dashboard.isErrorSessionOnAnotherBrowserDisplayed(driver) == true) {
			logGeneration.inputLogs(LogType.warning, 
					"A session on another browser or device has ended",  TestUtil.getScreenshot(driver));
			dashboard.clickOkaybutton(driver);
			TestUtil.waitTime(2);
		} else {
			// do nothing
		}
		
		// Validations
		if (dashboard.VerifySuccessfulLogin(driver) == true) {
			logGeneration.inputLogs(LogType.pass, "Login Successful.",  null);
			return true;
		} else {
			logGeneration.inputLogs(LogType.pass, "Login Failed.",  TestUtil.getScreenshot(driver));
			String err_message = loginPage.getErrorMessage(driver);
			logGeneration.inputLogs(LogType.pass, 
					String.format("Error Message found : {%s}", err_message),  
					TestUtil.getScreenshot(driver));
			return false;
		}
	}
	
	public static void Logout(AppiumDriver<MobileElement> driver) throws InterruptedException {
		
		PropertyFileHandler property = new PropertyFileHandler(TestData.LOGIN);
		String verifySuccessfulLogout = property.GetValue("verifySuccessfulLogout_xpath");
		
		// Setup Logger
		LogGeneration logGeneration = new LogGeneration();
		
		// Setup Pages
		DashBoard dashboard = new DashBoard();
		
		// Validate Confirm Logout Notification
		dashboard.clickLogoutBtnDashboard(driver);
		Thread.sleep(1000);
		dashboard.confirmLogout(driver);
		Thread.sleep(500);
		
		// Validate Successful Logout Notification
		if (driver.findElement(By.xpath(verifySuccessfulLogout)) != null) {
			logGeneration.inputLogs(LogType.pass, "You have successfully logged out.",  null);
		}
	}
	
}
