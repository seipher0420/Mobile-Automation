package main.java.com.metrobank.mobile.MBM.TestCase.Dashboard;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import java.io.IOException;

import main.java.com.metrobank.mobile.MBM.DashBoard.DashBoard;
import main.java.com.metrobank.mobile.MBM.LoginPage.LoginPage;
import main.java.com.metrobank.mobile.core.base.Enums.LogType;
import main.java.com.metrobank.mobile.core.base.MobileConnection;
import main.java.com.metrobank.mobile.core.locator.Locators;
import main.java.com.metrobank.mobile.core.logger.LogGeneration;
import main.java.com.metrobank.mobile.core.utilities.PropertyFileHandler;
import main.java.com.metrobank.mobile.core.utilities.TestUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dashboard_0134 extends MobileConnection {

	PropertyFileHandler property = new PropertyFileHandler(Locators.TESTDATA);
	@Test
	public void ViewingShortcutWidget() throws IOException, InterruptedException{
	
		LogGeneration logGeneration = new LogGeneration();
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		
		logGeneration.generateReport("034 Viewing of Shortcut Widget");
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

		for (int i=0; i<3;i++) {
		    TestUtil.swipeDown(driver, -1);
		}
		
		try {
			Assert.assertTrue(dashboard.shortCutWidgetDataIsDisplayed(driver,
					"SendMoney"));
			logGeneration.inputLogs(LogType.pass,
					"Shortcut Widget SendMoney is displayed",  TestUtil.getScreenshot(driver));
		} catch (AssertionError e) {
			logGeneration.inputLogs(LogType.fail,
					"Shortcut Widget SendMoney is not displayed",  TestUtil.getScreenshot(driver));
		}

		try {
			Assert.assertTrue(dashboard.shortCutWidgetDataIsDisplayed(driver,
					"MoveMoney"));
			logGeneration.inputLogs(LogType.pass,
					"Shortcut Widget MoveMoney is displayed",  TestUtil.getScreenshot(driver));
		} catch (AssertionError e) {
			logGeneration.inputLogs(LogType.fail,
					"Shortcut Widget MoveMoney is not displayed",  TestUtil.getScreenshot(driver));

		}
		try {
			Assert.assertTrue(dashboard.shortCutWidgetDataIsDisplayed(driver,
					"LoadPrepaid"));
			logGeneration.inputLogs(LogType.pass,
					"Shortcut Widget LoadPrepaid is displayed",  TestUtil.getScreenshot(driver));
		} catch (AssertionError e) {
			logGeneration.inputLogs(LogType.fail,
					"Shortcut Widget LoadPrepaid is not displayed",  TestUtil.getScreenshot(driver));

		}

		try {
			Assert.assertTrue(dashboard.shortCutWidgetDataIsDisplayed(driver,
					"CardlessWithdrawal"));
			logGeneration.inputLogs(LogType.pass,
					"Shortcut Widget CardlessWithdrawal is displayed",  TestUtil.getScreenshot(driver));
		} catch (AssertionError e) {
			logGeneration
					.inputLogs(
							LogType.fail,
							"Shortcut Widget CardlessWithdrawal is not displayed",
							 TestUtil.getScreenshot(driver));

		}

		try {
			Assert.assertTrue(dashboard.shortCutWidgetDataIsDisplayed(driver,
					"OpenTimeDeposit"));
			logGeneration.inputLogs(LogType.pass,
					"Shortcut Widget OpenTimeDeposit is displayed",  TestUtil.getScreenshot(driver));
		} catch (AssertionError e) {
			logGeneration.inputLogs(LogType.fail,
					"Shortcut Widget OpenTimeDeposit is not displayed",  TestUtil.getScreenshot(driver));

		}

		try {
			Assert.assertTrue(dashboard.shortCutWidgetDataIsDisplayed(driver,
					"PayBills"));
			logGeneration.inputLogs(LogType.pass,
					"Shortcut Widget PayBills is displayed",  TestUtil.getScreenshot(driver));
		} catch (AssertionError e) {
			logGeneration.inputLogs(LogType.fail,
					"Shortcut Widget PayBills is not displayed",  TestUtil.getScreenshot(driver));

		}

		try {
			Assert.assertTrue(dashboard.shortCutWidgetDataIsDisplayed(driver,
					"SendMoney"));
			logGeneration.inputLogs(LogType.pass,
					"Shortcut Widget SendMoney is displayed",  TestUtil.getScreenshot(driver));
		} catch (AssertionError e) {
			logGeneration.inputLogs(LogType.fail,
					"Shortcut Widget SendMoney is not displayed",  TestUtil.getScreenshot(driver));

		}
		
		logGeneration.extentFlush();
		driver.quit();
		
	}
	
}
