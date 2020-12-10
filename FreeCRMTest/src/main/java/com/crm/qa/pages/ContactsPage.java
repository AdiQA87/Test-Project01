package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	
	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/a/button[@class='ui linkedin button']")
	@CacheLookup
	WebElement newContactBtn;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']")
	WebElement compName;
	
	@FindBy(xpath="//div[label[contains(text(),'Email')]]//input")
	WebElement emailIdTextBox;
	
	@FindBy(xpath="//div[label[contains(text(),'Email')]]//input[@name='name']")
	WebElement emailIdType;
	
	@FindBy(xpath="//i[@class='save icon']")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnNewContactButton() {
		newContactBtn.click();
	}
	
	public void addContactDetails(String fstName, String lstName,String emailId,String mailIdType) {
		firstName.sendKeys(fstName);
		lastName.sendKeys(lstName);
		emailIdTextBox.sendKeys(emailId);
		emailIdType.sendKeys(mailIdType);						
		saveBtn.click();
		
	}
	

}
