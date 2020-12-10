package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;

public class SignUpPageTest extends TestBase{
	
	LoginPage loginPg;
	SignUpPage signUpPg;
	HomePage homePg;
	
	
	public SignUpPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPg = new LoginPage();
		signUpPg = loginPg.validateSignUplinkFunctionality();		
	}
	
	@Test(priority=1)
	public void validateHeaderOfSignUpPageTest(){
		Assert.assertTrue(signUpPg.validateHeaderOfSignUpPage());
	}
	
	@Test(priority=2)
	public void gotAnAccountLinkFunctionalityTest(){
		homePg = signUpPg.gotAnAccountLinkFunctionality();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
