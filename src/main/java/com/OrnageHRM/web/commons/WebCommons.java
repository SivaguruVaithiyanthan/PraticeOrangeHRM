package com.OrnageHRM.web.commons;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.OrangeHRM.base.DriverIntialization;
import com.OrangeHRM.framework.Utilities.PropertiesUtilities;

public class WebCommons extends DriverIntialization
{
	public WebDriver driver = new DriverIntialization().Getdriver();
	public Properties properties = PropertiesUtilities.readData("config.properties");
	
	public void navigateToURL(String URL) {
		driver.get(properties.getProperty(URL));
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
		
}
