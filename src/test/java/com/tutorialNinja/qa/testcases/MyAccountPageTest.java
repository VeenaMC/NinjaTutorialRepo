package com.tutorialNinja.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tutorialNinja.qa.base.BaseClass;
import com.tutorialNinja.qa.pages.EditAccountPage;
import com.tutorialNinja.qa.pages.HomePage;
import com.tutorialNinja.qa.pages.LoginPage;
import com.tutorialNinja.qa.pages.MyAccountPage;
import com.tutorialNinja.qa.pages.RegistrationPage;
import com.tutorialNinja.qa.util.UtilClass;

import TestNGListener.CustomListener;

@Listeners(CustomListener.class)
public class MyAccountPageTest extends BaseClass {
	
	HomePage homepage;
	RegistrationPage registrationPage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	EditAccountPage editAccountPage;
	UtilClass frame;
	
	public MyAccountPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage=new HomePage();
		registrationPage = homepage.registerclk();
		loginPage= homepage.loginclk();
		myAccountPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority = 1)
	public void myAccountPageTitleTest() {
		String title = myAccountPage.validateMyAccountPageTitle();
		//frame.switchToFrame();
		Assert.assertEquals(title, "My Account");
	}
	
	@Test (priority = 2)
	public void myAccountPageHeadingTest() {
		boolean flag = myAccountPage.validateMyAccountHeading();
		Assert.assertTrue(flag);
	}
	
	@Test (priority = 3)
	public void editAccountPage() {
		editAccountPage = myAccountPage.editAccountLnk();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
