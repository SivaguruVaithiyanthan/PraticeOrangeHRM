package com.OrangeHRM.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class DriverIntialization 
{
	protected static WebDriver driver = null;
		
	@Parameters("BrowserName")
	@BeforeClass(alwaysRun = true)
	public void setUpBrowser(@Optional("Chrome") String BrowserName)
	{
		if(BrowserName.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("FireFox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("No Driver Found this name : " + BrowserName);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();		
	}
	
	@AfterClass(alwaysRun = true)
	public void CloseDriver()
	{
		driver.quit();
	}
	
	public WebDriver Getdriver() 
	{
		System.out.println(driver);
		return driver;
	}
	
	public void SetDriver(WebDriver newDriver)
	{
		driver = newDriver;
	}
}
