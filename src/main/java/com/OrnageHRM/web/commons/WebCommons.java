package com.OrnageHRM.web.commons;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.OrangeHRM.Reports.Report;
import com.OrangeHRM.base.DriverIntialization;
import com.OrangeHRM.framework.Utilities.PropertiesUtilities;

public class WebCommons extends DriverIntialization
{
	public static WebDriver driver = new DriverIntialization().Getdriver();
	public Properties properties = PropertiesUtilities.readData("config.properties");
	
	public void navigateToURL() {
		driver.get(properties.getProperty("ApplicationURL"));
	}
	
	
	public void elementClickByXpath(String Values) {
		driver.findElement(By.xpath(Values)).click();
	}
	
	public void elementClickByIdh(String Values) {
		driver.findElement(By.id(Values)).click();
	}
	
	
	public void MoveToTheElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void ScrollToTheElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoView()", element);
	}
	
	public Set<String> windowHandles()
	{
		return driver.getWindowHandles();
	}
	
	public void switchToCurrentWindow(String WindowID)
	{
		driver.switchTo().window(WindowID);
	}
	
	public void switchFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void switchToDefaultFrame()
	{
		driver.switchTo().defaultContent();
	}
	
	public void logMessage(String Status , String message)
	{
		if(Status.equalsIgnoreCase("pass")) { Report.test.pass(message); }
		else if(Status.equalsIgnoreCase("fail")) { Report.test.fail(message); }
		else if(Status.equalsIgnoreCase("info")) { Report.test.info(message); }
		else if(Status.equalsIgnoreCase("warning")) { Report.test.warning(message); }
	}
	
	public static String CaptureScreenShot(WebDriver driver , String nameOfTheImage) throws IOException{
		
		String locationtoStore = System.getProperty("user.dir") + "\\ScreenShot\\" + nameOfTheImage +".png";	
		File captureScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Destination = new File(locationtoStore);
		
		if(captureScreenshot.exists())
		{
			captureScreenshot.delete();
		}
		
		FileUtils.copyFile(captureScreenshot, Destination);
		return locationtoStore;		
	}
	
	public boolean isElementDisplayed(WebElement elment)
	{
		if(elment.isDisplayed())
		{
			return true;
		}
	   return false;
	}
		
}
