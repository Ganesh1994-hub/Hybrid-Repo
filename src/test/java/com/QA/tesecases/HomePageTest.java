package com.QA.tesecases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.QA.Baseclass.TestBase;
import com.QA.Utlities.TestUtil;
import com.QA.pages.ContactsPage;
import com.QA.pages.HomePage;
import com.QA.pages.LoginPage;

public class HomePageTest extends TestBase{

	// Test cases should be independent with each other
	// Before every test case launch browser
	//Execute test case
	// after every test case close the browser
	LoginPage lp;
	HomePage hp;
	TestUtil testUtil;
	ContactsPage contactPage;
	
	public HomePageTest()
	{ 
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		lp=new LoginPage();
		contactPage=new ContactsPage();
		testUtil=new TestUtil();
		hp=lp.LogIn(prop.getProperty("username"), prop.getProperty("password"));// LogIn method is returning Home page object
		
	} 
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homepagetitle=hp.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO", "Home Page Title is not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		testUtil.swithchToFrame();
		boolean val=hp.verifyUserNameLabel();
		Assert.assertTrue(val);
		
	}
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		testUtil.swithchToFrame();
		contactPage=hp.clicOnContactsLink();
	}
	
	
	@AfterMethod
	public void tearDown()	
	{
		d.quit();
	}
	
}
