package com.proj.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.proj.qa.base.TestBase;
import com.proj.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	TestUtil testUtil = new TestUtil();
	
	@FindBy(xpath="//span[text()='Bharathi kannan']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//i[@class='home icon']")
	WebElement homeIconLink;
	
	@FindBy(xpath="//span[text()='Contacts']/parent::a")
	WebElement contactIconLink;
	
	@FindBy(xpath="//span[text()='Contacts']/parent::div")
	WebElement contactPageLabel;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyUserNameLabel() {
		return userNameLabel.getText();
	}
	
	public ContactsPage contactPageAccess() {
		testUtil.hoverAndMoveToElement(homeIconLink, contactIconLink);
		return new ContactsPage();
	}
}
