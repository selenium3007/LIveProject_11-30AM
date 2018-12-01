package com.durgasoft.selenium.testng.programs;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class RightClickOnElement {

	public WebDriver driver;

	@Test
	public void f() {
		WebElement element = driver.findElement(By.xpath("//*[@id='sidebar']/aside[1]/ul/li[1]/a"));
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://jqueryui.com/resizable/");
		driver.manage().window().maximize();
	}

}
