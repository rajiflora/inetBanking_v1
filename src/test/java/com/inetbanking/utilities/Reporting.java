package com.inetbanking.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	

	public void onStart(ITestContext testContext) {
		
		//Setting a Timestamp for the report to track the history of the reports 
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timeStamp+".html";
		
		sparkReporter = new ExtentSparkReporter("ExtentReports/"+repName);
		extent=new ExtentReports();
		
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("User", "Raji");
	
		//sparkReporter.loadXMLConfig("html-config.xml");
		sparkReporter.config().setDocumentTitle("InetBanking Test Project");
		sparkReporter.config().setReportName("Functional Test Automation Report");
		sparkReporter.config().setTheme(Theme.STANDARD);
	}
	

	public void onTestSuccess(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		File f = new File(screenshotPath);
		
		if(f.exists()) {
			try {
				logger.fail("Screenshot is below: "+ logger.addScreenCaptureFromPath(screenshotPath));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestFailure(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		File f = new File(screenshotPath);
		
		if(f.exists()) {
			try {
				logger.fail("Screenshot is below: "+ logger.addScreenCaptureFromPath(screenshotPath));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void onTestSkipped(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}


	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

		
}
