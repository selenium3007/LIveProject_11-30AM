package com.durgasoft.ecommerce.homapage;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.durgasoft.ecommerce.basepage.BasePage;
import com.durgasoft.ecommerce.pageUI.PRegistration;

public class TC001_CustomerRegistration extends BasePage {
	
	public static final Logger log=Logger.getLogger(TC001_CustomerRegistration.class.getName());

	@Test(priority=0)
	public void hmsPR() throws Exception {
		//System.out.println("*******Starting TC001_CustomerRegistration***********");
		log.info("*******Starting TC001_CustomerRegistration***********");
		PRegistration pr = new PRegistration(driver);
		pr.hmsLogin();
		pr.verifyRegistration();
		pr.verifyPR();
		log.info("*******End of TC001_CustomerRegistration***********");
		//System.out.println("*******End of TC001_CustomerRegistration***********");
	}
	
	
	@BeforeClass
	public void beforeTest() throws Exception {
		browserLaunch(getData("browser"), getData("url"));
	}
	
	@AfterClass
	public void endTest() {
		closeBrowser();
	}

	public void closeBrowser() {
		driver.quit();
		extent.endTest(test);
		extent.flush();
		
	}
}





