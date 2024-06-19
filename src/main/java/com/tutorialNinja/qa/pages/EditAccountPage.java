package com.tutorialNinja.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialNinja.qa.base.BaseClass;

public class EditAccountPage extends BaseClass{
	
	//create page factory or object repository
	
	@FindBy (xpath = "//h1[normalize-space()='My Account Information']")
	WebElement pageheading;
	
	@FindBy (name = "firstname")
	WebElement firstname;
	
	@FindBy (name = "lastname")
	WebElement lastname;
	
	@FindBy(name = "email")
	WebElement emailAddress;
	
	@FindBy(name = "telephone")
	WebElement telephoneNumber;
	
	@FindBy(xpath = "//input[@value = 'Continue']")
	WebElement continuebtn;
	
	@FindBy(linkText = "Back")
	WebElement backbtn;
	
	//initializing the page objects
	public EditAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateEditAccountPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateEditAccountHeading() {
		return pageheading.isDisplayed();
	}
	
	public MyAccountPage editAccountInfo (String fn, String ln, String em, String telphn) {
		firstname.clear();
		firstname.sendKeys(fn);
		
		lastname.clear();
		lastname.sendKeys(ln);
		
		emailAddress.clear();
		emailAddress.sendKeys(em);
		
		telephoneNumber.clear();
		telephoneNumber.sendKeys(telphn);
		
		continuebtn.click();
		return new MyAccountPage();
	}	
}
