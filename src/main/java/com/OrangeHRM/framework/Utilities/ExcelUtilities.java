package com.OrangeHRM.framework.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtilities 
{
	public static List<Map<String , String>> ReadExcelFiles(String excelFileName , String excelSheetName) throws IOException
	{
		List<Map<String , String>> ExceldataValues = new LinkedList<Map<String , String>>();
			
		//getting the root Folder with the File Path what you want....
		FileInputStream excelFile = new FileInputStream(System.getProperty("user-dir") + "\\ConfigurationFiles\\ExcelFiles\\" + excelFileName);
		
		try (//it opens the Excel file from the path and convert the Excel values into Bytes and load in the WorkBookBookObject
		XSSFWorkbook loadExcelFile = new XSSFWorkbook(excelFile))
		{
			//getting to load the Exact SheetName Values into the getSheet
			XSSFSheet getSheet = loadExcelFile.getSheet(excelSheetName);
			
			int totalNumberOfRows = getSheet.getPhysicalNumberOfRows();
			int totalNumberOfCells = getSheet.getRow(0).getPhysicalNumberOfCells();
					
			for(int i= 1 ; i < totalNumberOfRows ; i++)
			{
				Map<String , String> valuesFromExcel = new HashMap<String , String>();
				
				for(int j = 0 ; j < totalNumberOfCells ; j++)
				{
					String rowName = getSheet.getRow(0).getCell(j).getStringCellValue();
					XSSFCell columnValue = getSheet.getRow(i).getCell(j);
					
					String Value = "";

					switch(columnValue.getCellType())
					{
					case STRING :
						Value = columnValue.getStringCellValue();
						break;
						
					case NUMERIC :
						Value = String.valueOf((int) columnValue.getNumericCellValue());
						break;
						
					default:
						break;
					}
					
					valuesFromExcel.put(rowName, Value);
				}
				
				ExceldataValues.add(valuesFromExcel);
			}
		}
		return ExceldataValues;
		
	}
}
