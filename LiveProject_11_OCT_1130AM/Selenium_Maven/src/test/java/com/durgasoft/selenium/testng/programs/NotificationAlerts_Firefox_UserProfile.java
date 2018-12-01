package com.durgasoft.selenium.testng.programs;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

public class NotificationAlerts_Firefox_UserProfile {
	public WebDriver driver;

	@Test
	public void f() {

	}

	/*
	 * @BeforeTest public void beforeTest() { ProfilesIni p = new ProfilesIni();
	 * FirefoxProfile myProfile = p.getProfile("selenium");
	 * myProfile.setPreference("dom.webnotifications.enable", false); driver=new
	 * FirefoxDriver(myProfile); driver.get("http://icicibank.com");
	 * driver.manage().window().maximize(); }
	 */
	@BeforeTest
	public void beforeTest() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissions.default.desktop-notifications", 1);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		driver = new FirefoxDriver(capabilities);
		driver.get("http://icicibank.com");
		driver.manage().window().maximize();
	}
}
