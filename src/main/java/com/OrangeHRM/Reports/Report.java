package com.OrangeHRM.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report 
{
	public static ExtentSparkReporter location = null;
	public static ExtentReports report = null;
	public static ExtentTest test = null;
	
	public static void reportSetup()
	{
		location = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports\\" + "6");
		report = new ExtentReports();
		report.attachReporter(location);
	}
	
	public static void startReporting(String testCaseName)
	{
		test = report.createTest(testCaseName);
		test.info("Test Started for the TestCase : " + testCaseName);
	}
	
	public static void stopReporting()
	{
		report.flush();
	}
	
}
