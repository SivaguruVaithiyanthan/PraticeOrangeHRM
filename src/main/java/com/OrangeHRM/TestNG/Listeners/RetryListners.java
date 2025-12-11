package com.OrangeHRM.TestNG.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListners implements IRetryAnalyzer
{

	@Override
	public boolean retry(ITestResult result) 
	{
		if(!result.isSuccess())
		{
			
		}
		return false;

	}

}
