package main.java.com.metrobank.mobile.test;

import java.io.IOException;

import org.testng.annotations.Test;

import main.java.com.metrobank.mobile.MBM.LoginPage.LoginPage;
import main.java.com.metrobank.mobile.core.base.MobileConnection;
import main.java.com.metrobank.mobile.core.logger.LogGeneration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginTest extends MobileConnection{
	
	@Test
	public void connectionMobile() throws InterruptedException, IOException{
		
		LogGeneration logGeneration = new LogGeneration();
		LoginPage loginPage = new LoginPage();
		
		logGeneration.generateReport("Test");
		AppiumDriver<MobileElement> driver = mobileOS("Android");	
		Thread.sleep(5000);
		loginPage.inputUsername(driver, "sqdmbx_pt012");
		Thread.sleep(5000);
		loginPage.inputPassword(driver, "P@ssw0rd");
		Thread.sleep(5000);
		loginPage.clickLoginBtn(driver);
		
		Thread.sleep(10000);
		logGeneration.extentFlush();
		driver.quit();

	}
}
