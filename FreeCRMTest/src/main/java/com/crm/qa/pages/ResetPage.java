package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ResetPage extends TestBase {

	@FindBy(xpath ="//*[text()='Forgot my password']")
	WebElement forgotMyPwdHeader;
		
	public ResetPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyResetPageTitle(){
		return driver.getTitle();
	}
	
	public Boolean verifyForgotMyPwdHeader(){
		return forgotMyPwdHeader.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
}