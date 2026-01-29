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
			int retryCount = 0;
			int maxCount = 2;
			if(retryCount < maxCount)
			{
				retryCount++;
				return true;
			}
			return false;
		}
		return false;

	}

}
