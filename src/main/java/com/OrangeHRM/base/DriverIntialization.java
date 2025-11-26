package com.OrangeHRM.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverIntialization 
{
	private static WebDriver driver = null;
	
	@BeforeMethod(alwaysRun = true)
	public static void setUpBrowser(String BrowserName)
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
	
	@AfterMethod(alwaysRun = true)
	public void CloseDriver()
	{
		driver.quit();
	}
	
	public WebDriver setdriver() 
	{
		return driver;
	}
	
	public void SetDriver(WebDriver newDriver)
	{
		driver = newDriver;
	}
}
