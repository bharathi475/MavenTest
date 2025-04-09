package com.proj.qa.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.proj.qa.base.TestBase;
import com.proj.qa.pages.ContactsPage;
import com.proj.qa.pages.HomePage;
import com.proj.qa.pages.LoginPage;
import com.proj.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class ContactsPageTest extends TestBase {
	
	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	String sheetName = "Contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = new ContactsPage();
		contactsPage = homePage.contactPageAccess();
		testUtil.mouseMoveByOffset(TestUtil.xOffset, TestUtil.yOffset);
	}
	
	@Step("TC_CP_001")
	@Description("Verify Contacts Page Label")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void verifyContactPageLabelTest() {
		contactsPage.verifyContactPageLabel();
		Assert.assertTrue(contactsPage.verifyContactPageLabel(), "Contacts Page Label is not displayed");
	}
	
	@Step("TC_CP_002")
	@Description("Verify Contacts Page Check Boxes")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void verifyContactPageCheckBoxesTest() {
		contactsPage.verifyContactPageCheckBoxes(TestUtil.contactName1);
		contactsPage.verifyContactPageCheckBoxes(TestUtil.contactName2);
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Step("TC_CP_003")
	@Description("Verify User can create a new Contact")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=3, dataProvider="getCRMTestData")
	public void createNewContactTest(String ftName, String ltName, String ctgy) throws IOException {
		testUtil.takeScreenshots();
		contactsPage.createNewContact(ftName, ltName, ctgy);
		testUtil.takeScreenshots();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
