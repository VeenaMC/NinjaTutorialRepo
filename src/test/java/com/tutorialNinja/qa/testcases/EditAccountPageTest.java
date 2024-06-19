package com.tutorialNinja.qa.testcases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
public class EditAccountPageTest extends BaseClass{
	
	Logger log = LogManager.getLogger(EditAccountPageTest.class);
	HomePage homepage;
	RegistrationPage registrationPage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	EditAccountPage editAccountPage;
	String sheetName = "Editprofile";
	
	public EditAccountPageTest() {
		super();
		log.info("User is in Edit account page");
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage=new HomePage();
		registrationPage = homepage.registerclk();
		loginPage= homepage.loginclk();
		myAccountPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		editAccountPage = myAccountPage.editAccountLnk();
	}
	
	@Test (priority = 1)
	public void editAccountPageTitleTest() {
		String title = editAccountPage.validateEditAccountPageTitle();
		Assert.assertEquals(title, "My Account Information");
	}
	
	@Test (priority = 2)
	public void editAccountPageHeadingTest() {
		boolean flag = editAccountPage.validateEditAccountHeading();
		Assert.assertTrue(flag);
	}
	
	@DataProvider
	public Object[][] getNinjaEditPrfTestData() {
		Object[][] profileData = UtilClass.getTestData(sheetName);
		return profileData;
	}
	
	
	@Test (priority = 3, dataProvider = "getNinjaEditPrfTestData")
	
	//sending the test data from config properties file.
	/*public void editAccountInfo() {
		myAccountPage = editAccountPage.editAccountInfo(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("emailaddress"), prop.getProperty("phone"));
	}*/
	
	//sending test data from excel file.
	public void editAccountInfo(String fname, String lname, String email, String telephone) {
		myAccountPage = editAccountPage.editAccountInfo(fname, lname, email, telephone);
		
	}
	
	@Test(priority = 4)
	public void logoutFromAccnt() throws InterruptedException {
		myAccountPage.logout();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
