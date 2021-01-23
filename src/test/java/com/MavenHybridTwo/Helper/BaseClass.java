package com.MavenHybridTwo.Helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.MavenHybridTwo.DataProvider.ConfigReader;



public class BaseClass {	
 
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(this.getClass()); //Log4j2	
    ConfigReader con = new ConfigReader();

	@BeforeClass	
	@Parameters("Browser")
	public void setup(String browser)  {
		
		logger.info("Starting the browser");     
		System.out.println("Test is getting executed by "+Thread.currentThread().getName() + "_"+Thread.currentThread().getId());
		driver = BrowserFactory.startApplication(browser);
		driver.get(con.getValue("baseURL"));
		System.out.println("Log info: Browser and Application is up and running");
		
//			System.setProperty("webdriver.chrome.silentOutput","true"); 
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//	  driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(con.getValue("baseURL"));
		//driver.get(new ConfigReader().getValue("baseURL"));
		
	}



	@AfterClass
	public void tearDown() {
		driver.quit();
		System.out.println("Log info: Browser and Application is closed");

	}
	
	

}
