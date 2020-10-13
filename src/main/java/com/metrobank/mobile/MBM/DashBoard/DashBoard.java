package main.java.com.metrobank.mobile.MBM.DashBoard;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;

import main.java.com.metrobank.mobile.core.locator.Locators;
import main.java.com.metrobank.mobile.core.utilities.PropertyFileHandler;
import main.java.com.metrobank.mobile.core.utilities.TestUtil;

public class DashBoard {

	PropertyFileHandler propertyFileHandler = new PropertyFileHandler(Locators.DASHBOARD);
	
	public void clickDashBoardMenu(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("dashboard_menu_xpath"))).click();
	}
	
	public void clickDepositMenu(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("depposit_menu_xpath"))).click();
	}
	
	public void clickCustomizePath(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("customize_xpath"))).click();
	}
	
	public void clickWidgetDeposit(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("widget_deposit_xpath"))).click();
	}
	
	
	public void clickWidgetPrepaid(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("widget_prepaid_card_xpath"))).click();
	}
	
	
	public void clickWidgetCredit(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("widget_credit_card_xpath"))).click();
	}
	
	
	public void clickWidgetShortcut(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("widget_shortcuts_xpath"))).click();
	}
	
	
	public void clickWidgetInbox(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("widget_inbox_xpath"))).click();
	}
	
	
	public void clickWidgetActivityLog(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("widget_activity_log_xpath"))).click();
	}
	
	public void clickDonebtn(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("done_btn_xpath"))).click();
	}
	
	public void clickDashBoard(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("dashboard_xpath"))).click();
	}
	
	public void clickLoansMenu(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("loans_xpath"))).click();
	}
	
	public void clickUitfMenu(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("uitf_xpath"))).click();
	}
	
	public void clickWealthManagerMenu(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("wealth_manager"))).click();
	}
	
	public void clickEnrolledContactsMenu(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("enrolled_contacts"))).click();
	}
	
	public void clickBillersMenu(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("billers_xpath"))).click();
	}
	
	public void clickAllRequestMenu(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("all_request_xpath"))).click();
	}
	
	public void clickScheduleMenu(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("schedules_xpath"))).click();
	}
	
	public void clickLogoutbtnMenu(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("logout_xpath"))).click();
	}
	
	public void clickCancelBtn(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("cancel_btn_xpath"))).click();
	}
	
	public void clickLogoutBtnDashboard(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("dashboard_logout_xpath"))).click();
	}
	
	public void confirmLogout(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("confirm_logout_xpath"))).click();
	}
	
	public void endSessionLogOut(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("end_session_logout_xpath"))).click();
	}
	
	public void continueSession(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("continue_session_btn_xpath"))).click();
	}
	
	public void clickOKbtn(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("ok_btn_xpath"))).click();
	}
	
	public void clickAddShortCut(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("add_shortcut_xpath"))).click();
	}
	
	
	public String getDepositaccountDashBoard(AppiumDriver<MobileElement> driver){
		String value = driver.findElement(By.xpath(propertyFileHandler.GetValue("deposit_account_number_xpath"))).getText();
		return value;
	}
	
	public String getAvailableBalanceDashboard(AppiumDriver<MobileElement> driver){
		String value = driver.findElement(By.xpath(propertyFileHandler.GetValue("available_balance_xpath"))).getText();
		return value;
	}
	
	public String getCreditAccount(AppiumDriver<MobileElement> driver){
		String value = driver.findElement(By.xpath(propertyFileHandler.GetValue("credit_card_account_xpath"))).getText();
		return value;
	}
	
	public String getOutstandingbalanceCredit(AppiumDriver<MobileElement> driver){
		String value = driver.findElement(By.xpath(propertyFileHandler.GetValue("outstanding_balance_xpath"))).getText();
		return value;
	}
	
	public String getAvailableCredit(AppiumDriver<MobileElement> driver){
		String value = driver.findElement(By.xpath(propertyFileHandler.GetValue("available_credit_xpath"))).getText();
		return value;
	}
	
	public String getOutstandingBalanceTotalCredit(AppiumDriver<MobileElement> driver){
		String value = driver.findElement(By.xpath(propertyFileHandler.GetValue("outstanding_balance_total_xpath"))).getText();
		return value;
	}
	
	public String getPrimaryAccountNumber(AppiumDriver<MobileElement> driver) {
		String value = driver.findElement(By.xpath(propertyFileHandler.GetValue("account_number_xpath"))).getText();
		return value; 
	}
	
	public String getCheckingAccountNumber(AppiumDriver<MobileElement> driver) {
		String value = driver.findElement(By.xpath(propertyFileHandler.GetValue("checking_account_number_xpath"))).getText();
		return value; 
	}
	
	public boolean VerifySuccessfulLogin(AppiumDriver<MobileElement> driver) {
		boolean value = driver.findElement(By.xpath(propertyFileHandler.GetValue("verifyDashboardView_xpath"))).isDisplayed();
		return value;
	}
	
	public String getDepositWidgetText(AppiumDriver<MobileElement> driver){
		String value = driver.findElement(By.xpath(propertyFileHandler.GetValue("deposit_widget_xpath"))).getText();
		return value;
	}
	
	public Boolean PrepaidWidgetIsDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("prepaid_card_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
			}catch(Exception e){
				return false;
			}
		}

	public Boolean hamburgerMenuIsDisplayed(AppiumDriver<MobileElement> driver){
		try{
			if(driver.findElement(By.xpath(propertyFileHandler.GetValue("hamburger_menu_xpath"))).getText() != null){
				return true;
			} else {
				return false;
			}
			}catch(Exception e){
				return false;
			}
		}

	public Boolean customizeMenuIsDisplayed(
			AppiumDriver<MobileElement> driver) {

		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("customize_title_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean logOutMessageIsDisplayed(
			AppiumDriver<MobileElement> driver) {

		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("logoutMessage_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public Boolean hamburgerDashboardMenuIsDisplayed(
			AppiumDriver<MobileElement> driver) {

		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("dashboard_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean hamburgerMyAccountMenuIsDisplayed(
			AppiumDriver<MobileElement> driver) {

		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("my_account_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean hamburgerLoansMenuIsDisplayed(
			AppiumDriver<MobileElement> driver) {

		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("loans_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean hamburgerUITFIsDisplayed(
			AppiumDriver<MobileElement> driver) {

		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("uitf_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean hamburgerWealthManagerIsDisplayed(
			AppiumDriver<MobileElement> driver) {

		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("wealth_manager_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean hamburgerEnrolledAccountsMenuIsDisplayed(
			AppiumDriver<MobileElement> driver) {

		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("enrolled_contacts")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean hamburgerBillersMenuIsDisplayed(
			AppiumDriver<MobileElement> driver) {

		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("billers_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean hamburgerSchedulesMenuIsDisplayed(
			AppiumDriver<MobileElement> driver) {

		TestUtil.swipeDown(driver, 0.01);
		
		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("schedules_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean hamburgerAllRequestsMenuIsDisplayed(
			AppiumDriver<MobileElement> driver) {
		
		TestUtil.swipeDown(driver, 0.01);
		
		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("all_request_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean hamburgerLogOutMenuIsDisplayed(
			AppiumDriver<MobileElement> driver) {

		TestUtil.swipeDown(driver, 0.01);
		
		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("logout_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean dashBoardLogOutMenuIsDisplayed(
			AppiumDriver<MobileElement> driver) {

		TestUtil.swipeDown(driver, 0.01);
		
		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("dashboard_logout_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean imageLogoIsDisplayed(
			AppiumDriver<MobileElement> driver) {
		
		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("imageLogo_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean myAccountDepositMenuIsDisplayed(
			AppiumDriver<MobileElement> driver) {
		
		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("my_account_deposit_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean myAccountCreditMenuIsDisplayed(
			AppiumDriver<MobileElement> driver) {
		
		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("my_account_deposit_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean myAccountPrepaidMenuIsDisplayed(
			AppiumDriver<MobileElement> driver) {
		
		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("my_account_prepaid_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean navigationDashBoardIsDisplayed(
			AppiumDriver<MobileElement> driver) {
		try{
			if (driver.findElement(
					By.xpath(propertyFileHandler.GetValue("dashboard_navigation_xpath")))
					.getText() != null) {
				return true;
			} else {
				return false;
			}
		}	catch(Exception e){
				return false;
		}
	}
	
	public Boolean navigationSendMoneyIsDisplayed(
			AppiumDriver<MobileElement> driver) {
		
		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("sendmoney_navigation_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean navigationPayBillsIsDisplayed(
			AppiumDriver<MobileElement> driver) {
		
		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("paybills_navigation_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean navigationSendLoadIsDisplayed(
			AppiumDriver<MobileElement> driver) {
		
		if (driver.findElement(
				By.xpath(propertyFileHandler.GetValue("sendload_navigation_xpath")))
				.getText() != null) {
			return true;
		} else {
			return false;
		}
	}
		
	public Boolean navigationMoreIsDisplayed(
				AppiumDriver<MobileElement> driver) {
			
			if (driver.findElement(
					By.xpath(propertyFileHandler.GetValue("more_navigation_xpath")))
					.getText() != null) {
				return true;
			} else {
				return false;
			}
	}
	
	public Boolean dashboardCreditCardIsDisplayed(
			AppiumDriver<MobileElement> driver) {
		try {
			if (driver.findElement(
					By.xpath(propertyFileHandler
							.GetValue("widget_credit_card_xpath"))).getText() != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	
	}
	
	public Boolean dashboardShortCutIsDisplayed(
			AppiumDriver<MobileElement> driver) {
		try {
			if (driver.findElement(
					By.xpath(propertyFileHandler
							.GetValue("widget_shortcuts_xpath"))).getText() != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	
	}
	
	
	public Boolean dashboardActivityLogIsDisplayed(
			AppiumDriver<MobileElement> driver) {
		try {
			if (driver.findElement(
					By.xpath(propertyFileHandler
							.GetValue("widget_activity_log_xpath"))).getText() != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	
	}
	
	public Boolean dashboardInboxIsDisplayed(
			AppiumDriver<MobileElement> driver) {
		try {
			if (driver.findElement(
					By.xpath(propertyFileHandler
							.GetValue("widget_inbox_xpath"))).getText() != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	
	}
	

	public Boolean dashboardWidgetDataIsDisplayed(AppiumDriver<MobileElement> driver, String value){
		try{
		switch (value) {
		case "AccountType":
			if(	driver.findElement(By.xpath(propertyFileHandler.GetValue("deposit_accountType_xpath"))).getText() != null){
				return true;
			}else{
				return false;
			}
	
		case "AvailableBalance":
			if(	driver.findElement(By.xpath(propertyFileHandler.GetValue("deposit_available_balance_xpath"))).getText() != null){
				return true;
			}else{
				return false;
			}
	
		case "Currency":
			if(	driver.findElement(By.xpath(propertyFileHandler.GetValue("deposit_currency_xpath"))).getText() != null){
				return true;
			}else{
				return false;
			}
		
		case "Account Number":
			if(	driver.findElement(By.xpath(propertyFileHandler.GetValue("deposit_account_number_xpath"))).getText() != null){
				return true;
			}else{
				return false;
			}
	
		case "AccountTag":
			if(	driver.findElement(By.xpath(propertyFileHandler.GetValue("deposit_account_tag_xpath"))).getText() != null){
				return true;
			}else{
				return false;
			}
		case "Deposits":
			if(	driver.findElement(By.xpath(propertyFileHandler.GetValue("deposit_widget_xpath"))).getText() != null){
				return true;
			}else{
				return false;
			}
		default:
			return false;
		}
		}catch(Exception e){
			
			return false;
		}
	}
	
	public Boolean shortCutWidgetDataIsDisplayed(AppiumDriver<MobileElement> driver, String value){
		try{
		switch (value) {
		case "SendMoney":
			if(	driver.findElement(By.xpath(propertyFileHandler.GetValue("sendmoney_xpath"))).getText() != null){
				return true;
			}else{
				return false;
			}
	
		case "MoveMoney":
			if(	driver.findElement(By.xpath(propertyFileHandler.GetValue("move_money_xpath"))).getText() != null){
				return true;
			}else{
				return false;
			}
	
		case "LoadPrepaid":
			if(	driver.findElement(By.xpath(propertyFileHandler.GetValue("load_prepaid_xpath"))).getText() != null){
				return true;
			}else{
				return false;
			}
		
		case "CardlessWithdrawal":
			if(	driver.findElement(By.xpath(propertyFileHandler.GetValue("cardless_withdrawal_xpath"))).getText() != null){
				return true;
			}else{
				return false;
			}
	
		case "OpenTimeDeposit":
			if(	driver.findElement(By.xpath(propertyFileHandler.GetValue("open_time_deposit_xpath"))).getText() != null){
				return true;
			}else{
				return false;
			}
		case "PayBills":
			if(	driver.findElement(By.xpath(propertyFileHandler.GetValue("paybills_xpath"))).getText() != null){
				return true;
			}else{
				return false;
			}
		default:
			return false;
		}
		}catch(Exception e){
			
			return false;
		}
	}
	
	public void clickShortCutWidgetData(AppiumDriver<MobileElement> driver, String value) {
		try{
		switch (value) {
		case "SendMoney":
			driver.findElement(By.xpath(propertyFileHandler.GetValue("sendmoney_option_xpath"))).click();
			break;
		case "MoveMoney":
			driver.findElement(By.xpath(propertyFileHandler.GetValue("movemoney_option_xpath"))).click();
			break;
		case "LoadPrepaid":
			driver.findElement(By.xpath(propertyFileHandler.GetValue("loadprepaid_option_xpath"))).click();
			break;
		case "CardlessWithdrawal":
			driver.findElement(By.xpath(propertyFileHandler.GetValue("cardless_withdrawal_option_xpath"))).click();
			break;
		case "OpenTimeDeposit":
			driver.findElement(By.xpath(propertyFileHandler.GetValue("open_time_option_xpath"))).click();
			break;
		case "PayBills":
			driver.findElement(By.xpath(propertyFileHandler.GetValue("paybills_option_xpath"))).click();
			break;
		case "Move":
			driver.findElement(By.xpath(propertyFileHandler.GetValue("move_option_menu_xpath"))).click();
			break;
			
		default:
			System.out.println("Failed to click shortcut widget");
		}
		}catch(Exception e){
			System.out.println("Failed to click shortcut widget");
		}
	}
	
	public void clickInboxWidgetData(AppiumDriver<MobileElement> driver, String value) {
		try{
		switch (value) {
		case "5":
			driver.findElement(By.xpath(propertyFileHandler.GetValue("five_transction_xpath"))).click();
			break;
		case "10":
			driver.findElement(By.xpath(propertyFileHandler.GetValue("ten_transaction_xpath"))).click();
			break;
		case "30":
			driver.findElement(By.xpath(propertyFileHandler.GetValue("thirty_transaction_xpath"))).click();
			break;
		case "Move":
			driver.findElement(By.xpath(propertyFileHandler.GetValue("move_option_menu_xpath"))).click();
			break;
			
		default:
			System.out.println("Failed to click inbox widget");
		}
		}catch(Exception e){
			System.out.println("Failed to click inbox widget");
		}
	}
	
	public Boolean InboxWidgetDataIsDisplayed(AppiumDriver<MobileElement> driver, String value){
		try{
		switch (value) {
		case "5":
			if(	driver.findElement(By.xpath(propertyFileHandler.GetValue("five_transction_xpath"))).getText() != null){
				return true;
			}else{
				return false;
			}
	
		case "10":
			if(	driver.findElement(By.xpath(propertyFileHandler.GetValue("ten_transaction_xpath"))).getText() != null){
				return true;
			}else{
				return false;
			}
	
		case "30":
			if(	driver.findElement(By.xpath(propertyFileHandler.GetValue("thirty_transaction_xpath"))).getText() != null){
				return true;
			}else{
				return false;
			}
		default:
			return false;
		}
		}catch(Exception e){
			
			return false;
		}
	}
	
	public void clickCustomizeMenu(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("customize_xpath"))).click();
	}
	
	public void clickHamburgerMenu(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("hamburger_menu_xpath"))).click();
	}
	
	public void clickDisplayOptionsMenu(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("display_option_menu_xpath"))).click();
	}
	
	public void clickMyAccounts(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("my_account_xpath"))).click();
	}
	
	public void clickDashBoardLogout(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("dashboard_logout_xpath"))).click();
	}
	
	public void clickhamburgerMenuMyAccounts(AppiumDriver<MobileElement> driver){
		driver.findElement(By.xpath(propertyFileHandler.GetValue("my_accounts_hamburger_xpath"))).click();
	}
	
	public String getErrorMessageWidget(AppiumDriver<MobileElement> driver){
		String value = driver.findElement(By.xpath(propertyFileHandler.GetValue("widget_error_message_xpath"))).getText();
		return value;
	}
	
	public String getDepositAvailableBalanceDashboard(AppiumDriver<MobileElement> driver){
		String value = driver.findElement(By.xpath(propertyFileHandler.GetValue("deposit_available_balance_xpath"))).getText();
		return value;
	}
	
	public String getDepositAccountTypeDashboard(AppiumDriver<MobileElement> driver){
		String value = driver.findElement(By.xpath(propertyFileHandler.GetValue("deposit_accountType_xpath"))).getText();
		return value;
	}
	
	public String getDepositAccountCurrencyDashboard(AppiumDriver<MobileElement> driver){
		String value =driver.findElement(By.xpath(propertyFileHandler.GetValue("deposit_currency_xpath"))).getText();
		return value;
	}
	
	public String getDepositAccountTagDashboard(AppiumDriver<MobileElement> driver){
		String value =driver.findElement(By.xpath(propertyFileHandler.GetValue("deposit_account_tag_xpath"))).getText();
		return value;
	
	}
	
}
