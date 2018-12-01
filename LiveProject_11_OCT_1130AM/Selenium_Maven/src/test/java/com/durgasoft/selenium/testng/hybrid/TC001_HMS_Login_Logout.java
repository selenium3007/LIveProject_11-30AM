package com.durgasoft.selenium.testng.hybrid;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.durgasoft.selenium.java.hybrid.BasePage;
import com.durgasoft.selenium.java.hybrid.PageUI;

import atu.testrecorder.ATUTestRecorder;
	
public class TC001_HMS_Login_Logout extends BasePage {

	public ATUTestRecorder recorder;
	
	@Test(description="This test case is to verify Login & Logout in HMS")
	public void hmsLogin_Logout() throws Exception {
		PageUI page = new PageUI(driver);
		page.hmsLogin();
		page.hmsLogout();
		recorder.stop();
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		recorder=new ATUTestRecorder("D:\\recording", "HMSLogin", false);
		recorder.start();
		browserLaunch("firefox", "http://seleniumbymahesh.com");

	}

}
