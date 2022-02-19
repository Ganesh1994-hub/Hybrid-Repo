package com.QA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.QA.Baseclass.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement fname;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement surname;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
			
	public ContactsPage()
	{
		PageFactory.initElements(d, this);  // initializing the locater declared above or Page objects(IQ: How you will initialize the Page factory)
	}
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactByname(String name)
	{
		d.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title, String ftname, String ltname, String comp)
	{
		Select select=new Select(d.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(title);
		fname.sendKeys(ftname);
		surname.sendKeys(ltname);
		company.sendKeys(comp);
		saveBtn.click();
	}
}
