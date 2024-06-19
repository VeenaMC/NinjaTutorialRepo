package com.tutorialNinja.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialNinja.qa.base.BaseClass;

public class HomePage extends BaseClass {
	
	//create page factory or object repository
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myaccount;
	
	@FindBy(linkText = "Login")
	WebElement login;
	
	@FindBy(linkText = "Register")
	WebElement Register;
	
	//initializing the page objects
	public HomePage() {
			PageFactory.initElements(driver, this);
		}
	
	//Actions
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	

	public RegistrationPage registerclk () {
		myaccount.click();
		Register.click();
		
		return new RegistrationPage();
	}
	
	public LoginPage loginclk () {
		myaccount.click();
		login.click();
		
		return new LoginPage();
	}	
	
	public RegistrationPage Registerclk() {
		Register.click();
		return new RegistrationPage();
	}
}
