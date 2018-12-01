package com.durgasoft.selenium.testng.iostreams;

import org.testng.annotations.Test;

public class ReadExcelDataDriverClass {
	@Test
	public void f() throws Exception {
		Excel_API e = new Excel_API("D:\\LiveProject_11_OCT_1130AM" 
											+ "\\Selenium_Maven\\testdata\\login.xlsx");
		System.out.println("------------Read Data From Excel File By Using Col Num-----------");
		System.out.println(e.getCellData("Sheet1", 0, 1));
		System.out.println(e.getCellData("Sheet1", 1, 1));
		System.out.println(e.getCellData("Sheet1", 2, 1));
		System.out.println("------------Read Data From Excel File By Using Col Name-----------");
		System.out.println(e.getCellData("Sheet1", "User Name", 2));
		System.out.println(e.getCellData("Sheet1", "DOB", 2));
		System.out.println(e.getCellData("Sheet1", "Password", 2));
		System.out.println("------------Set Data To Excel File By Using Col Index-----------");
		System.out.println(e.setCellData("Sheet1", 3, 3, "FAILED"));
		System.out.println("------------Set Data To Excel File By Using Col Name-----------");
		System.out.println(e.setCellData("Sheet1", "Results", 2, "PASSED"));
	}
}
