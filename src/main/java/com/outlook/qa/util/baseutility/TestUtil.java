package com.outlook.qa.util.baseutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.File;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.outlook.qa.base.TestBaseSetup;

import org.apache.commons.io.FileUtils;
import org.apache.poi.sl.usermodel.Sheet;

public class TestUtil extends TestBaseSetup {

	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT = 40;

	public static String TESTDATA_SHEET_PATH = "/Selenium/Workspaces/Udemy/CAQHGroupsPortalTest/src/main/java/com/caqhgroups/qa/testdata/FreeCrmTestData.xlsx";

	static Sheet sheet;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static void tearDown()
	{
	ITestResult result = null;
	// Here will compare if test is failing then only it will enter into if condition
	if(ITestResult.FAILURE==result.getStatus())
	{
	try 
	{
	// Create refernce of TakesScreenshot
	TakesScreenshot ts=(TakesScreenshot)driver;
	 
	// Call method to capture screenshot
	File source=ts.getScreenshotAs(OutputType.FILE);
	 
	// Copy files to specific location here it will save all screenshot in our project home directory and
	// result.getName() will return name of test case so that screenshot name will be same
	FileUtils.copyFile(source, new File((System.getProperty("user.dir") + "test-output/Screenshots"+ result.getName()+".png")));
	 
	System.out.println("Screenshot taken");
	} 
	catch (Exception e)
	{
	 
	System.out.println("Exception while taking screenshot "+e.getMessage());
	} 
	 
	 
	 
	}

	

	}}
