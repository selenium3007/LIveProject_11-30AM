package com.durgasoft.selenium.testng.programs;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

public class FaceBook_DD {

	public WebDriver driver;

	@Test
	public void f() throws Exception{
		driver.findElement(By.id("month")).sendKeys("Jul");
		Thread.sleep(3000);
		/*new Select(driver.findElement(By.id("month"))).selectByIndex(3);
		Thread.sleep(3000);
		new Select(driver.findElement(By.id("month"))).selectByValue("12");
		Thread.sleep(3000);
		new Select(driver.findElement(By.id("month"))).selectByVisibleText("May");*/
		WebElement ddMonth = driver.findElement(By.id("month"));
		Select monthDD = new Select(ddMonth);
		monthDD.selectByIndex(3);
		Thread.sleep(3000);
		monthDD.selectByValue("12");
		Thread.sleep(3000);
		monthDD.selectByVisibleText("May");
		
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
	}

}
