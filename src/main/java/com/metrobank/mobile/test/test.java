 package main.java.com.metrobank.mobile.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import main.java.com.metrobank.mobile.core.base.MobileConnection;
import main.java.com.metrobank.mobile.core.base.Enums.LogType;
import main.java.com.metrobank.mobile.core.logger.LogGeneration;
import main.java.com.metrobank.mobile.core.utilities.TestUtil;


public class test extends MobileConnection {
	
	@Test
	public void connectionMobile() throws InterruptedException, IOException{
		

		char quote='"';
		LogGeneration logGeneration = new LogGeneration();
		logGeneration.generateReport("Test");
		
		logGeneration.inputLogs(LogType.info, "Starting Appium Driver", null);
		String loginXpath = "//*[@text="+quote+ "Enter username" + quote + "]";
		
		AppiumDriver<MobileElement> driver = mobileOS("Android");	
		Thread.sleep(5000);
		driver.findElement(By.xpath(loginXpath)).sendKeys("sqdmbx_pt012");
		
		Thread.sleep(5000);
	    driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ScrollView[1]/android.view.View[1]/android.view.View[2]/android.widget.EditText[1]")).sendKeys("P@ssw0rd");
		Set<String> contextNames = driver.getContextHandles();
		System.out.println(contextNames);
	
		for(String value : contextNames){
			System.out.println("Context: " + value);
		}
		logGeneration.inputLogs(LogType.pass, "TEST LOGIN ", TestUtil.getScreenshot(driver));
		Thread.sleep(5000);
	//	driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ScrollView[1]/android.view.View[1]/android.view.View[3]")).click();
		driver.findElement(By.xpath("//android.view.View[@index='5']")).click();
		Thread.sleep(20000);
		
		Set<String> contextNames1 = driver.getContextHandles();
		System.out.println(contextNames1);
	
		for(String value : contextNames1){
			System.out.println("Context: " + value);
		}
		
		logGeneration.inputLogs(LogType.pass, "HomePage",  TestUtil.getScreenshot(driver));
		String balance = driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.ScrollView[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.TextView[6]")).getText();
		logGeneration.inputLogs(LogType.pass, "Account Balance = " + balance,  TestUtil.getScreenshot(driver));
		Thread.sleep(5000);
		logGeneration.extentFlush();
	}
	
}
