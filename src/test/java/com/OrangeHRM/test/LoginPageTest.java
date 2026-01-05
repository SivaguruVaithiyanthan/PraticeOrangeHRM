package com.OrangeHRM.test;

import java.io.IOException;

import org.testng.annotations.Test;
import com.OrangeHRM.Steps.LoginPageSteps;


public class LoginPageTest extends LoginPageSteps
{
	
	@Test
	public void VerifyLoginPage() throws IOException
	{		
		loginpageSteps();
		CaptureLoginPage();
	}
}