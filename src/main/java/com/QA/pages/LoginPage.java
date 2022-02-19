package com.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.Baseclass.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory or Object Repository 
	@FindBy(css="input[name='username']")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(css="input[value='Login']")
	WebElement submit;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signup;
	
	@FindBy(css="img[src*='classic.freecrm'][class='img-responsive']")
	WebElement image;
	
	public LoginPage()
	{
		PageFactory.initElements(d, this);  // initializing the locater declared above or Page objects(IQ: How you will initialize the Page factory)
	}
	
	public String validateTheloginpageTitle()
	{
		return d.getTitle();
	}
	
	public boolean logoImage()
	{
		return image.isDisplayed();
	}
	
	public HomePage LogIn(String un, String pw)
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		submit.click();
		
		return new HomePage();
	}
}
