package com.tutorialNinja.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialNinja.qa.base.BaseClass;

public class LoginPage extends BaseClass {
	//create page factory or object repository
	
	@FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
	WebElement loginheading;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(linkText = "Forgotten Password")
	WebElement forgotpwdlnk;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;
	
	//initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLoginHeading() {
		return loginheading.isDisplayed();
	}
	
	public MyAccountPage login (String em , String pwd ) {
		email.sendKeys(em);
		password.sendKeys(pwd);
		loginbtn.click();
		
		return new MyAccountPage();
	}
}
