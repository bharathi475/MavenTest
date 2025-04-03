package com.proj.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.proj.qa.base.TestBase;

public class LoginPage extends TestBase {	
	
	//Page Factory - Object Repository(OR):
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;
	
	//Login Page Constructor:
	public LoginPage() {
		//initializing page objects/web elements:
		PageFactory.initElements(driver, this); //instead of this, also we can give the current class - LoginPage.class
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();		
		return new HomePage();
	}

}
