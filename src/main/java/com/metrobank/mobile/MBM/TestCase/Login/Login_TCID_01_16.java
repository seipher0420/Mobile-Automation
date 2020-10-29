package main.java.com.metrobank.mobile.MBM.TestCase.Login;

import java.io.IOException;

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
 * Login Test Case 01.16
 * Login using valid username and password_Both ST and IM account
 * @author testuser
 *
 */

public class Login_TCID_01_16 extends MobileConnection{
	
	private PropertyFileHandler property;
	private String username, password;
	
	@Test
	public void connectionMobile() throws InterruptedException, IOException{
		
		property = new PropertyFileHandler(TestData.LOGIN);
		username = property.GetValue("username_16");
		password = property.GetValue("password_16");
		
		// Setup Logger
		LogGeneration logGeneration = new LogGeneration();
		logGeneration.generateReport("Login TCID 01.16");
		
		// Setup Pages
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		
		// Setup mobile connection
		AppiumDriver<MobileElement> driver = mobileOS("Android");	
		Thread.sleep(5000);
		
		//Script starts here
		if (CommonMethods.Login(driver, username, password) == true) {	
			String accountNumber = dashboard.getPrimaryAccountNumber(driver);
			if (accountNumber.charAt(4) == '3') {
				logGeneration.inputLogs(LogType.pass, "Savings Account Found : " + accountNumber,  null);
			} else {
				logGeneration.inputLogs(LogType.fail, "No Savings Account Found : " + accountNumber,  TestUtil.getScreenshot(driver));
			}
			
			TestUtil.swipeDown(driver, 0.1);
			String accountNumber_checking = dashboard.getCheckingAccountNumber(driver);
			if (accountNumber_checking.charAt(4) == '7') {
				logGeneration.inputLogs(LogType.pass, "Checking Account Found : " + accountNumber_checking,  null);
			} else {
				logGeneration.inputLogs(LogType.fail, "No Checking Account Found : " + accountNumber_checking,  TestUtil.getScreenshot(driver));
			}
		} 
		
		logGeneration.extentFlush();
		driver.quit();

	}
}
