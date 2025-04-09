package com.proj.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.proj.qa.base.TestBase;
import com.proj.qa.pages.HomePage;
import com.proj.qa.pages.LoginPage;
import com.proj.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Step("TC_HP_001")
	@Description("Verify Home Page Title")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, TestUtil.homePageTitle);
	}
	
	@Step("TC_HP_002")
	@Description("Verify Home Page Label")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void verifyUserNameLabelTest() {
		String unLabel = homePage.verifyUserNameLabel();
		Assert.assertEquals(unLabel, TestUtil.userNameLabel);
	}
	
	@Step("TC_HP_003")
	@Description("Verify User can access Contacts Page")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=3)
	public void contactPageAccessTest() {
		homePage.contactPageAccess();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	


}
