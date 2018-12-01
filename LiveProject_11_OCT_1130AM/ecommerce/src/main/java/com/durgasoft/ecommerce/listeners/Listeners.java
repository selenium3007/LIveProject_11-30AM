package com.durgasoft.ecommerce.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.durgasoft.ecommerce.basepage.BasePage;

public class Listeners extends BasePage implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		Reporter.log("Test is Failed: "+arg0.getMethod().getMethodName());
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat simpleDate=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName=arg0.getName();
		
		if(!arg0.isSuccess())
		{
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String reportDirectory=(new File(System.getProperty("user.dir")).getAbsolutePath()
			+"/src/main/java/com/durgasoft/ecommerce");
		File targetPath = new File((String)reportDirectory+"/failededscreens/"+methodName
				+" "+simpleDate.format(cal.getTime())+".png");
		try {
			FileUtils.copyFile(sourcePath, targetPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("<a href='"+targetPath.getAbsolutePath()+"'>"
		+"<img src='"+targetPath.getAbsolutePath()+"'height='100'width='100'/></a>");
		
		}
	}


	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		Reporter.log("Test Skipped: "+arg0.getMethod().getMethodName());
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		Reporter.log("Test Running: "+arg0.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		Reporter.log("Test Success: "+arg0.getMethod().getMethodName());
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat simpleDate=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName=arg0.getName();
		
		if(arg0.isSuccess())
		{
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String reportDirectory=(new File(System.getProperty("user.dir")).getAbsolutePath()
			+"/src/main/java/com/durgasoft/ecommerce");
		File targetPath = new File((String)reportDirectory+"/passedscreens/"+methodName
				+" "+simpleDate.format(cal.getTime())+".png");
		try {
			FileUtils.copyFile(sourcePath, targetPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("<a href='"+targetPath.getAbsolutePath()+"'>"
		+"<img src='"+targetPath.getAbsolutePath()+"'height='100'width='100'/></a>");
		
		}
		
	}
}