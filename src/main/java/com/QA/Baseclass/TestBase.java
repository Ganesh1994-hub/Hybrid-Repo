package com.QA.Baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.QA.Utlities.TestUtil;
import com.QA.Utlities.WebEventListener;

public class TestBase {

	public static WebDriver d;
	public static Properties prop;
	public static EventFiringWebDriver e_driver; //reference variable of class EventFiringWebDriver
	public static WebEventListener eventListener;
	
	public TestBase()  //Constructor of the base class
	{
	
	try{
		prop= new Properties();
		FileInputStream fis = new FileInputStream("D:\\workspace_working\\HybridFramework\\src\\main\\java\\com\\QA\\config\\config.properties");
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e1)
		{
			e1.printStackTrace();
		}
		
	}
	
	
	public static void initialization()
	{
		
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver_win32\\chromedriver.exe");
			d=new ChromeDriver();   //This is initializing the global variable 'd'so that d can be used anywhere as it is global variable. it can be used in all child classes as well as in base class
					
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver-v0.29.0-win64\\geckodriver.exe");
			d=new FirefoxDriver();
		}
		else {
			
			System.out.println("you have not given any browser name in config.properties file");
		}
		
		e_driver= new EventFiringWebDriver(d);
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		d=e_driver;
		
		d.manage().window().maximize();
		d.manage().deleteAllCookies();

		//Use of desired capabilities
		d.get(prop.getProperty("url"));
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				
	}
	
	public static void waitMethod(String ele)
	{
		  @SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(d,30);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ele)));     
	      
	}
	
	
	
	
}

	
	


	


