package com.durgasoft.selenium.testng.programs;

import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class PrintLinks {

	public WebDriver driver;

	@Test
	public void visibleLinks() throws Exception{
		int count=0;
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The available links are:" + links.size());
		for (int i = 0; i < links.size(); i++) {
			if(!links.get(i).getText().isEmpty())
			{
			count=count+1;	
			System.out.println(links.get(i).getText());
			Thread.sleep(1000);
			links = driver.findElements(By.tagName("a"));
			}
		}
		System.out.println("The total visible links are:"+count);
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://hdfcbank.com");
		driver.manage().window().maximize();
	}
}
