
package com.outlook.qa.testcases.Rough;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.outlook.qa.base.TestBaseSetup;
import com.outlook.qa.pages.MailBoxPage;
import com.outlook.qa.pages.LoginPage;
import com.outlook.qa.util.extentreports.ExtentTestManager;

public class LoginTest01 extends TestBaseSetup {

	// Extra information:

	// 2) We send these driver and wait variables to the page class with below
	// declaration
	// Homepage homepage = new HomePage(driver,wait);
	// 3) super () method in page class transfer the driver and wait variables
	// values to the BasePage class.
	@BeforeMethod
	public void set_up() {
		initialization("chrome");
		giveUrl("outlooksignup");
	}

	@Test(priority = 0, description = "Invalid Login Scenario with wrong username and password.")
	public void invalidLoginTest_InvalidUserNameInvalidPassword() throws InterruptedException {
		// ExtentReports Description
		ExtentTestManager.getTest().setDescription("Invalid Login Scenario with wrong username and password.");

		// *************PAGE INSTANTIATIONS*************
		LoginPage signupPage = new LoginPage();
	//	MailBoxPage mailboxpage = new MailBoxPage();

		// *************PAGE METHODS********************
		signupPage.clickOnSignIn();
		signupPage.giveUserEmail("shaikhrafi08@gmail.com");
		signupPage.giveUserPwd("emiway");
		
		// *************ASSERTIONS***********************
		signupPage.verifyLoginPassword();
	}

	/*@Test(enabled=false,priority = 1, description = "Invalid Login Scenario with empty username and password.")
	public void invalidLoginTest_EmptyUserEmptyPassword() throws InterruptedException {
		// ExtentReports Description
		ExtentTestManager.getTest().setDescription("Invalid Login Scenario with empty username and password.");

		// *************PAGE INSTANTIATIONS*************
		SignUpPage signupPage = new SignUpPage();
		MailBoxPage mailboxpage = new MailBoxPage();

		// *************PAGE METHODS********************
		signupPage.signInUser(null, null);
		mailboxpage = new MailBoxPage();
		mailboxpage.clicknewmail();

		// *************ASSERTIONS***********************
		Thread.sleep(500);
		
	}*/

	@AfterMethod()
	public void cteardown() {

		driver.quit();

	}
}