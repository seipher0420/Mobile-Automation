package main.java.com.metrobank.mobile.test;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import main.java.com.metrobank.mobile.core.base.MobileConnection;


public class ContextTest extends MobileConnection{

	@Test
	public void connectionMobile() throws InterruptedException, IOException{
		
		AppiumDriver<MobileElement> driver = mobileOS("Android");	
		Thread.sleep(5000);
		Set<String> contextNames = driver.getContextHandles();
		
		for (String contextName : contextNames) {
		    System.out.println(contextName);
		}
		driver.context((String) contextNames.toArray()[1]);
	}
}
