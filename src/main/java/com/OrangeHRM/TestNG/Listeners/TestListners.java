package com.OrangeHRM.TestNG.Listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.OrangeHRM.Reports.Report;
import com.OrangeHRM.base.DriverIntialization;
import com.OrnageHRM.web.commons.WebCommons;


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
		  stopReporting();
      }
	  
	  public void onTestFailure(ITestResult result) 
	  {
		    String TestCaseName = result.getMethod().getMethodName();
		    test.fail("Testcase Failed : " + TestCaseName);
		    test.fail("Reason for Testcase Failed : " + result.getThrowable().getLocalizedMessage());
		    try 
		    {
				test.addScreenCaptureFromPath(WebCommons.CaptureScreenShot(new DriverIntialization().Getdriver(), TestCaseName));
			} 
		    catch (IOException e) {
				e.printStackTrace();
			}
		    stopReporting();
      }
	  
	  public void onTestSkipped(ITestResult result) 
	  {
		    String TestCaseName = result.getMethod().getMethodName();
		    test.fail("Testcase Skipped : " + TestCaseName);
		    test.fail("Reason for Testcase Skipped : " + result.getThrowable().getLocalizedMessage());
		    try 
		    {
				test.addScreenCaptureFromPath(WebCommons.CaptureScreenShot(new DriverIntialization().Getdriver(), TestCaseName));
			} 
		    catch (IOException e) {
				e.printStackTrace();
			}
		    stopReporting();
      }
	
}
