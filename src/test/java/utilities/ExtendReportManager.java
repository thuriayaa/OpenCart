package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 
import org.testng.*;

import com.aventstack.extentreports.*;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

import com.aventstack.extentreports.ExtentReports;

//interface ITestListener - implements ** 

		public class ExtendReportManager implements ITestListener {
			
//these are object variables at class level. 
			
			public ExtentSparkReporter sparkReporter;
			
			public ExtentReports extent;
			
			public ExtentTest test;
			
			public String reportName; 

/**

in java, there is a class called date, it gives current date. you need to update the format to get the format you want. another class called 
simple date format gives in our desired format also. 

make the file name dynamic to be able to save each execution report to track all ran reports with a different file name with date and time.
		
Example: RegressionTest2024.09.29.10.34.25.html <-- first report. --> send report name RegressionTest2024.09.30.10.34.25.html

control this using java classes: date and simple date format. 

converted this 3 line code to online that is live: 

			SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss"); 
			
			Date dt = new Date();
			
			df.format(dt);

*/
	
		public void onStart(ITestContext context) {
			
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			
			reportName = "Test-Report-" + timeStamp  + ".html";
			
			
			
			sparkReporter = new ExtentSparkReporter("./reports/" + reportName );
			
			sparkReporter.config().setDocumentTitle("OpenCart Automation Report"); 
			
			sparkReporter.config().setReportName("OpenCart Functional Testing");
			
			sparkReporter.config().setTheme(Theme.DARK);
			
			
			
			extent = new ExtentReports(); 
			
			extent.attachReporter(sparkReporter);
			
			extent.setSystemInfo("Application", "OpenCart"); //key and value 
			
			extent.setSystemInfo("Module", "Admin");
			
			extent.setSystemInfo("Sub Module", "Customers");
			
			extent.setSystemInfo("User Name", System.getProperty("user.name")); //get laptop's user's name. 
			
			extent.setSystemInfo("Environment", "QA");
			
			
			
			String os = context.getCurrentXmlTest().getParameter("OS"); //get data from  xml file. os gives windows value. 
			
			extent.setSystemInfo("Operating System", os);
			
			
			
			String browserName = context.getCurrentXmlTest().getParameter("browser");
			
			extent.setSystemInfo("Browser Name", browserName);
			
			
			
			List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
			
//set if condition to get groups if there is, if not... ! means not. 
			
			if(!includedGroups.isEmpty()) {
				
				extent.setSystemInfo("Groups", includedGroups.toString());
				
			} //if closed
		
			
		}//method closed
	
	
	

		public void onTestSuccess(ITestResult result) {
			    
			test = extent.createTest(result.getTestClass().getName());
			
			test.assignCategory(result.getMethod().getGroups());
			
			test.log(Status.PASS, result.getName() + " Have passed.");
			
		}//method closed
	
		
		
	
		public void onTestFailure(ITestResult result) {
			
			test = extent.createTest(result.getTestClass().getName());
			
			test.assignCategory(result.getMethod().getGroups());

			
			test.log(Status.FAIL, result.getName() + " Have failed.");
			
			test.log(Status.INFO, result.getThrowable().getMessage());
			
			
			try {
			
				
			String imgPath = new BaseClass().captureScreetshot(result.getName()); //file path screenshot. 
			
			test.addScreenCaptureFromPath(imgPath);
			
			
			} catch (Exception e) {
				
				e.printStackTrace();
				
			} //try catch closed
			
			
		  }//method closed

	
		
		public void onTestSkipped(ITestResult result) {
			   

			test = extent.createTest(result.getTestClass().getName());
			
			test.assignCategory(result.getMethod().getGroups());

			
			test.log(Status.SKIP, result.getName() + " Have skipped.");
			
			test.log(Status.INFO, result.getThrowable().getMessage());
			
			
		}//method closed
		
		
		
		public void onFinish(ITestContext context) {
			    
			extent.flush();
			
			String PathOfExtentReport = System.getProperty("user.dir") + "/reports/" + reportName; 
			
			File extentReport = new File (PathOfExtentReport);
			
			
			try {
				
				Desktop.getDesktop().browse(extentReport.toURI()); //desktop is a class from java.awt packet
			
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}//try catch closed
			
			
			
		}//method closed
		
		
		
		//through xml we will execute this file. 
		
	

}//class closed
