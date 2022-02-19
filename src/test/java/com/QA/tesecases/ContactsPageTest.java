package com.QA.tesecases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.QA.Baseclass.TestBase;
import com.QA.Utlities.TestUtil;
import com.QA.pages.ContactsPage;
import com.QA.pages.HomePage;
import com.QA.pages.LoginPage;

public class ContactsPageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	TestUtil testUtil;
	ContactsPage contactPage;
	String sheetname="contacts";
	
	
	public ContactsPageTest()
	{
		super(); // in base class we are reading property file and we are calling base class constructor using super keyword. this will initialize Prop variable so that we will not get null pointer exception.
	}
	@BeforeMethod
	public void bfmethod()
	{
		System.out.println("Your method is started");
	}
	@BeforeTest
	public void setUp()
	{
		initialization();
		lp=new LoginPage();
		contactPage=new ContactsPage();
		testUtil=new TestUtil();
		hp=lp.LogIn(prop.getProperty("username"), prop.getProperty("password"));// LogIn method is returning Home page object
		testUtil.swithchToFrame();
		
	} 
	
	@Test(priority=1)
	public void verifyContactPageTest()
	{
		contactPage=hp.clicOnContactsLink();
		Assert.assertTrue(contactPage.verifyContactsLabel(), "Label not matching");
	}
	//@Test(priority=2)
	public void selectContact()
	{
		contactPage.selectContactByname("Anuja Lad");
		contactPage.selectContactByname("Harry ");
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() throws IOException
	{
		Object data[][]=testUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstname, String lastname, String company)
	{
		hp.clickOnNewContactLink();
		contactPage.createNewContact(title, firstname, lastname, company);
	}
		
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
	

}
