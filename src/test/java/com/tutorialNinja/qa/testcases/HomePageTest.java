package com.tutorialNinja.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tutorialNinja.qa.base.BaseClass;
import com.tutorialNinja.qa.pages.HomePage;
import com.tutorialNinja.qa.pages.LoginPage;
import com.tutorialNinja.qa.pages.RegistrationPage;

import TestNGListener.CustomListener;

@Listeners(CustomListener.class)
public class HomePageTest extends BaseClass{
	
	Logger log = LogManager.getLogger(HomePageTest.class);
	HomePage homepage;
	LoginPage loginPage;
	RegistrationPage registerPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage=new HomePage();
		log.info("Opened Ninja website");
	}
	
	@Test (priority = 1)
	public void homePageTitleTest() {
		String title = homepage.validateHomePageTitle();
		Assert.assertEquals(title, "Your Store");
	}
	
	@Test (priority = 2)
	public void registerPageNavigationTest() {
		registerPage = homepage.registerclk();
		
	}
	
	@Test (priority = 3)
	public void loginPageNavigationTest() {
		loginPage = homepage.loginclk();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
