package com.durgasoft.ecommerce.pageUI;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.durgasoft.ecommerce.basepage.BasePage;

public class PRegistration extends BasePage {
	
	public static final Logger log=Logger.getLogger(PRegistration.class.getName());

	@FindBy(linkText = "HMS") WebElement linkHMS;
	@FindBy(name = "username") WebElement txtUserName;
	@FindBy(name = "password") WebElement txtPassword;
	@FindBy(name = "submit") WebElement btnSubmit;
	@FindBy(linkText="Logout") WebElement linkLogout;
	@FindBy(linkText="Registration") WebElement linkRegistration;
	@FindBy(linkText="Perminent Registration") WebElement linkPR;
	@FindBy(name="PATIENT_CAT") WebElement dropDownPatientCat;
	@FindBy(name="RELATION") WebElement dropDownRelation;
	@FindBy(name="TITLE") WebElement dropDownTitle;
	@FindBy(name="PNT_NAME") WebElement txtFirstName;
	@FindBy(name="PAT_IDENTITY") WebElement dropDownPatientID;
	@FindBy(name="LAST_NAME") WebElement txtLastName;
	
	public PRegistration(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void hmsLogin() throws Exception {
		linkHMS.click();
		log.info("Clicked on HMS link with the object:"+linkHMS.toString());
		txtUserName.sendKeys(getData("username"));
		log.info("Entered User Name is:"+txtUserName.getAttribute("value")+" using object"+txtUserName.toString());
		txtPassword.sendKeys(getData("password"));
		log.info("Entered Password is:"+txtPassword.getAttribute("value")+" using object"+txtPassword.toString());
		btnSubmit.click();
		log.info("Clicked on submit button with the object:"+btnSubmit.toString());
		assertEquals(linkLogout.getText(), "Logout");
		log.info("Verify customer registration page by using object:"+linkLogout.toString());
	}
	
	public void verifyRegistration() {
		linkRegistration.click();
		linkPR.click();
	}
	
	public void verifyPR() {
		selectOption(dropDownPatientCat,1);
		selectOption(dropDownRelation, 1);
		selectOption(dropDownTitle, 1);
		txtFirstName.sendKeys("Mahesh");
		selectOption(dropDownPatientID, 1);
		txtLastName.sendKeys("D");
		
	}

}