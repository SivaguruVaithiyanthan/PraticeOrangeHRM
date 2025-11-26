package com.pratice.TestNG.Class;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PraticeClassOne 
{
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before Test Started..");
	}
	
	@BeforeClass
	public void beforeClass() 
	{
		System.out.println("Before Class Started..");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method is Running..");
	}
	
				@Test
				public void TestOne()
				{
					System.out.println("Test One is Running..");
				}
				
				@Test
				public void TestTwo()
				{
					System.out.println("Test Two is Running..");
				}
				
				@Test
				public void TestThree()
				{
					System.out.println("Test Three is Running..");
				}
				
		@AfterMethod
		public void afterMethod()
		{
			System.out.println("After Method is Running..");
		}
		
		@AfterClass
		public void afterClass() 
		{
			System.out.println("After Class Started..");
		}
		
		@AfterTest
		public void afterTest()
		{
			System.out.println("Before Test Started..");
		}
}
