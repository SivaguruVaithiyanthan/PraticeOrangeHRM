package com.OrangeHRM.base;

import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;
import com.OrangeHRM.Reports.Report;

public class BaseTest extends DriverIntialization
{
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite()
	{
		Report.reportSetup();
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite()
	{
		Report.stopReporting();
	}

}
