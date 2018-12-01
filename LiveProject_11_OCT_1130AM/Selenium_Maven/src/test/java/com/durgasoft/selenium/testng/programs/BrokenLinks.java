package com.durgasoft.selenium.testng.programs;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLinks {
	
	public WebDriver driver;

	@Test
	public void brokenLink() throws Exception {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Available Links are :" + links.size());
		for (int i = 0; i < links.size(); i++) {
			String linkUrl = links.get(i).getAttribute("href");
			verifyActive(linkUrl);
			
		}
	}

	public void verifyActive(String linkUrl) throws Exception {
		URL url = new URL(linkUrl);
		HttpURLConnection httpurlconnection = (HttpURLConnection) url.openConnection();
		httpurlconnection.setConnectTimeout(3000);
		httpurlconnection.connect();
		if (httpurlconnection.getResponseCode() == 200) {
			System.out.println(linkUrl + "---" + httpurlconnection.getResponseMessage());
		}
		if(httpurlconnection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
		{
			System.out.println(linkUrl+"---"+httpurlconnection.getResponseMessage()
														+HttpURLConnection.HTTP_NOT_FOUND);
		}
	}
	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://www.newtours.demoaut.com/");
		driver.manage().window().maximize();
	}

}
