package com.OrangeHRM.Steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.OrangeHRM.Elements.LoginPageElements;
import com.OrangeHRM.base.DriverIntialization;
import com.OrangeHRM.framework.Utilities.ExcelUtilities;
import com.OrnageHRM.web.commons.WebCommons;


public class LoginPageSteps extends WebCommons
{
	private static List<Map<String , String>> excelLoginDatas= null;
	
	public void loginpageSteps()
	{
		navigateToApplicationURL();
		logMessage("pass","Login Page Loaded Succcessfully..");
	}	
	
	public void elementsVerfication()
	{
		LoginPageElements loginElements = new LoginPageElements(new DriverIntialization().Getdriver());
		
		elementWait(loginElements.UserName,5);
		
		isElementDisplayed(loginElements.UserName);
		isElementDisplayed(loginElements.Password);
		isElementDisplayed(loginElements.loginButon);
	}
	
	public void checkLoginCredentials() throws IOException
	{
		excelLoginDatas = ExcelUtilities.ReadExcelFiles("Loginpasswords.xlsx", "LoginPageCredentials");
		
		for (int index =  0; index < excelLoginDatas.size(); index ++)
		{
			
		}
	}
}
	

