package com.durgasoft.selenium.testng.programs;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class Slider {

	public WebDriver driver;

	@Test
	public void f() {
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.xpath(".//*[@id='slider']/span"));
		Actions a=new Actions(driver);
		//a.clickAndHold(drag).moveByOffset(100, 0).release().build().perform();
		a.dragAndDropBy(drag, 200, 0).perform();
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://jqueryui.com/slider/");
		driver.manage().window().maximize();
	}

}
