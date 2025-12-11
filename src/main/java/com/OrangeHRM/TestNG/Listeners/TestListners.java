package com.OrangeHRM.TestNG.Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.OrangeHRM.Reports.Report;


public class TestListners extends Report implements  ITestListener
{
	
	  public void onTestStart(ITestResult result) 
	  {
		  String TestCaseName = result.getMethod().getMethodName();
		  startReporting(TestCaseName);
      }
	  
	  public void onTestSuccess(ITestResult result) 
	  {
		  String TestCaseName = result.getMethod().getMethodName();
		  test.pass("TestCase Successfully Completed for the TestCase : " + TestCaseName);
      }
	  
	  public void onTestFailure(ITestResult result) 
	  {
		    
      }
	
}
