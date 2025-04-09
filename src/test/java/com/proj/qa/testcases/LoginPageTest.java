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

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super(); //super keyword is used to access the super class (TestBase class) constructor. 
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Step("TC_LP_001")
	@Description("Verify Login Page Title")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, TestUtil.loginPageTitle);
	}
	
	@Step("TC_LP_002")
	@Description("Verify Login Functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=2)
	public void loginFunctionalityTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
