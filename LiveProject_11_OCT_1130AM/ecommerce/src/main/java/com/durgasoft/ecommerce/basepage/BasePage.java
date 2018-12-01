package com.durgasoft.ecommerce.basepage;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {

	public static ExtentReports extent;
	public ExtentTest test;
	public ITestResult result;
	public static WebDriver driver;
	public static final String path = "./config.properties";
	public String log4jpath = "log4j.properties";

	static {
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent=new ExtentReports(System.getProperty("user.dir")
				+"/src/main/java/com/durgasoft/ecommerce/htmlreports/test/"
				+dateFormat.format(cal.getTime())+".html",false);
	}
	
	@AfterMethod
	public void endReport(ITestResult result) {
		getResult(result);
	}

	public void getResult(ITestResult result2) {
		if (result2.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result2.getName() + " test is passed");
		} else if (result2.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result2.getName() + " test is skipped");
		} else if (result2.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result2.getName() + " test is failed");
		}
	}
	
	@BeforeMethod
	public void startReport(Method result) {
		test=extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName()+" test is started");
	}

	public String getData(String key) throws Exception {
		File f = new File(path);
		Properties p = new Properties();
		FileInputStream fi = new FileInputStream(f);
		p.load(fi);
		return p.getProperty(key);
	}

	public void browserLaunch(String browser, String url) {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\library\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "D:\\library\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		PropertyConfigurator.configure(log4jpath);
	}

	public void selectOption(WebElement element, int option) {
		Select s = new Select(element);
		s.selectByIndex(option);
	}
}
