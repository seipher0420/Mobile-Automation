package main.java.com.metrobank.mobile.core.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import main.java.com.metrobank.mobile.core.base.AutomationConstants;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/*
 * @Description
 * For generic Utilities of TestCases
 * 
 */

public class TestUtil {
	
	/*
	 * @Description GetScreenshot for validations
	 */

	public static String getScreenshot(AppiumDriver<MobileElement> driver) {
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		String screenshotBase64;
		File source = takeScreenshot.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "/Screenshot/"
				+ System.currentTimeMillis() + ".png";
		screenshotBase64 = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.BASE64);
		File destination = new File(path);

		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());

		}

		return screenshotBase64;
	}

	public static boolean isEmptyOrWhitespace(String value) {
		value = makeSafe(value);
		for (int i = 0, n = value.length(); i < n; i++) {
			if (!Character.isWhitespace(value.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static String makeSafe(String value) {
		return (value == null) ? "" : value;
	}

	public String getWindowsHandle(WebDriver driver) {

		return driver.getWindowHandle();

	}


	// Wait time 1-5 seconds
	public static void waitTime(int seconds) throws InterruptedException {
		switch (seconds) {
		case 1:
			Thread.sleep(1000);
			break;

		case 2:
			Thread.sleep(2000);
			break;

		case 3:
			Thread.sleep(3000);
			break;

		case 4:
			Thread.sleep(4000);
			break;

		case 5:
			Thread.sleep(5000);
			break;
			
		case 6:
			Thread.sleep(6000);
			break;
			
		case 7:
			Thread.sleep(7000);
			break;
			
		case 8:
			Thread.sleep(8000);
			break;
			
		case 9:
			Thread.sleep(9000);
			break;
			
		case 10:
			Thread.sleep(10000);
			break;
			
		default:
			Thread.sleep(1000);
			System.out.println(AutomationConstants.FRAMEWORK_LOGS
					+ "Default set to 1 second");
		}
	}

	public static String createNewFolderBaseDate() {
		Format format = new SimpleDateFormat("MMddyy");
		String strDate = format.format(new Date());
		String userDirectory = System
				.getProperty(AutomationConstants.USER_DIRECTORY);
		String path = userDirectory + AutomationConstants.TEST_REPORT_FOLDER
				+ "/" + strDate + "/";

		File file = new File(path);
		boolean createDir = file.mkdir();
		if (createDir) {
			System.out.println(AutomationConstants.FRAMEWORK_LOGS
					+ "Folder has been Created " + path);
		} else {
			System.out.println(AutomationConstants.FRAMEWORK_LOGS
					+ "Folder has already been created or not found " + path);
		}
		return path;
	}

	public static String createResultFolder(String result) {
		Format format = new SimpleDateFormat("MMddyy");
		String strDate = format.format(new Date());
		String userDirectory = System
				.getProperty(AutomationConstants.USER_DIRECTORY);
		String path;

		switch (result) {
		case "pass":
			path = userDirectory + AutomationConstants.TEST_REPORT_FOLDER + "/"
					+ strDate + "/PASS/";
			break;
		case "fail":
			path = userDirectory + AutomationConstants.TEST_REPORT_FOLDER + "/"
					+ strDate + "/FAIL/";
			break;
		case "tempFolder":
			path = userDirectory + AutomationConstants.TEST_REPORT_FOLDER + "/"
					+ strDate + "/TempFolder/";
			break;
		default:
			path = userDirectory + AutomationConstants.TEST_REPORT_FOLDER + "/"
					+ strDate + "/";
			break;
		}

		File file = new File(path);
		boolean createDir = file.mkdir();
		if (createDir) {
			System.out.println(AutomationConstants.FRAMEWORK_LOGS
					+ "Folder has been Created " + path);
		} else {
			System.out.println(AutomationConstants.FRAMEWORK_LOGS
					+ "Folder has already been created or not found " + path);
		}
		return path;
	}
	
	  public static String encodeFileToBase64Binary(File file) throws Exception{
          FileInputStream fileInputStreamReader = new FileInputStream(file);
          byte[] bytes = new byte[(int)file.length()];
          fileInputStreamReader.read(bytes);
          return new String(Base64.encodeBase64(bytes), "UTF-8");
      }
	  
	  
	 public static boolean checkMobileElementExist(MobileElement element){
		 boolean objectExist = false;
		 try{
			 objectExist = element.isDisplayed();
		 }catch(NoSuchElementException e){
			 return false;
		 }
		 return objectExist;
	 }
	 
	 public static void swipeDown(AppiumDriver<MobileElement> driver, double yAxis){
		 Dimension dimensions = driver.manage().window().getSize();
		 	int height = dimensions.getHeight();
		 	int width = dimensions.getWidth();
			int x = width/2;
			int top_y = (int)(height*0.80);
			int bottom_y = (int)(height*yAxis);
			System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);
			TouchAction ts = new TouchAction(driver);
			ts.press(x, top_y).moveTo(x, bottom_y).release().perform();
			
	 }
	 
	  

}
		
	
	
	
	

