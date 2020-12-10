package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name="email")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password')]")
	WebElement forgotButton;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateForgotButtonLink(){
		return forgotButton.isDisplayed();
	}
	
	public ResetPage validateForgotPwdlinkFunctionality(){		
		forgotButton.click();
		return new ResetPage();
	}
	
	public Boolean validateSignUpButtonLink(){
		return signUpBtn.isDisplayed();
	}
	
	public SignUpPage validateSignUplinkFunctionality(){
		signUpBtn.click();
		return new SignUpPage();
	}
	
	
	public HomePage login(String un, String passwd){
		userName.sendKeys(un);
		pwd.sendKeys(passwd);
		loginButton.click();
		return new HomePage();
	}
		
	
		
	
}
