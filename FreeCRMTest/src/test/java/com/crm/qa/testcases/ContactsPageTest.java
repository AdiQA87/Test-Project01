package com.crm.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.util.TestUtil;

public class ContactsPageTest extends TestBase {

	ContactsPage contactPg;
	LoginPage loginPg;
	HomePage HomePg;
	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPg = new LoginPage();		
		HomePg = loginPg.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPg = HomePg.clickOnContactsLink();
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider="getCRMTestData")
	public void createNewContact(String firstName, String LastName, String emailID, String emailIDType) throws InterruptedException{
		Thread.sleep(3000);
		contactPg.clickOnNewContactButton();
		contactPg.addContactDetails(firstName, LastName, emailID, emailIDType);
			
	}	
	

	@AfterMethod
	public void tearDown() {
	driver.close();
	}

}
