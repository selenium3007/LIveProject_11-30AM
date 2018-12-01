package com.durgasoft.selenium.testng.iostreams;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class HMS_Login_Excel_API {

	public WebDriver driver;

	@Test
	public void hmsLogin() throws Exception {
		Excel_API e = new Excel_API("D:\\LiveProject_11_OCT_1130AM" 
											+ "\\Selenium_Maven\\testdata\\login.xlsx");
		driver.findElement(By.name("username")).sendKeys(e.getCellData("Sheet1", 0, 1));
		driver.findElement(By.name("password")).sendKeys(e.getCellData("Sheet1", 2, 1));
		driver.findElement(By.name("submit")).click();
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://seleniumbymahesh.com/HMS");
		driver.manage().window().maximize();
	}

}
