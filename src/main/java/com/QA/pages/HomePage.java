package com.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.Baseclass.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	@CacheLookup		//Cache look up is kind of memory which will store webelement NameLabel, so while executing
						//the framework next time instead of fetching the element from HTML dom it will fetch it from cache memory
						// and hence the speed of execution will be increased.
	WebElement nameLabel;
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contactLink;
	
	@FindBy(xpath="//a[text()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[text()='Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement newContactLink;
	
	public HomePage()
	{
		PageFactory.initElements(d, this); // Page factory initialization
	}
	
	public String verifyHomePageTitle()
	{
		return d.getTitle();
		
	}
	
	public ContactsPage clicOnContactsLink()
	{
		contactLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clicOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TaskPage clicOnTaskLink()
	{
		tasksLink.click();
		return new TaskPage();
	}
	
	public boolean verifyUserNameLabel()
	{
		return nameLabel.isDisplayed();
	}
	
	public void clickOnNewContactLink()
	{
		Actions action= new Actions(d);
		action.moveToElement(contactLink).build().perform();
		newContactLink.click();
		
	}
	
	

}
