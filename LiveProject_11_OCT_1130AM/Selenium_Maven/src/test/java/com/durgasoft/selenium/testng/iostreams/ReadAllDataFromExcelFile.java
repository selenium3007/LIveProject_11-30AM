package com.durgasoft.selenium.testng.iostreams;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadAllDataFromExcelFile {
	public FileInputStream fi;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow row;
	public XSSFCell cell;

	@Test
	public void f() throws Exception {
		fi = new FileInputStream("D:\\LiveProject_11_OCT_1130AM" 
									+ "\\Selenium_Maven\\testdata\\login.xlsx");
		w = new XSSFWorkbook(fi);
		s = w.getSheet("Sheet1");
		int rowCount = s.getLastRowNum() - s.getFirstRowNum();
		System.out.println(rowCount);
		for (int i = 1; i <= rowCount; i++) {
			row = s.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.println(row.getCell(j).getStringCellValue());
			}
			System.out.println();
		}
	}
}
