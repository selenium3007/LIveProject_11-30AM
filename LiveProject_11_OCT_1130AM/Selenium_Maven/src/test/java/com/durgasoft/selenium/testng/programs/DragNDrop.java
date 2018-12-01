package com.durgasoft.selenium.testng.programs;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class DragNDrop {

	public WebDriver driver;

	@Test
	public void f() {
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions a=new Actions(driver);
		//a.dragAndDrop(drag, drop).perform();
		a.clickAndHold(drag).moveToElement(drop).release().build().perform();
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://jqueryui.com/droppable/");
		driver.manage().window().maximize();
	}

}
