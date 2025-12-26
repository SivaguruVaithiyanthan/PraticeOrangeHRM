package com.OrangeHRM.Steps;

import java.io.IOException;

import com.OrangeHRM.Elements.LoginPageElements;
import com.OrnageHRM.web.commons.WebCommons;


public class LoginPageSteps extends WebCommons
{
	LoginPageElements loginPageElements = new LoginPageElements(driver);
	public void loginpageSteps()
	{
		navigateToURL();
		elementWait(loginPageElements.loginButon , 30);
		logMessage("pass","Login Page Loaded Succcessfully..");
	}	
	
	public void CaptureLoginPage() throws IOException
	{
		addScreenShort("Login Page");
	}
}
