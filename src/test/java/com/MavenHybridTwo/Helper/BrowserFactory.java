package com.MavenHybridTwo.Helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserFactory {
	
	
	
	public static WebDriver startApplication(String browser)	{
		
	 	WebDriver driver = null ;
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.silentOutput","true"); 
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",  System.getProperty("user.dir")+ "/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		//driver.get(application);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		return driver;

	}
	
	
	public static WebDriver startApplicationHeadLess(String browser )
	{		
		WebDriver driver =null;
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.silentOutput","true"); 
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();	
			 ChromeOptions opt = new ChromeOptions();
			opt.setHeadless(true);			
			driver = new ChromeDriver(opt);
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",  System.getProperty("user.dir")+ "/Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	//	driver.get(application);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		return driver;

	}
	

}
