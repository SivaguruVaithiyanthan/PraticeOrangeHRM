package com.OrangeHRM.test;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.OrangeHRM.Steps.LoginPageSteps;
import com.OrangeHRM.TestNG.Listeners.TestListners;
import com.OrangeHRM.base.BaseTest;

@Listeners({ TestListners.class })
public class LoginPageTest extends BaseTest {
	LoginPageSteps login = new LoginPageSteps();

	@Test
	public void VerifyLoginPage() throws IOException {
		login.loginpageSteps();		
	}
	
	@Test(dependsOnMethods = "VerifyLoginPage")
	public void verifyLoginPageElements()
	{
		login.elementsVerfication();
	}
}