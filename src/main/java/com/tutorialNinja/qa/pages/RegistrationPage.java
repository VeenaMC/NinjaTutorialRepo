package com.tutorialNinja.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialNinja.qa.base.BaseClass;

public class RegistrationPage extends BaseClass {
	
	//create page factory or object repository
	@FindBy (xpath = "//h1[normalize-space()='Register Account']")
	WebElement registerPageHeading;
	
	@FindBy (name = "firstname")
	WebElement firstname;
	
	@FindBy (name = "lastname")
	WebElement lastname;
	
	@FindBy (name = "email")
	WebElement email;

	@FindBy (name = "telephone")
	WebElement telephone;
	
	@FindBy (name = "password")
	WebElement password;
	
	@FindBy (name = "confirm")
	WebElement confirm;
	
	@FindBy(name = "agree")
	WebElement privacyCheckbox;
	
	@FindBy (xpath = "//input[@value='Continue']")
	WebElement submitbtn;
	
	//initializing the page objects
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateRegisterPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateRegisterPageHeading() {
		return registerPageHeading.isDisplayed();
	}
	
	public void createNewAccount(String fname, String lname, String emailaddress, String phone, String pwd, String cpwd) {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		email.sendKeys(emailaddress);
		telephone.sendKeys(phone);
		password.sendKeys(pwd);
		confirm.sendKeys(cpwd);
		
		privacyCheckbox.click();
		submitbtn.click();
	}
	
	public String validateCurrentRegisterPageTitle() {
		return driver.getTitle();
	}
}
