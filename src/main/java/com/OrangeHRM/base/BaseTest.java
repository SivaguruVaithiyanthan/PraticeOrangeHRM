package com.OrangeHRM.base;

import java.lang.reflect.Method;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.OrangeHRM.Reports.Report;

public class BaseTest extends DriverIntialization
{
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite()
	{
		Report.reportSetup();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method)
	{
		Report.startReporting(method.getName());
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite()
	{
		Report.stopReporting();
	}

}
