package main.java.com.metrobank.mobile.MBM.TestCase.Login;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import main.java.com.metrobank.mobile.MBM.DashBoard.DashBoard;
import main.java.com.metrobank.mobile.MBM.LoginPage.LoginPage;
import main.java.com.metrobank.mobile.MBM.TestCase.Common.CommonMethods;
import main.java.com.metrobank.mobile.core.base.MobileConnection;
import main.java.com.metrobank.mobile.core.base.Enums.LogType;
import main.java.com.metrobank.mobile.core.logger.LogGeneration;
import main.java.com.metrobank.mobile.core.utilities.PropertyFileHandler;
import main.java.com.metrobank.mobile.core.utilities.TestUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @Description
 * Login Test Case 01.05
 * End Session
 * @author testuser
 *
 */

public class Logout_TCID_01_05 extends MobileConnection{
	
	private PropertyFileHandler property, property2;
	private String username, password;
	
	@Test
	public void connectionMobile() throws InterruptedException, IOException{
		
		property = new PropertyFileHandler(TestData.LOGIN);
		property2 = new PropertyFileHandler(TestData.LOGOUT);
		username = property.GetValue("username");
		password = property.GetValue("password");
		String verifyLoginPage_xpath = property2.GetValue("verifyLoginPage_xpath");
		
		// Setup Logger
		LogGeneration logGeneration = new LogGeneration();
		logGeneration.generateReport("Logout TCID 01.05");
		
		// Setup Pages
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		
		// Setup mobile connection
		AppiumDriver<MobileElement> driver = mobileOS("Android");	
		Thread.sleep(5000);
		
		//Script starts here
		CommonMethods.Login(driver, username, password);

		
		driver.closeApp();
		Thread.sleep(2000);
		driver.launchApp();
		Thread.sleep(5000);
		
		// Validate Back to Login Page
		if (driver.findElement(By.xpath(verifyLoginPage_xpath)) != null) {
			logGeneration.inputLogs(LogType.pass, "Login Page FOUND",   TestUtil.getScreenshot(driver));
		}
		
		logGeneration.extentFlush();
		driver.quit();
	}
}
