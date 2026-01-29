package com.OrangeHRM.Steps;

import com.OrangeHRM.Elements.LoginPageElements;
import com.OrangeHRM.base.DriverIntialization;
import com.OrnageHRM.web.commons.WebCommons;


public class LoginPageSteps extends WebCommons
{
	public void loginpageSteps()
	{
		navigateToApplicationURL();
		logMessage("pass","Login Page Loaded Succcessfully..");
	}	
	
	public void elementsVerfication()
	{
		LoginPageElements loginElements = new LoginPageElements(new DriverIntialization().Getdriver());
		
		isElementDisplayed(loginElements.UserName);
		isElementDisplayed(loginElements.Password);
		isElementDisplayed(loginElements.loginButon);
	}
	
	
}
