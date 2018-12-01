package com.durgasoft.selenium.testng.iostreams;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class HMS_Login_Logout_Excel_API {

	public WebDriver driver;

	@Test
	public void hmsLogin()throws Exception {
		Excel_API e=new Excel_API("D:\\LiveProject_11_OCT_1130AM" 
											+ "\\Selenium_Maven\\testdata\\login.xlsx");
		int numberOfRows=e.getRows("Sheet1");
		for(int i=1;i<numberOfRows;i++)
		{
			driver.findElement(By.name("username")).clear();
			driver.findElement(By.name("username")).sendKeys(e.getCellData("Sheet1", 0, i));
			Thread.sleep(2000);
		}
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://seleniumbymahesh.com/HMS");
		driver.manage().window().maximize();
	}

}
