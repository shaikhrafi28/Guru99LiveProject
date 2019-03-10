package com.outlook.qa.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.outlook.qa.base.TestBaseSetup;
import com.outlook.qa.pages.MailBoxPage;

public class LoginPage extends TestBaseSetup {

	@FindBy(xpath = "//*[contains(text(),'Create free account')]")
	WebElement createAccountBtn;

	@FindBy(xpath = "//*[contains(text(),'Sign in')]")
	WebElement signInBtn;

	@FindBy(xpath = "//*[@name='loginfmt']")
	WebElement emailID;

	@FindBy(xpath = "//*[@id='idSIButton9']")
	WebElement nextSIGNIN;

	@FindBy(xpath = "//*[@name='passwd']")
	WebElement pswdP;
	
	
	
	

	@FindBy(xpath = "//*[@id='MemberName']")
	WebElement enterEmail;

	@FindBy(xpath = "//*[@id='iSignupAction']")
	WebElement nextBtn;

	@FindBy(xpath = "//*[@id='PasswordInput']")
	WebElement enterPwd;

	@FindBy(xpath = "//*[@id='FirstName']")
	WebElement enterFname;

	@FindBy(xpath = "//*[@id='LastName']")
	WebElement enterLname;

	@FindBy(xpath = "//*[@id='BirthMonth']")
	WebElement Bmonth;

	@FindBy(xpath = "//*[@id='BirthDay']")
	WebElement Bdate;

	@FindBy(xpath = "//*[@id='BirthYear']")
	WebElement Byear;

	@FindBy(xpath = "//*[@id='passwordError']")
	WebElement loginErrorpart1;
	
	@FindBy(xpath = "//*[@id='idA_IL_ForgotPassword0']")
	WebElement loginErrorpart2;
	
	
	
	// Initializing the Page Objects: VERY IMPORTANT
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void signUpNewUser() {
		createAccountBtn.click();
		enterEmail.sendKeys(prop.getProperty("newEmail"));
		nextBtn.click();
		enterPwd.sendKeys(prop.getProperty("newPwd"));
		nextBtn.click();
		enterFname.sendKeys(prop.getProperty("firstName"));
		enterLname.sendKeys(prop.getProperty("lastName"));
		nextBtn.click();
		Bmonth.sendKeys(prop.getProperty("birthmonth"));
		Bdate.sendKeys(prop.getProperty("birthday"));
		Byear.sendKeys(prop.getProperty("birthyear"));
		nextBtn.click();
	}
  
	public void clickOnSignIn() {
		signInBtn.click();
	}
	
	public void giveUserEmail(String useremail) throws InterruptedException {	
	//	emailID.sendKeys(prop.getProperty("Pemail"));
		emailID.sendKeys(useremail);
		nextSIGNIN.click();
	}
	
	public void giveUserPwd(String userpwd) throws InterruptedException {
	//	pswdP.sendKeys(prop.getProperty("Ppwd"));
		pswdP.sendKeys(userpwd);
		Thread.sleep(3000);
		nextSIGNIN.click();		
	}
	
public void verifyLoginPassword() {
	
	assertTrue(driver.getCurrentUrl().endsWith("failed"));	
	
	}

public void verifyLoginError() {
	System.out.println(loginErrorpart1.getText());
//	assertTrue(driver.getCurrentUrl().endsWith("failed"));	
	Assert.assertEquals("Your account or password is incorrect. If you don't remember your password, reset it now.", loginErrorpart1.getText());
	}
}
