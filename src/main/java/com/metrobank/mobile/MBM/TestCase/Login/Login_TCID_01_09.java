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
 * Login Test Case 01.09
 * Security alert displays when mobile device is under developer mode - SKIP
 * @author testuser
 *
 */

public class Login_TCID_01_09 extends MobileConnection{
	
	private PropertyFileHandler property;
	private String username, password;
	
	@Test
	public void connectionMobile() throws InterruptedException, IOException{
		
		property = new PropertyFileHandler(TestData.LOGIN);
		username = property.GetValue("username_05");
		password = property.GetValue("password_05");
		
		// Setup Logger
		LogGeneration logGeneration = new LogGeneration();
		logGeneration.generateReport("Login TCID 01.09");
		
		// Setup Pages
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		
		// Setup mobile connection
		AppiumDriver<MobileElement> driver = mobileOS("Android");	
		Thread.sleep(5000);
		
		//Script starts here
//		loginPage.inputUsername(driver, username);
//		Thread.sleep(5000);
//		loginPage.inputPassword(driver, password);
//		Thread.sleep(5000);
//		loginPage.clickLoginBtn(driver);
//		Thread.sleep(10000);
//		
//		// Validations
//		String err_message = loginPage.getErrorMessage(driver);
//		logGeneration.inputLogs(LogType.pass, "Login Unsuccessful",  null);
//		logGeneration.inputLogs(LogType.pass, "Error Message : " + err_message,  TestUtil.getScreenshot(driver));
		
		logGeneration.extentFlush();
		driver.quit();

	}
}
