package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPg;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPg = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String titleValue = loginPg.validateLoginPageTitle();
		Assert.assertEquals(titleValue, "Cogmento CRM");
	}
	
	@Test (priority=2)
	public void loginButtonFunctionalityTest(){
		loginPg.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority=3)
	public void checkForgotButtonLinkTest(){
		Assert.assertTrue(loginPg.validateForgotButtonLink());
	}
	
	@Test(priority=4)
	public void ForgotButtonFunctionalityTest(){
		loginPg.validateForgotPwdlinkFunctionality();
	}
	
	@Test(priority=5)
	public void validateSignUpButtonLinkTest(){
		Assert.assertTrue(loginPg.validateSignUpButtonLink());
	}
	
	@Test(priority=6)
	public void validateSignUplinkFunctionalityTest(){
		loginPg.validateSignUplinkFunctionality();
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
