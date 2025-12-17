package com.OrangeHRM.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements 
{
	WebDriver driver = null;
	
	public LoginPageElements(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	public WebElement UserName;
	
	@FindBy(name = "username")
	public WebElement Password;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginButon;
}
