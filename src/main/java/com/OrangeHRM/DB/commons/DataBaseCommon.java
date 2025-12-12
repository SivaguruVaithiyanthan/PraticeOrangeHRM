package com.OrangeHRM.DB.commons;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.OrangeHRM.framework.Utilities.DBUtilities;

public class DataBaseCommon {
		public static List<Map<String,String>> ReadedData (String Query) throws SQLException{
			List<Map<String , String>> TableData = new ArrayList<Map<String,String>>();
			
			ResultSet resultData = DBUtilities.readedDbData(Query);
			
			while(resultData.next())
			{
				Map< String, String > InnerReadedDB = new HashMap<String , String>();
				
				for(int column = 1 ; column <= resultData.getMetaData().getColumnCount() ; column++)
				{
					String columnName = resultData.getMetaData().getColumnName(column);
					String columnValue = resultData.getString(column);
					
					InnerReadedDB.put(columnName, columnValue);
				}
				TableData.add(InnerReadedDB);
			}
			return TableData;		
		}
}
