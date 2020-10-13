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
 * Login Test Case 01.03
 * Session Timeout_Logout Consuming Seconds
 * @author testuser
 *
 */

public class Logout_TCID_01_03 extends MobileConnection{
	
	private PropertyFileHandler property, property2;
	private String username, password;
	
	@Test
	public void connectionMobile() throws InterruptedException, IOException{
		
		property = new PropertyFileHandler(TestData.LOGIN);
		property2 = new PropertyFileHandler(TestData.LOGOUT);
		username = property.GetValue("username");
		password = property.GetValue("password");
		String verifyEndSession_xpath = property2.GetValue("verifyEndSession_xpath");
		String verifyLoginPage_xpath = property2.GetValue("verifyLoginPage_xpath");
		String verifyLoggedOutInactivity = property2.GetValue("verifyLoggedOutInactivity");
		
		// Setup Logger
		LogGeneration logGeneration = new LogGeneration();
		logGeneration.generateReport("Logout TCID 01.03");
		
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
		
		int timer = 180;
		while (timer > 0) {
			try {
				if (driver.findElement(By.xpath(verifyEndSession_xpath)) != null) {
					logGeneration.inputLogs(LogType.pass, 
							"\"Your session will end in <##> seconds.\" FOUND",  null);
					break;
				} 
			} catch (Exception e) {
				timer--;
				Thread.sleep(1000);
			}
		}
		
		Thread.sleep(1000);
		int timer2 = 60;
		while (timer2 > 0) {
			try {
				if (driver.findElement(By.xpath(verifyLoggedOutInactivity)) != null) {
					logGeneration.inputLogs(LogType.pass, 
							"\"For your security, you have been logged out due to inactivity.\" FOUND",  null);
					break;
				} 
			} catch (Exception e) {
				timer2--;
				Thread.sleep(1000);
			}
		}
		
		Thread.sleep(1000);
		dashboard.clickOKbtn(driver);
		Thread.sleep(500);
		
		// Validate Back to Login Page
		if (driver.findElement(By.xpath(verifyLoginPage_xpath)) != null) {
			logGeneration.inputLogs(LogType.pass, "Login Page FOUND",  null);
		}
		
		logGeneration.extentFlush();
		driver.quit();
		
	}
}
