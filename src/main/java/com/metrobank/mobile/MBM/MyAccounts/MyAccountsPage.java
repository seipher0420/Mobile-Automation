package main.java.com.metrobank.mobile.MBM.MyAccounts;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventFlag;

import org.openqa.selenium.By;

import main.java.com.metrobank.mobile.core.locator.Locators;
import main.java.com.metrobank.mobile.core.utilities.PropertyFileHandler;
import main.java.com.metrobank.mobile.core.utilities.TestUtil;

public class MyAccountsPage {

	PropertyFileHandler propertyFileHandler = new PropertyFileHandler(Locators.MYACCOUNTS);
	
	public void inputAccountNumber(AppiumDriver<MobileElement> driver, String value){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("account_number_textbox_xpath"))).sendKeys(value);
	}
	
	public void inputAccountAlias(AppiumDriver<MobileElement> driver, String value){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("account_alias_textbox_xpath"))).sendKeys(value);
	}
	
	public String getAccountNumberErrorMessage(AppiumDriver<MobileElement> driver) {
		return driver.findElement(By.xpath(propertyFileHandler.GetValue("account_number_errorMsg_xpath"))).getText();
	}
	
	public boolean clickPrimaryAccount(AppiumDriver<MobileElement> driver){
		try {
			driver.findElement(By.xpath(propertyFileHandler.GetValue("primary_account_xpath"))).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean clickEnrollBtn(AppiumDriver<MobileElement> driver){
		try {
			driver.findElement(By.xpath(propertyFileHandler.GetValue("enroll_btn_xpath"))).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickCancelBtn(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("cancel_btn_xpath"))).click();
	}
	
	public void clickBackBtn(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("back_btn_xpath"))).click();
	}
	
	public boolean clickNextBtn(AppiumDriver<MobileElement> driver){
		try {
			driver.findElement(By.xpath(propertyFileHandler.GetValue("next_btn_xpath"))).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean isMyAccountsTitleDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("my_accounts_title_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean isEnrollButtonDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("enroll_btn_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean isEnrollAccountTitleDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("enroll_account_title_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean isPrimaryAccountDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("primary_account_alias_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean isVerificationTitleDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("verification_title_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	/*
	 * Not working for now due to Enabled property NOT PROPERLY SET
	 */
	public boolean isEnrollBtnEnabled(AppiumDriver<MobileElement> driver){
		boolean isEnabled = false;
		isEnabled = driver.findElement(By.xpath(propertyFileHandler.GetValue("enroll_btn_xpath"))).isEnabled();
		return isEnabled;
	}
	
	public Boolean isCheckDetailsBtnEnabled(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("errMsg_alias_invalid_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	/*
	 * Error Messages
	 */
	public Boolean isErrorAccountDoesNotExistDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("errMsg_account_does_not_exist_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean isErrorInvalidInputDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("errMsg_account_does_not_exist_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean isErrorAccountNumberRequiredDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("errMsg_account_number_required_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean isErrorEnter13DigitDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("errMsg_enter_13_digit_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean isErrorCannotValidateDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("errMsg_cannot_validate_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean isErrorAccountAlreadyEnrolledDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("errMsg_already_enrolled_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean isErrorAliasAlreadyInUseDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("errMsg_alias_already_in_use_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean isErrorAliasInvalidDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("errMsg_alias_invalid_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean isErrorOTPInvalidDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("errMsg_otp_code_invalid_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean isErrorInvalidPasscodeExceededDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("errMsg_invalid_passcode_exceeded_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean isErrorMaximumAttemptsDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("errMsg_invalid_passcode_exceeded_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean isErrorDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("account_alias_description_when_error_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	/*
	 * VERIFICATION SCREEN
	 */
	public void inputOTP(AppiumDriver<MobileElement> driver, String value) throws InterruptedException {

		// click first box to enable keyboard
		driver.findElement(By.xpath(propertyFileHandler.GetValue("OTP_digit_1_xpath"))).click();
		TestUtil.waitTime(1);
		((AndroidDriver<MobileElement>) driver).pressKey(TestUtil.GetKeyEvent(value.charAt(0)));
		((AndroidDriver<MobileElement>) driver).pressKey(TestUtil.GetKeyEvent(value.charAt(1)));
		((AndroidDriver<MobileElement>) driver).pressKey(TestUtil.GetKeyEvent(value.charAt(2)));
		((AndroidDriver<MobileElement>) driver).pressKey(TestUtil.GetKeyEvent(value.charAt(3)));
		((AndroidDriver<MobileElement>) driver).pressKey(TestUtil.GetKeyEvent(value.charAt(4)));
		((AndroidDriver<MobileElement>) driver).pressKey(TestUtil.GetKeyEvent(value.charAt(5)));
	}
	
	
	/*
	 * MANAGE ACCOUNT SETTINGS
	 */
	
	public Boolean isDepositTabDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("deposit_tab_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean isCreditTabDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("credit_tab_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean isPrepaidTabDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("prepaid_tab_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean isCheckingAndSavingsHeaderDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("checking_and_savings_header_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	
}
