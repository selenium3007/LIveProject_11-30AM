package com.durgasoft.selenium.java.hybrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageUI {
	
	@FindBy(linkText="HMS") WebElement linkHMS;
	@FindBy(name="username") WebElement txtUserName;
	@FindBy(name="password") WebElement txtPassword;
	@FindBy(name="submit") WebElement btnLogin;
	@FindBy(linkText="Logout") WebElement linkLogout;
	
	public PageUI(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void hmsLogin() {
		linkHMS.click();
		txtUserName.sendKeys("admin");
		txtPassword.sendKeys("admin");
		btnLogin.click();
	}
	
	public void hmsLogout() {
		linkLogout.click();
	}
	

}
