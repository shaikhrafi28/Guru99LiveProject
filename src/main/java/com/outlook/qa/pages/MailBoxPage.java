package com.outlook.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.outlook.qa.base.TestBaseSetup;
import com.outlook.qa.pages.LoginPage;

public class MailBoxPage extends TestBaseSetup {

	
	
	
	//@FindBy(xpath = "//*[@id='app']/div/div[2]/div[1]/div[1]/div[1]/div[1]/div")
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[1]/div[1]/div[1]/div[1]/div")
	
	//*[@id="app"]/div/div[2]/div[1]/div[1]/div[1]/div[1]/div/button/div/i
	WebElement composemail;
	
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[1]/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div/div/div/div[1]/div[1]/div[1]/div[2]/div/div/div/span/input")
	WebElement receivers;
	
	@FindBy(xpath = "//*[@id='subjectLine0']")
	WebElement emailsubject;
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[1]/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div/div/div/div[1]/div[2]/div")
	WebElement emailbody;
	
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[1]/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div/div/div/div[1]/div[4]/div[2]/div[1]/button[1]")
	WebElement emailsendbtn;
	
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[1]/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div/div/div/div[1]/div[1]/div[1]/div[2]/div/div/div/span/input")
	WebElement confirmemail;
	
	// Initializing the Page Objects:
	public MailBoxPage() {
		PageFactory.initElements(driver, this);
	}

	
	public void clicknewmail() {
		composemail.click();
		}
	
	
	public void composenewmail() throws InterruptedException {
		receivers.sendKeys(prop.getProperty("receiveremail"));
		Thread.sleep(3000);
		confirmemail.click();
		emailsubject.sendKeys(prop.getProperty("esubject"));
		Thread.sleep(3000);
		emailbody.sendKeys(prop.getProperty("ebody"));
		
		emailsendbtn.click();
		}

	


}
