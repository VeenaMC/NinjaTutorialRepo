package com.tutorialNinja.qa.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialNinja.qa.base.BaseClass;
import com.tutorialNinja.qa.util.UtilClass;

public class MyAccountPage extends BaseClass {
	
	//create page factory or object repository
	@FindBy (xpath = "//h2[normalize-space()='My Account']")
	WebElement myAccountHeading;
	
	@FindBy (xpath = "//a[normalize-space()='Edit Account']")
	WebElement editAccountLink;
	
	@FindBy (linkText = "Logout")
	WebElement logout;
	
	//initializing the page objects
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateMyAccountPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateMyAccountHeading() {
		return myAccountHeading.isDisplayed();
	}
	
	public EditAccountPage editAccountLnk () {
		editAccountLink.click();
		return new EditAccountPage();
	}	
	
	public void logout() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		logout.click();
		Thread.sleep(9000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UtilClass.IMPLICIT_WAIT));
	}

}
