package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	LoginPage loginPg;
	HomePage homePg;


	@BeforeMethod
	public void setUp(){
		initialization();
		loginPg = new LoginPage();
		homePg = loginPg.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority=1)
	public void verifyUserNameTextTest(){
		Assert.assertTrue(homePg.verifyUserNameText());
	}

	@Test(priority=2)
	public void verifyLogOutBtnFunctionalityTest(){
		homePg.verifyLogOutBtnFunctionality();

	}

	@Test(priority=3)
	public void clickOnContactsLinkTest(){
		homePg.clickOnContactsLink();
	}

	@AfterMethod
	public void tearDown(){		
		driver.quit();		
	}




}
