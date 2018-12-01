package com.durgasoft.selenium.testng.iostreams;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcelFile {
  @Test
  public void f() throws Exception{
	  FileInputStream fi=new FileInputStream("D:\\LiveProject_11_OCT_1130AM"
	  										+ "\\Selenium_Maven\\testdata\\login.xlsx");
	  XSSFWorkbook w=new XSSFWorkbook(fi);
	  XSSFSheet s=w.getSheet("Sheet1");
	  XSSFRow row=s.getRow(2);
	  XSSFCell cell=row.getCell(1);
	  System.out.println(cell.getStringCellValue());
	  w.close();
  }
}
