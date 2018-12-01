package com.durgasoft.selenium.testng.programs;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadFromExcelFileByDataProvider {
	@Test(dataProvider = "testdata")
	public void f(Map<Object, Object> mapData) {
		//System.out.println(mapData);
		System.out.println("----------Test Started-----------");
		System.out.println(mapData.get("User Name"));
		System.out.println(mapData.get("Password"));
		System.out.println(mapData.get("DOB"));
		System.out.println("----------Test Ends---------------");
	}

	@DataProvider(name = "testdata")
	public Object[][] dataProvider() throws Exception {
		FileInputStream fi = new FileInputStream(
				"D:\\LiveProject_11_OCT_1130AM\\Selenium_Maven\\testdata\\login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();

		// Define Map & Object array
		Object[][] obj = new Object[rowCount][1];
		for (int i = 0; i < rowCount; i++) {
			HashMap<Object, Object> dataMap = new HashMap<Object, Object>();
			for (int j = 0; j < colCount; j++) {
				// Read cell data and store in Map
				dataMap.put(sheet.getRow(0).getCell(j).toString(), 
						sheet.getRow(i + 1).getCell(j).toString());
			}
			obj[i][0]=dataMap;
		}
		wb.close();
		return obj;
		
	}
}
