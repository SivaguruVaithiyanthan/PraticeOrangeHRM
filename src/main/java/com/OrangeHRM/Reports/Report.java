package com.OrangeHRM.Reports;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report 
{
	public static ExtentSparkReporter location = null;
	public static ExtentReports report = null;
	public static ExtentTest test = null;
	
	@BeforeSuite(alwaysRun = true)
	public void reportSetup()
	{
		location = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports\\" + "AutomationRepot.html");
		report = new ExtentReports();
		report.attachReporter(location);
	}
	
	public void startReporting(String testCaseName)
	{
		test = report.createTest(testCaseName);
		test.info("Test Started for the TestCase : " + testCaseName);
	}
	
	public void stioReporting()
	{
		report.flush();
	}
	
}
