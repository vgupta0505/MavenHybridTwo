package com.MavenHybridTwo.DataProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	
	//public ExtentHtmlReporter htmlReporter;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;	

	public void onStart(ITestContext context) {

		SimpleDateFormat myformat = new  SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")	;
		Date date = new Date();//fetch the current date
		String timeStamp=	 myformat.format(date);
		String   repName = "TestReport"  +timeStamp+ ".html" ;
		
	sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+ "\\reports\\" + repName);
	sparkReporter.config().setDocumentTitle("Automation Report");
	sparkReporter.config().setReportName("Automation Report");
	sparkReporter.config().setTheme(Theme.DARK);
	extent = new ExtentReports();
	extent.attachReporter(sparkReporter);
	extent.setSystemInfo("Environment " ,  "QA");
	extent.setSystemInfo("OS",  "Windows10");
	extent.setSystemInfo("BrowserName" ,  "Chrome");

	}	

	public void onTestSuccess(ITestResult result) {
		test =  extent.createTest(result.getName());		
		test.log(Status.PASS, "Test Passed");	

	}

	public void onTestFailure(ITestResult result) {
		test =  extent.createTest(result.getName());	
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
		String screenshotPath  = System.getProperty("user.dir") + "\\screenshots\\"+ result.getName() + ".png";		
		try {
			test.addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			System.out.println(" The screen shot for the failure was captured " + e.getMessage());
		}
	}

	public void onTestSkipped(ITestResult result) {
	
		test =  extent.createTest(result.getName());	
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());

	}
	

	public void onFinish(ITestContext context) {
	 extent.flush();
	 /*try {
		URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
		 // Create the email message
		  ImageHtmlEmail email = new ImageHtmlEmail();
		  email.setDataSourceResolver(new DataSourceUrlResolver(url));
		  email.setHostName("smtp.googlemail.com");
		  email.setSmtpPort(465);
		  email.setAuthenticator(new DefaultAuthenticator("pavanoltraining@gmail.com", "password"));
		  email.setSSLOnConnect(true);
		  email.setFrom("pavanoltraining@gmail.com");   //Sender
		  email.setSubject("Test Results");
		  email.setMsg("Please find Attached Report....");
		  email.addTo("pavankumar.busyqa@gmail.com");   //Receiver
		  email.attach(url, "extent report", "please check report...");
		  email.send();   // send the email
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/

	}
	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

}
