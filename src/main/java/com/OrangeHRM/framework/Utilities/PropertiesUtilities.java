package com.OrangeHRM.framework.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtilities {

	public static Properties readData(String FileName)  {
		Properties properties = new Properties();
		FileInputStream location = null;
		try 
		{
			location = new FileInputStream(System.getProperty("user.dir") +"\\Config\\"+ FileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		try 
		{
			properties.load(location);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return properties;		
	}
}
