package com.OrangeHRM.test;

import java.io.IOException;
import org.testng.annotations.Test;
import com.OrangeHRM.Steps.LoginPageSteps;
import com.OrangeHRM.base.BaseTest;


public class LoginPageTest extends BaseTest
{
	LoginPageSteps login = new LoginPageSteps();

	@Test
	public void VerifyLoginPage() throws IOException
	{	
		login.loginpageSteps();
		login.CaptureLoginPage();
	}
}