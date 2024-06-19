package com.tutorialNinja.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tutorialNinja.qa.base.BaseClass;
import com.tutorialNinja.qa.pages.AccountLogoutPage;
import com.tutorialNinja.qa.pages.HomePage;
import com.tutorialNinja.qa.pages.RegistrationPage;
import com.tutorialNinja.qa.util.UtilClass;

import TestNGListener.CustomListener;

@Listeners(CustomListener.class)
public class RegistrationPageTest extends BaseClass{
	HomePage homepage;
	RegistrationPage registrationPage;
	AccountLogoutPage accountCreatedPage;
	String sheetName = "Registration";
	
	public RegistrationPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage=new HomePage();
		registrationPage = homepage.registerclk();
	}
	
	@Test (priority = 1)
	public void registerPageTitleTest() {
		String title = registrationPage.validateRegisterPageTitle();
		Assert.assertEquals(title, "Register Account");
	}
	
	@DataProvider
	public Object[][] getNinjaTestData() {
		Object[][] registerData = UtilClass.getTestData(sheetName);
		return registerData;
	}
	
	@Test(priority =2, dataProvider = "getNinjaTestData")
	public void validateCreateNewAccnt(String firstname, String lastname, String email, String telephone, String password, String conPassword) {
		registrationPage.createNewAccount(firstname, lastname, email, telephone, password, conPassword);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
