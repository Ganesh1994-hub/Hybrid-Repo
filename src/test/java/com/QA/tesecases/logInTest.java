package com.QA.tesecases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.QA.Baseclass.TestBase;
import com.QA.pages.HomePage;
import com.QA.pages.LoginPage;

public class logInTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	
	public logInTest()
	{
		super(); // in base class we are reading property file and we are calling base class constructor using super keyword. this will initialize Prop variable so that we will not get null pointer exception.
	}
	
	//TestBase tb=new TestBase();
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		 lp=new LoginPage();
	}
	
	@Test(threadPoolSize = 3, invocationCount = 6)
	public void LoginPageTitleTest()
	{
		String title=lp.validateTheloginpageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		System.out.println("title is "+title);
	}
	
	//@Test
	public void crmLogoImageTest()
	{
		boolean flag=lp.logoImage();
		Assert.assertTrue(flag);
		
    }
	
	//@Test
	public void loginPageTest()
	{
		hp=lp.LogIn(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
		public void tearDown()
		{
			d.quit();
		}
		
	

}
