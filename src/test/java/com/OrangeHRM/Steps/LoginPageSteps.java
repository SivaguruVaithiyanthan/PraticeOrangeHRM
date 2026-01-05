package com.OrangeHRM.Steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.OrangeHRM.Elements.LoginPageElements;
import com.OrangeHRM.base.DriverIntialization;
import com.OrnageHRM.web.commons.WebCommons;


public class LoginPageSteps extends WebCommons
{
	public static WebDriver driver = new DriverIntialization().Getdriver();
	public void loginpageSteps()
	{
		LoginPageElements loginPageElements = new LoginPageElements(driver);
		navigateToURL();
		elementWait(loginPageElements.loginButon , 30);
		logMessage("pass","Login Page Loaded Succcessfully..");
	}	
	
	public void CaptureLoginPage() throws IOException
	{
		addScreenShort("Login Page");
	}
}
