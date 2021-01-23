package com.MavenHybridTwo.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.MavenHybridTwo.DataProvider.ConfigReader;
import com.MavenHybridTwo.Helper.Utility;

public class LoginPage {	


	WebDriver driver ;

	@FindBy(id="Email")
	@CacheLookup
	WebElement textEmail;

	@FindBy(id="Password")
	@CacheLookup
	WebElement textPwd ;

	@FindBy (xpath ="//input[@value='Log in']")
	@CacheLookup
	WebElement loginBt ;

	@FindBy (linkText ="Logout")
	@CacheLookup
	WebElement lnkLogOut;


	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public void loginintosite(String uname , String pwd)

	{
		ConfigReader con = new ConfigReader();
		Utility.waitforWebElementandClear(driver, textEmail, "Clear the email input box");
		Utility.waitforWebElementandClear(driver, textPwd, " clear the pwd input box");
		Utility.waitforWebElementandType(driver, textEmail, uname, "Enter the Email");
		Utility.waitforWebElementandType(driver, textPwd, pwd, " Enter the password");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Utility.waitforWebElementandClick(driver, loginBt, " click on login");	
		
	}

	public void Logout()
	{
		Utility.waitforWebElementandClick(driver, lnkLogOut, " Clik on the logout tab");
	}






}
