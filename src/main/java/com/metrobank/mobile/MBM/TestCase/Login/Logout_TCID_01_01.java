package main.java.com.metrobank.mobile.MBM.TestCase.Login;

import java.io.IOException;

import org.openqa.selenium.By;
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
 * Login Test Case 01.01
 * Logout
 * @author testuser
 *
 */

public class Logout_TCID_01_01 extends MobileConnection{
	
	private PropertyFileHandler property, property2;
	private String username, password;
	
	@Test
	public void connectionMobile() throws InterruptedException, IOException{
		
		property = new PropertyFileHandler(TestData.LOGIN);
		property2 = new PropertyFileHandler(TestData.LOGOUT);
		username = property.GetValue("username");
		password = property.GetValue("password");
		String verifyConfirmLogout = property2.GetValue("verifyConfirmLogout_xpath");
		String verifySuccessfulLogout = property2.GetValue("verifySuccessfulLogout_xpath");
		
		// Setup Logger
		LogGeneration logGeneration = new LogGeneration();
		logGeneration.generateReport("Logout TCID 01.01");
		
		// Setup Pages
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		
		// Setup mobile connection
		AppiumDriver<MobileElement> driver = mobileOS("Android");	
		Thread.sleep(5000);
		
		//Script starts here
		loginPage.inputUsername(driver, username);
		Thread.sleep(5000);
		loginPage.inputPassword(driver, password);
		Thread.sleep(5000);
		loginPage.clickLoginBtn(driver);
		Thread.sleep(10000);
		
		// Validations
		if (dashboard.VerifySuccessfulLogin(driver) == true) {
			logGeneration.inputLogs(LogType.pass, "Login Successful!",  null);
		} else {
			logGeneration.inputLogs(LogType.pass, "Login Failed!",  TestUtil.getScreenshot(driver));
		}
		
		dashboard.clickLogoutBtnDashboard(driver);
		Thread.sleep(1000);
		
		// Validate Confirm Logout Notification
		if (driver.findElement(By.xpath(verifyConfirmLogout)) != null) {
			logGeneration.inputLogs(LogType.pass, "\"Are you sure you want to logout?\" FOUND",  null);
		}
		dashboard.confirmLogout(driver);
		Thread.sleep(500);
		
		// Validate Successful Logout Notification
		if (driver.findElement(By.xpath(verifySuccessfulLogout)) != null) {
			logGeneration.inputLogs(LogType.pass, "\"You have successfully logged out.\" FOUND",  null);
		}
		
		logGeneration.extentFlush();
		driver.quit();
		
	}
}
