package com.durgasoft.selenium.testng.programs;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

public class NotificationAlerts_Chrome {
	public WebDriver driver;
	@Test
	public void f() {
		
	}
	@BeforeTest
	public void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("http://icicibank.com");
		driver.manage().window().maximize();
	}
}
