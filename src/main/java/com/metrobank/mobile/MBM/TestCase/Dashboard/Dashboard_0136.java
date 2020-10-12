package main.java.com.metrobank.mobile.MBM.TestCase.Dashboard;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;

import main.java.com.metrobank.mobile.MBM.DashBoard.DashBoard;
import main.java.com.metrobank.mobile.MBM.LoginPage.LoginPage;
import main.java.com.metrobank.mobile.core.base.MobileConnection;
import main.java.com.metrobank.mobile.core.base.Enums.LogType;
import main.java.com.metrobank.mobile.core.locator.Locators;
import main.java.com.metrobank.mobile.core.logger.LogGeneration;
import main.java.com.metrobank.mobile.core.utilities.PropertyFileHandler;
import main.java.com.metrobank.mobile.core.utilities.TestUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dashboard_0136 extends MobileConnection {

	PropertyFileHandler property = new PropertyFileHandler(Locators.TESTDATA);
	@Test
	public void UpdatingShortCutWidget() throws IOException, InterruptedException{
	
		LogGeneration logGeneration = new LogGeneration();
		LoginPage loginPage = new LoginPage();
		DashBoard dashboard = new DashBoard();
		
		logGeneration.generateReport("0136 Updating of Shortcut Widget Empty");
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
		
		logGeneration.inputLogs(LogType.info, "Dashboard is displayed", null);

		for (int i=0; i<3;i++) {
		    TestUtil.swipeDown(driver, -1);
		}
		
		dashboard.clickDisplayOptionsMenu(driver);
		
		TestUtil.waitTime(3);
		dashboard.clickShortCutWidgetData(driver, "SendMoney");
		logGeneration.inputLogs(LogType.info, "Click Sendmoney to remove from shortcut widget", null);
		dashboard.clickShortCutWidgetData(driver, "MoveMoney");
		logGeneration.inputLogs(LogType.info, "Click MoveMoney to remove from shortcut widget", null);
		dashboard.clickShortCutWidgetData(driver, "LoadPrepaid");
		logGeneration.inputLogs(LogType.info, "Click LoadPrepaid to remove from shortcut widget", null);
		dashboard.clickShortCutWidgetData(driver, "CardlessWithdrawal");
		logGeneration.inputLogs(LogType.info, "Click CardlessWithdrawal to remove from shortcut widget", null);
		dashboard.clickShortCutWidgetData(driver, "OpenTimeDeposit");
		logGeneration.inputLogs(LogType.info, "Click OpenTimeDeposit to remove from shortcut widget", null);
		dashboard.clickShortCutWidgetData(driver, "PayBills");
		logGeneration.inputLogs(LogType.info, "Click PayBills to remove from shortcut widget", null);
		TestUtil.waitTime(3);
		dashboard.clickShortCutWidgetData(driver, "Move");
		TestUtil.waitTime(3);
		dashboard.clickDonebtn(driver);
		TestUtil.waitTime(3);
		logGeneration.inputLogs(LogType.info, "Shortcut widget is now empty", null);
		
		dashboard.clickDisplayOptionsMenu(driver);
		
		TestUtil.waitTime(3);
		dashboard.clickShortCutWidgetData(driver, "SendMoney");
		logGeneration.inputLogs(LogType.info, "Click Sendmoney to add from shortcut widget", null);
		dashboard.clickShortCutWidgetData(driver, "MoveMoney");
		logGeneration.inputLogs(LogType.info, "Click MoveMoney to add from shortcut widget", null);
		dashboard.clickShortCutWidgetData(driver, "LoadPrepaid");
		logGeneration.inputLogs(LogType.info, "Click LoadPrepaid to add from shortcut widget", null);
		dashboard.clickShortCutWidgetData(driver, "CardlessWithdrawal");
		logGeneration.inputLogs(LogType.info, "Click CardlessWithdrawal to add from shortcut widget", null);
		dashboard.clickShortCutWidgetData(driver, "OpenTimeDeposit");
		logGeneration.inputLogs(LogType.info, "Click OpenTimeDeposit to add from shortcut widget", null);
		dashboard.clickShortCutWidgetData(driver, "PayBills");
		logGeneration.inputLogs(LogType.info, "Click PayBills to add from shortcut widget", null);
		TestUtil.waitTime(3);
		dashboard.clickShortCutWidgetData(driver, "Move");
		TestUtil.waitTime(3);
		dashboard.clickDonebtn(driver);
		
		
		
		
		try {
			TestUtil.waitTime(3);
			Assert.assertTrue(dashboard.shortCutWidgetDataIsDisplayed(driver,
					"SendMoney"));
			logGeneration.inputLogs(LogType.pass,
					"Shortcut Widget SendMoney is displayed", null);
		} catch (AssertionError e) {
			logGeneration.inputLogs(LogType.fail,
					"Shortcut Widget SendMoney is not displayed", TestUtil.getScreenshot(driver));
		}

		try {
			Assert.assertTrue(dashboard.shortCutWidgetDataIsDisplayed(driver,
					"MoveMoney"));
			logGeneration.inputLogs(LogType.pass,
					"Shortcut Widget MoveMoney is displayed", null);
		} catch (AssertionError e) {
			logGeneration.inputLogs(LogType.fail,
					"Shortcut Widget MoveMoney is not displayed", TestUtil.getScreenshot(driver));

		}
		try {
			Assert.assertTrue(dashboard.shortCutWidgetDataIsDisplayed(driver,
					"LoadPrepaid"));
			logGeneration.inputLogs(LogType.pass,
					"Shortcut Widget LoadPrepaid is displayed", null);
		} catch (AssertionError e) {
			logGeneration.inputLogs(LogType.fail,
					"Shortcut Widget LoadPrepaid is not displayed", TestUtil.getScreenshot(driver));

		}

		try {
			Assert.assertTrue(dashboard.shortCutWidgetDataIsDisplayed(driver,
					"CardlessWithdrawal"));
			logGeneration.inputLogs(LogType.pass,
					"Shortcut Widget CardlessWithdrawal is displayed", null);
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
					"Shortcut Widget OpenTimeDeposit is displayed", null);
		} catch (AssertionError e) {
			logGeneration.inputLogs(LogType.fail,
					"Shortcut Widget OpenTimeDeposit is not displayed", TestUtil.getScreenshot(driver));

		}

		try {
			Assert.assertTrue(dashboard.shortCutWidgetDataIsDisplayed(driver,
					"PayBills"));
			logGeneration.inputLogs(LogType.pass,
					"Shortcut Widget PayBills is displayed", null);
		} catch (AssertionError e) {
			logGeneration.inputLogs(LogType.fail,
					"Shortcut Widget PayBills is not displayed", TestUtil.getScreenshot(driver));

		}

		try {
			Assert.assertTrue(dashboard.shortCutWidgetDataIsDisplayed(driver,
					"SendMoney"));
			logGeneration.inputLogs(LogType.pass,
					"Shortcut Widget SendMoney is displayed", null);
		} catch (AssertionError e) {
			logGeneration.inputLogs(LogType.fail,
					"Shortcut Widget SendMoney is not displayed", TestUtil.getScreenshot(driver));

		}
		

		
		logGeneration.extentFlush();
		driver.quit();
		
	}
	

}
