package com.HOPESTAR.GenericUtility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
//import org.openqa.selenium.support.events.EventFiringWebDriver;---deprecated in selenium 4
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;

public class ListenerImplementationClass implements ITestListener{


ExtentReports er;
ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		//execution starts here
		String methodName = result.getMethod().getMethodName();
		test = er.createTest(methodName);
		Reporter.log(methodName+"---->Testscript execution started");
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS,methodName+"--->Passed");
		Reporter.log(methodName+"---->Testscript execution passed");
	}

	public void onTestFailure(ITestResult result) {
		
		String methodname=result.getMethod().getMethodName();
		//EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(BaseClass.sdriver);
		String path;
		
		
		
		
		try {
			WebDriverUtility.takeScreenshot(BaseClass.driver, methodname);
			path = WebDriverUtility.takeScreenshot(BaseClass.driver, methodname);
			 test.addScreenCaptureFromPath(path, "Failure Screenshot");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	test.log(Status.FAIL, methodname+"---> Failed");
	test.log(Status.FAIL, result.getThrowable());
	Reporter.log(methodname+"--> Test Script Failed  ");
	}
	
		/*String fScript = result.getMethod().getMethodName();
		String failedScriptFormatted = fScript+ new JavaUtility().systemDateInFormat();
		
			try {
				WebDriverUtility.takeScreenshot(BaseClass.driver, failedScriptFormatted);
			} catch (Throwable e) {
				test.log(Status.FAIL, fScript+"----->Failed");
				test.log(Status.FAIL, result.getThrowable());
				Reporter.log(fScript+"---->Testscript execution failed");
				e.printStackTrace();*/
			
		
	public void onTestSkipped(ITestResult result) {
	
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"----->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+"-------------->Testscript skipped");
	}

	public void onStart(ITestContext context) {
		 ExtentSparkReporter html = new ExtentSparkReporter("./extent_reports/extent_report.html");
		 html.config().setDocumentTitle("HOPESTAR");
		 html.config().setTheme(Theme.DARK);
		 html.config().setReportName("Hopestar Life Insurance");
		
		er = new ExtentReports();
		er.attachReporter(html);
		er.setSystemInfo("OS", "windows");
		er.setSystemInfo("Base Browser", "chrome");
		er.setSystemInfo("Base_URl", "http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		er.setSystemInfo("Reporter Name", "Shruthi");
	}

	public void onFinish(ITestContext context) {
		er.flush();
	}

	
}
