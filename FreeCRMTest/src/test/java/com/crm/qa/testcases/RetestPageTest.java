package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ResetPage;

public class RetestPageTest extends TestBase {
	
	LoginPage loginPg;
	ResetPage resetPg;
	
	public RetestPageTest(){
		super();
	}

	@BeforeMethod
	public void setup(){
		initialization();
		loginPg = new LoginPage();
		resetPg = loginPg.validateForgotPwdlinkFunctionality();		
	}
	
	@Test (priority=1)
	public void verifyPwdResetPageTitleTest(){
		String PwdTitle = resetPg.verifyResetPageTitle();
		Assert.assertEquals(PwdTitle, "Cogmento CRM","Reset password page title not matched");
	 }
	@Test(priority=2)
	public void verifyForgotMyPwdHeaderTest(){
		Assert.assertTrue(resetPg.verifyForgotMyPwdHeader());
	}
	 
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
	
}
