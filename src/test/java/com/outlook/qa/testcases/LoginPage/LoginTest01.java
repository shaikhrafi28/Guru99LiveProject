
package com.outlook.qa.testcases.LoginPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.outlook.qa.base.TestBaseSetup;
import com.outlook.qa.pages.MailBoxPage;
import com.outlook.qa.pages.LoginPage;
import com.outlook.qa.util.extentreports.ExtentTestManager;

public class LoginTest01 extends TestBaseSetup {

	// Extra information:

	// 2) We send these driver and wait variables to the page class with below
	// declaration

	// 3) super () method in page class transfer the driver and wait variables
	// values to the BasePage class.
	@BeforeTest
	public void set_up() {
		initialization("chrome");
		giveUrl("outlooksignup");
	}

	@Test(priority = 0, description = "Invalid Login Scenario with wrong username and password.")
	public void LoginTest_InvalidPassword() throws InterruptedException {
		// ExtentReports Description
		ExtentTestManager.getTest().setDescription("Invalid Login Scenario with wrong username and password.");

		// *************PAGE INSTANTIATIONS*************
		LoginPage signupPage = new LoginPage();
		

		// *************PAGE METHODS********************
		signupPage.clickOnSignIn();
		signupPage.giveUserEmail("shaikhrafi08@gmail.com");
		signupPage.giveUserPwd("emiway");

		// *************ASSERTIONS***********************
		Thread.sleep(500);
		signupPage.verifyLoginError();
	}

	@AfterTest(enabled=false)
	public void teardown() {
		
		driver.quit();

	}
}