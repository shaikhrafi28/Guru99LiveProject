package com.outlook.qa.testcases.Rough;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.outlook.qa.base.TestBaseSetup;
import com.outlook.qa.pages.MailBoxPage;
import com.outlook.qa.pages.LoginPage;
import com.outlook.qa.util.baseutility.TestUtil;

//For implementing the Testnglistener
@Listeners(com.outlook.qa.util.listeners.TestNGTestListener.class)

public class MailBoxPageTest_V3 extends TestBaseSetup {

	public static ExtentReports report;
	public static ExtentTest logger;
	LoginPage signupPage;
	MailBoxPage mailboxpage;

	public MailBoxPageTest_V3() {
		super();
	}

	@BeforeSuite()
	public void beforesuite() {
		report = new ExtentReports(System.getProperty("user.dir") + "/test-output/testReport.html", true);
		report.loadConfig(
				new File(System.getProperty("user.dir") + "/src/main/java/com/qa/reporting/ExtentConfig.xml"));

	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		// report1.startReport("Windows", "chrome");
		logger = report.startTest(this.getClass().getSimpleName());
		initialization("chrome");
		giveUrl("outlooksignup");
		signupPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginToOutlook() throws InterruptedException {
//		signupPage.signInUser(null, null);
		// Logging
	//	Assert.assertTrue(true);
		
		logger.log(LogStatus.PASS, "Signed In Successfully");
		logger.log(LogStatus.FAIL, "Could not sign in");
	}

	@Test(priority = 2)
	public void clickNewEmail() throws InterruptedException {
	//	signupPage.signInUser(null, null);
		mailboxpage = new MailBoxPage();
		mailboxpage.clicknewmail();
		logger.log(LogStatus.PASS, "Clicked on New Email");

	}

	@Test(priority = 3)
	public void composeNewEmail() throws InterruptedException {
//		signupPage.signInUser(null, null);
		mailboxpage = new MailBoxPage();
		mailboxpage.clicknewmail();
		mailboxpage.composenewmail();
		logger.log(LogStatus.PASS, "Composed Mail Successfully");
		report.endTest(logger);
	}

	@AfterMethod()
	public void cbrowser() {
		
	//	TestUtil.tearDown();

		// teardo
		driver.quit();
		// Logging
		logger.log(LogStatus.PASS, "Browser closed Successfully");
		report.endTest(logger);
	}

	@AfterSuite()
	public void aftersuite() {
		report.flush();
		report.close();

	}

}
