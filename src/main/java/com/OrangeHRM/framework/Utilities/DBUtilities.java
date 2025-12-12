package com.OrangeHRM.framework.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtilities {
		public static  ResultSet readedDbData (String Query) throws SQLException
		{
			ResultSet result = null;
			Properties properties = PropertiesUtilities.readData("config.properties");
			
			String DbURL = properties.getProperty("");
			String DbUserName = properties.getProperty("");
			String DbPassWord = properties.getProperty("");
			
			Connection connection = DriverManager.getConnection(DbURL, DbUserName, DbPassWord);
			
			result = connection.createStatement().executeQuery(Query);		
			return result;			
		}

}
