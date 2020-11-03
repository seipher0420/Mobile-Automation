package main.java.com.metrobank.mobile.core.base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public abstract class MobileConnection {
	
	static AppiumDriver<MobileElement> mob_driver;

	public static AppiumDriver<MobileElement> mobileOS(String mobileOS) throws IOException{
	
		FileReader reader=new FileReader(System.getProperty(AutomationConstants.USER_DIRECTORY) + AutomationConstants.PROPERTY_FILE);  
	    Properties properties=new Properties();  
	    properties.load(reader);  
		
	    String os = properties.getProperty("mobileOS");
	    String deviceName = properties.getProperty("deviceName");
	    String deviceId = properties.getProperty("deviceId");
	    String platformName = properties.getProperty("platformName");
	    String platformVersion = properties.getProperty("platformVersion");
	    String appPackage = properties.getProperty("appPackage");
	    String appActivity = properties.getProperty("appActivity");
	    String automationName = properties.getProperty("automationName");
	    String noReset = properties.getProperty("noReset");
	    String noSign = properties.getProperty("noSign");
	    String appiumURL = properties.getProperty("appuimURL");

		if(mobileOS.equals(os)){
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability("udid", deviceId); 
			capabilities.setCapability("platformName", platformName);
			capabilities.setCapability("platformVersion", platformVersion);
			capabilities.setCapability("appPackage", appPackage);
			capabilities.setCapability("appActivity", appActivity);
			capabilities.setCapability("automationName", automationName);
			capabilities.setCapability("noReset", noReset);
			capabilities.setCapability("noSign", noSign);
			
			try {
				mob_driver = new AndroidDriver<MobileElement>(new URL(appiumURL), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
				  
		}else if(mobileOS.equals(os)){
			//to be implemented if there is ios device
		}else{
			//log os not found
		}
		
	return mob_driver;
	}
	
	

}
