package com.MavenHybridTwo.Helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	public static void waitforWebElementandType( WebDriver driver ,WebElement element , String textTobeTyped, String info) 	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textTobeTyped);
		System.out.println("LOG INFO:" + info);
	}


	public static void waitforWebElementandClick( WebDriver driver ,WebElement element , String info) 	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		System.out.println("LOG INFO:" + info);
	}
		

	public static void waitforWebElementandClear( WebDriver driver ,WebElement element , String info) 	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
		System.out.println("LOG INFO:" + info);
	}
	
	
	

	public static WebElement waitForWebElement(WebDriver driver,By locator,String logInfo)
	{
		WebElement element=new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(locator));
		System.out.println("LOG:INFO-"+logInfo);
		return element;
	}

	public static boolean waitFOrURL(WebDriver driver , String keyword)
	
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));		
		boolean status =  wait.until(ExpectedConditions.urlContains(keyword));				
		return status;		
	}
	
public static boolean waitFOrrTitle(WebDriver driver , String keyword)
	
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));		
		boolean status =  wait.until(ExpectedConditions.titleContains(keyword))	;	
		return status;		
	}
	

	public static String getCurrentTime()// this method we will use with screen shot and report as well
	{
		SimpleDateFormat myFormat = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");	     
		Date date = new Date();//fetch the current date
		return myFormat.format(date); // so we have the above current date which we want o format in this pattern     
	}	


	public static void captureScreeShot(WebDriver driver ) {  

		TakesScreenshot ts  = (TakesScreenshot)driver;
		File source =  ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+ "\\screenshots\\" + getCurrentTime()+ ".png";
		try {
			FileHandler.copy(source, new File(path));
			System.out.println("screenshot was captured");
		} catch (IOException e) {

			System.out.println("Screenshot could not be captured" + e.getMessage());

		}   
	}
}
