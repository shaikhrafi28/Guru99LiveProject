package com.outlook.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.outlook.qa.pages.MailBoxPage;
import com.outlook.qa.util.baseutility.TestUtil;
import com.outlook.qa.util.listeners.WebEventListener;

public class TestBaseSetup {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public static Actions action1;

	public TestBaseSetup() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/resources/config/config.properties");

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

public static void initialization(String browserName) {
		

		if (browserName.equals("chrome")) {
				
			//WebDriverManager.chromedriver().setup();
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/drivers/windows/chromedriver.exe");
			
			driver = new ChromeDriver();
			System.out.println("Chrome Invoked");
			
		} 
		else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "user.dir"+"/src/test/resources/drivers/windows/geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Firefox Invoked");
		}
		else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "user.dir"+"/src/test/resources/drivers/windows/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			System.out.println("IE Invoked");
		}

		else {
			System.out.println("No Browser found");

		}

		
		/*//For WebEventListener
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;*/
   
		
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		

	}

public static void giveUrl(String url) {
	
	if (url.equals("outlooksignup")) {
	driver.get(prop.getProperty("MMTurl"));
	}
	
	else{
		System.out.println("No Link found");	
		}
	}
	
	public static void switchtoframe() throws InterruptedException
	{
		driver.switchTo().frame(driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame")));
		Thread.sleep(5000);
		WebElement popup = driver.findElement(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-close-div']"));
        popup.click();
		
	}
	
	public WebDriver getDriver() {
        return driver;
    }
	
	public void  closebrowser() {
		//Closing via JavaScript 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.close()");
		
	}
	
	public void  paction() {
		//Closing via JavaScript 
		action1= new Actions(driver);
		
	}
	
	/*
	 * public static void ewait(String ide) { WebDriverWait wait = new
	 * WebDriverWait(driver,30); WebElement aboutMe; aboutMe=
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ide))); }
	 */

}
