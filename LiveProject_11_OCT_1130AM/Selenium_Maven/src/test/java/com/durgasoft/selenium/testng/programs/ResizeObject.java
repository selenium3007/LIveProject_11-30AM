package com.durgasoft.selenium.testng.programs;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class ResizeObject {

	public WebDriver driver;

	@Test
	public void f() {
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
		Actions a=new Actions(driver);
		//a.dragAndDropBy(drag, 200, 500).perform();
		a.clickAndHold(drag).moveByOffset(300, 50).release().build().perform();
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://jqueryui.com/resizable/");
		driver.manage().window().maximize();
	}

}
