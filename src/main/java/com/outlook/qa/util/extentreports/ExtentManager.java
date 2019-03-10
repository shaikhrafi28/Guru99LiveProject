package com.outlook.qa.util.extentreports;
 
import com.relevantcodes.extentreports.ExtentReports;
 
//ExtentReports extent instance created here.That instance can be reachable by getReporter() method.
 
public class ExtentManager {
 
    private static ExtentReports extent;
 
    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir + "/test-output/ExtentReport.html", true);
        }
        return extent;
    }
}