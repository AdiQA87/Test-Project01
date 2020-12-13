package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	public static JavascriptExecutor jse;

	@FindBy(xpath="//*[contains(text(),'Log Out')]")
	WebElement logoutBtn;

	@FindBy(xpath="//*[@id='top-header-menu']//i[@class='settings icon']")
	WebElement logoutIcon;

	@FindBy(xpath="//*[contains(text(),'Aditya Gupta')]")
	WebElement userNameText;

	@FindBy(xpath ="//*[@id='main-nav']//i[@class='users icon']")
	WebElement contactIcon;

	public HomePage(){
		PageFactory.initElements(driver, this);		
	}

	public LoginPage verifyLogOutBtnFunctionality(){
		logoutIcon.click();
		logoutBtn.click();
		return new LoginPage();
	}

	public Boolean verifyUserNameText(){
		return userNameText.isDisplayed();
	}

	public ContactsPage clickOnContactsLink(){
		
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", contactIcon);
		return new ContactsPage();

	}


}


