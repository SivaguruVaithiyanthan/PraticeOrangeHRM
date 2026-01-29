package com.OrangeHRM.Steps;

import com.OrnageHRM.web.commons.WebCommons;


public class LoginPageSteps extends WebCommons
{
	public void loginpageSteps()
	{
		navigateToApplicationURL();
		logMessage("pass","Login Page Loaded Succcessfully..");
	}	

}
