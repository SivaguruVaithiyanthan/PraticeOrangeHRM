package com.OrangeHRM.TestNG.Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.OrangeHRM.Reports.Report;


public class TestListners extends Report implements  ITestListener
{
	
	  public void onTestStart(ITestResult result) 
	  {
		  startReporting(null);
      }
	  
	  public void onTestSuccess(ITestResult result) 
	  {
		    
      }
	  
	  public void onTestFailure(ITestResult result) 
	  {
		    
      }
	
}
