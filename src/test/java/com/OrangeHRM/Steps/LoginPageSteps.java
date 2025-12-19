package com.OrangeHRM.Steps;

import com.OrangeHRM.Elements.LoginPageElements;
import com.OrnageHRM.web.commons.WebCommons;

public class LoginPageSteps extends WebCommons
{
	LoginPageElements loginPageElements = new LoginPageElements(driver);
	public void loginpageSteps()
	{
		navigateToURL();
		isElementDisplayed(loginPageElements.loginButon);
	}
}
