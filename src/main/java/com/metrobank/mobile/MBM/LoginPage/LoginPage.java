package main.java.com.metrobank.mobile.MBM.LoginPage;

import org.openqa.selenium.By;

import main.java.com.metrobank.mobile.core.locator.Locators;
import main.java.com.metrobank.mobile.core.logger.LogGeneration;
import main.java.com.metrobank.mobile.core.utilities.PropertyFileHandler;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPage {
	
	PropertyFileHandler propertyFileHandler = new PropertyFileHandler(Locators.LOGINPAGE);
	LogGeneration logGeneration = new LogGeneration();
	
	
	public void inputUsername(AppiumDriver<MobileElement> driver, String value){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("username_xpath"))).sendKeys(value);
	}
	
	public void inputPassword(AppiumDriver<MobileElement> driver, String value){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("password_xpath"))).sendKeys(value);
	}
	
	public void clickLoginBtn(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("loginbutton_xpath"))).click();

	}
	
	public void clickNotification(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("notification_xpath"))).click();
	}
	
	public void clickSignUp(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("signup_xpath"))).click();

	}
	
	public void clickRecoverAccess(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("signup_xpath"))).click();

	}
	
	public void clickNextbutton(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("next_btn_xpath"))).click();

	}
	
	public void enterAccountNumber(AppiumDriver<MobileElement> driver, String value){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("account_number_xpath"))).sendKeys(value);

	}
	

	public void enterAccountAlias(AppiumDriver<MobileElement> driver, String value){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("account_alias_xpath"))).sendKeys(value);

	}
	
	public void enterMobileNumber(AppiumDriver<MobileElement> driver, String value){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("mobile_number_xpath"))).sendKeys(value);

	}
	
	public void enterEmail(AppiumDriver<MobileElement> driver, String value){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("enter_email_xpath"))).sendKeys(value);

	}
	
	public void enterFirstName(AppiumDriver<MobileElement> driver, String value){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("first_name_xpath"))).sendKeys(value);

	}
	
	public void enterMiddleName(AppiumDriver<MobileElement> driver, String value){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("middle_name_xpath"))).sendKeys(value);

	}
	
	public void enterLastName(AppiumDriver<MobileElement> driver, String value){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("last_name_xpath"))).sendKeys(value);

	}
	
	public void enterNickName(AppiumDriver<MobileElement> driver, String value){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("nick_name_xpath"))).sendKeys(value);

	}
	
	public void createUserName(AppiumDriver<MobileElement> driver, String value){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("create_user_name_xpath"))).sendKeys(value);

	}
	
	public void createPassword(AppiumDriver<MobileElement> driver, String value){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("create_enter_password_xpath"))).sendKeys(value);

	}
	
	public String getErrorMessage(AppiumDriver<MobileElement> driver) {
		String value = driver.findElement(By.xpath(propertyFileHandler.GetValue("error_message_xpath"))).getText();
		return value; 
	}
	
	public Boolean isErrorSessionOnAnotherBrowserDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("errMsg_other_session_ended_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public void clickOkaybutton(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("errMsg_okay_btn_xpath"))).click();

	}
	
	
	
}
