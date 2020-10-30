package main.java.com.metrobank.mobile.MBM.TestCase.Dashboard;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.java.com.metrobank.mobile.MBM.DashBoard.DashBoard;
import main.java.com.metrobank.mobile.MBM.LoginPage.LoginPage;
import main.java.com.metrobank.mobile.core.base.MobileConnection;
import main.java.com.metrobank.mobile.core.base.Enums.LogType;
import main.java.com.metrobank.mobile.core.locator.Locators;
import main.java.com.metrobank.mobile.core.logger.LogGeneration;
import main.java.com.metrobank.mobile.core.utilities.PropertyFileHandler;
import main.java.com.metrobank.mobile.core.utilities.TestUtil;

public class Dashboard_0117 extends MobileConnection{
	
	PropertyFileHandler property = new PropertyFileHandler(Locators.TESTDATA);
	@Test
	public void ValidationLogOutButtonDashboard_0117() throws IOException, InterruptedException{
		
		LogGeneration logGeneration = new LogGeneration();
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		
		logGeneration.generateReport("0117 Validation Logout Button Dashboard");
		AppiumDriver<MobileElement> driver = mobileOS("Android");	
		TestUtil.waitTime(5);
		loginPage.inputUsername(driver, property.GetValue("username"));
		logGeneration.inputLogs(LogType.info, "Input Username", null);
		TestUtil.waitTime(5);
		loginPage.inputPassword(driver, property.GetValue("password"));
		logGeneration.inputLogs(LogType.info, "Input Password", null);
		TestUtil.waitTime(5);
		loginPage.clickLoginBtn(driver);
		logGeneration.inputLogs(LogType.info, "Click Login Button", null);
		Thread.sleep(15000);
		if(dashboard.getSessionBrowserIsDisplayed(driver) != null){
			logGeneration.inputLogs(LogType.warning, "Message A session on another browser or device has ended is displayed", TestUtil.getScreenshot(driver));
			dashboard.clickOkBtnSession(driver);
			TestUtil.waitTime(5);
		}
		logGeneration.inputLogs(LogType.info, "Dashboard is displayed", null);
		
		
		if(dashboard.dashBoardLogOutMenuIsDisplayed(driver)){
			logGeneration.inputLogs(LogType.pass, "DashBoard LogOut button is displayed",  TestUtil.getScreenshot(driver));
			dashboard.clickDashBoardLogout(driver);
			TestUtil.waitTime(3);
			logGeneration.inputLogs(LogType.info, "Click dashboard Logout Button", null);
			dashboard.clickLogoutbtnMenu(driver);
		
			try{
				TestUtil.waitTime(2);
				Assert.assertTrue(dashboard.logOutMessageIsDisplayed(driver));
				logGeneration.inputLogs(LogType.pass, "LogOut Message is displayed",  TestUtil.getScreenshot(driver));
			}catch(AssertionError e){
				logGeneration.inputLogs(LogType.fail, "Log Out Message is not displayed", TestUtil.getScreenshot(driver));
			}
		}else{
			logGeneration.inputLogs(LogType.fail, "DashBoard Logout button is not displayed", TestUtil.getScreenshot(driver));
		}
		
	
		logGeneration.extentFlush();
		driver.quit();
		
		
	}
	
}
