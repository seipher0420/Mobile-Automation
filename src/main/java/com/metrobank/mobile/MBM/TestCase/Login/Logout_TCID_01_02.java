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
 * Login Test Case 01.02
 * Session Timeout_Logout Manually
 * @author testuser
 *
 */

public class Logout_TCID_01_02 extends MobileConnection{
	
	private PropertyFileHandler property, property2;
	private String username, password;
	
	@Test
	public void connectionMobile() throws InterruptedException, IOException{
		
		property = new PropertyFileHandler(TestData.LOGIN);
		property2 = new PropertyFileHandler(TestData.LOGOUT);
		username = property.GetValue("username");
		password = property.GetValue("password");
		String verifyEndSession_xpath = property2.GetValue("verifyEndSession_xpath");
		String verifySuccessfulLogout = property2.GetValue("verifySuccessfulLogout_xpath");
		
		// Setup Logger
		LogGeneration logGeneration = new LogGeneration();
		logGeneration.generateReport("Logout TCID 01.02");
		
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
		if(dashboard.getSessionBrowserIsDisplayed(driver) != null){
			logGeneration.inputLogs(LogType.warning, "Message A session on another browser or device has ended is displayed", TestUtil.getScreenshot(driver));
			dashboard.clickOkBtnSession(driver);
			TestUtil.waitTime(5);
		}
		
		// Validations
		if (dashboard.VerifySuccessfulLogin(driver) == true) {
			logGeneration.inputLogs(LogType.pass, "Login Successful!",  null);
		} else {
			logGeneration.inputLogs(LogType.pass, "Login Failed!",  TestUtil.getScreenshot(driver));
		}
		
//		dashboard.clickLogoutBtnDashboard(driver);
//		Thread.sleep(180000);
		int timer = 180;
		while (timer > 0) {
			try {
				if (driver.findElement(By.xpath(verifyEndSession_xpath)) != null) {
					logGeneration.inputLogs(LogType.pass, "\"Your session will end in <##> seconds.\" FOUND",   TestUtil.getScreenshot(driver));
					
					break;
				} 
			} catch (Exception e) {
				timer--;
				Thread.sleep(1000);
			}
		}
		
		Thread.sleep(1000);
		dashboard.endSessionLogOut(driver);
		Thread.sleep(500);
		
		// Validate Successful Logout Notification
		if (driver.findElement(By.xpath(verifySuccessfulLogout)) != null) {
			logGeneration.inputLogs(LogType.pass, "\"You have successfully logged out.\" FOUND",   TestUtil.getScreenshot(driver));
		}
		
		logGeneration.extentFlush();
		driver.quit();
		
	}
}
