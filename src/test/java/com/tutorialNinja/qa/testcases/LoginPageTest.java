package com.tutorialNinja.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tutorialNinja.qa.base.BaseClass;
import com.tutorialNinja.qa.pages.HomePage;
import com.tutorialNinja.qa.pages.LoginPage;
import com.tutorialNinja.qa.pages.MyAccountPage;
import com.tutorialNinja.qa.pages.RegistrationPage;

import TestNGListener.CustomListener;

@Listeners(CustomListener.class)
public class LoginPageTest extends BaseClass{
	
	HomePage homepage;
	RegistrationPage registrationPage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	
	public LoginPageTest() {
		super();
	}
	
	//test cases should be separated - independent with each other
	//BeforeMethod - before each test case, launch the browser and login
	//@test - execute test case
	//AfterMethod - after each test case, close the browser
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage=new HomePage();
		registrationPage = homepage.registerclk();
		loginPage= homepage.loginclk();
		
	}
	
	@Test (priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Account Login");
	}
	
	@Test (priority = 2)
	public void loginPageHeadingTest() {
		boolean flag = loginPage.validateLoginHeading();
		Assert.assertTrue(flag);
	}
	
	@Test (priority = 3)
	public void loginTest() {
		myAccountPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
