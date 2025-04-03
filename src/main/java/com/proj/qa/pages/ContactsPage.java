package com.proj.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.proj.qa.base.TestBase;
import com.proj.qa.util.TestUtil;

public class ContactsPage extends TestBase {
	
	TestUtil testUtil = new TestUtil();	
	HomePage homePage = new HomePage();
	
	@FindBy(xpath="//span[text()='Contacts']/parent::div")
	WebElement contactPageLabel;
	
	@FindBy(xpath="//button[text()='Create']")
	WebElement createBtn;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='category' and @role='listbox']")
	WebElement categoryDD;	
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//span[text()='Contacts']/parent::a")
	WebElement contactIconLink;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactPageLabel() {
		return contactPageLabel.isDisplayed();
	}
	
	public void verifyContactPageCheckBoxes(String name) {		
		driver.findElement(By.xpath("//a[text()='"+name+"']/parent::td/preceding-sibling::td/div[@class]")).click();
	}
	
	public void createNewContact(String fname, String lname, String ddname) {
		createBtn.click();
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);		
		categoryDD.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicitTime));
		driver.findElement(By.xpath("//span[text()='"+ddname+"']")).click();	
		saveBtn.click();
		homePage.contactPageAccess();
		contactIconLink.click();
		testUtil.mouseMoveByOffset(TestUtil.xOffset, TestUtil.yOffset);
	}
}
