package main.java.com.metrobank.mobile.MBM.Enrollment;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import main.java.com.metrobank.mobile.core.locator.Locators;
import main.java.com.metrobank.mobile.core.utilities.PropertyFileHandler;
import main.java.com.metrobank.mobile.core.utilities.TestUtil;

public class EnrollmentPage {

	PropertyFileHandler propertyFileHandler = new PropertyFileHandler(Locators.ENROLLMENT);
	
	public void clickEnrollBtn(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("enroll_btn"))).click();
	}
	
	public void inputAccountNumberEnrollment(AppiumDriver<MobileElement> driver, String value){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("enroll_account_number_xpath"))).sendKeys(value);
	}
	
	public void inputAccountAlias(AppiumDriver<MobileElement> driver, String value){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("enroll_account_alias_xpath"))).sendKeys(value);
	}
	

	public void clickCancelBtn(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("enroll_cancel_btn_xpath"))).click();
	}
	
	public void ClickEnrollAccountBtn(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("enroll_btn_enroll_page_xpath"))).click();
	}
	
	public void ClickBackButton(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("enroll_back_btn_xpath"))).click();
	}
	
	
	public Boolean isAccountNumberDisplayed(
			AppiumDriver<MobileElement> driver) {
		try{
			if (driver.findElement(
					By.xpath(propertyFileHandler.GetValue("enroll_account_number_xpath")))
					.getText() != null) {
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}

	}
	
	public Boolean isAccountAliasDisplayed(
			AppiumDriver<MobileElement> driver) {
		try{
			if (driver.findElement(
					By.xpath(propertyFileHandler.GetValue("enroll_account_alias_xpath")))
					.getText() != null) {
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}

	}
	
	public Boolean cancelButtonIsDisplayed(
			AppiumDriver<MobileElement> driver) {
		try{
			if (driver.findElement(
					By.xpath(propertyFileHandler.GetValue("enroll_cancel_btn_xpath")))
					.getText() != null) {
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}

	}
	
	public boolean enrollmentBtnIsEnabled(AppiumDriver<MobileElement> driver){
		try{
				if(driver.findElement(By.xpath(propertyFileHandler.GetValue("enrollment_error_xpath"))) != null ){
					return true;
				}else{
					return false;
				}
		}catch(Exception e){
			return false;
		}
		
	}
	
	public boolean enrollAccountIsVerified(AppiumDriver<MobileElement> driver){
		try{
				if(driver.findElement(By.xpath(propertyFileHandler.GetValue("enroll_account_verified_xpath"))) != null ){
					return true;
				}else{
					return false;
				}
		}catch(Exception e){
			return false;
		}
		
	}
	
	public boolean enrollAccountAliasIsVerified(AppiumDriver<MobileElement> driver){
		try{
				if(driver.findElement(By.xpath(propertyFileHandler.GetValue("enroll_alias_verified_xpath"))) != null ){
					return true;
				}else{
					return false;
				}
		}catch(Exception e){
			return false;
		}
		
	}
	
	public String enrollAccountErrorInvalidInput(AppiumDriver<MobileElement> driver){
		try{
				if(driver.findElement(By.xpath(propertyFileHandler.GetValue("enrollment_invalid_error_xpath"))) != null ){
					String value = driver.findElement(By.xpath(propertyFileHandler.GetValue("enrollment_invalid_error_xpath"))).getText(); 
					return value;
				}else{
					return null;
				}
		}catch(Exception e){
			return null;
		}
		
	}
	
	public boolean enrollAliasIsCorrect(AppiumDriver<MobileElement> driver){
		try{
				if(driver.findElement(By.xpath(propertyFileHandler.GetValue("enroll_alias_verified_xpath"))) != null ){
					return true;
				}else{
					return false;
				}
		}catch(Exception e){
			return false;
		}
		
	}
	
	public boolean enrollmentDepositErrorEnrolledDisplayed(AppiumDriver<MobileElement> driver){
		try{
				if(driver.findElement(By.xpath(propertyFileHandler.GetValue("enrollment_error_xpath"))) != null ){
					return true;
				}else{
					return false;
				}
		}catch(Exception e){
			return false;
		}
		
	}
	
	public boolean enrollmentDepositAccountNotExistErroredDisplayed(AppiumDriver<MobileElement> driver){
		try{
				if(driver.findElement(By.xpath(propertyFileHandler.GetValue("enrollmeent_error_exist_xpath"))) != null ){
					return true;
				}else{
					return false;
				}
		}catch(Exception e){
			return false;
		}
		
	}
	
	public boolean enrollmentVerifyOtpPageIsDisplayed(AppiumDriver<MobileElement> driver){
		try{
				if(driver.findElement(By.xpath(propertyFileHandler.GetValue("enroll_verify_otp_mobile_xpath"))) != null ){
					return true;
				}else{
					return false;
				}
		}catch(Exception e){
			return false;
		}
		
	}
	
	public boolean enrollmentVerifyOtpPageNextBtnIsEnabled(AppiumDriver<MobileElement> driver){
		try{
				if(driver.findElement(By.xpath(propertyFileHandler.GetValue("enroll_next_btn_xpath"))) != null ){
					return true;
				}else{
					return false;
				}
		}catch(Exception e){
			return false;
		}
		
	}
	
	public boolean enrollmentVerifyOtpPageSendCodeBtnIsDisplayed(AppiumDriver<MobileElement> driver){
		try{
				if(driver.findElement(By.xpath(propertyFileHandler.GetValue("enroll_send_another_code_xpath"))) != null ){
					return true;
				}else{
					return false;
				}
		}catch(Exception e){
			return false;
		}
		
	}
	
	
	
	
	
	
	
}
