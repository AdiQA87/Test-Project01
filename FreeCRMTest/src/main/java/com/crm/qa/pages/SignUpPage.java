package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class SignUpPage extends TestBase{
	
@FindBy(xpath="//*[contains(text(),'Register')]")
WebElement signUpHeader;

@FindBy(xpath="//a[contains(text(),'Got an account?')]")
WebElement gotAnAccountLink;

public SignUpPage(){
	PageFactory.initElements(driver, this);
}

public Boolean validateHeaderOfSignUpPage(){
	return signUpHeader.isDisplayed();
}
	
public HomePage gotAnAccountLinkFunctionality(){
	gotAnAccountLink.click();
	return new HomePage();
}


}
