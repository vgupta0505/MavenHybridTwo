package com.MavenHybridTwo.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.MavenHybridTwo.DataProvider.ConfigReader;
import com.MavenHybridTwo.Helper.BaseClass;
import com.MavenHybridTwo.Helper.Utility;
import com.MavenHybridTwo.PageObjects.LoginPage;

public class TC_Login_01 extends BaseClass{

	@Test
	public void  loginTest()
	{
		ConfigReader con = new ConfigReader();
		logger.info("***The application is started****" );
		LoginPage lg =  PageFactory.initElements(driver, LoginPage.class);

		lg.loginintosite(con.getValue("useremail"), con.getValue("password"));

		logger.info("*** user is Logged in  the application");
		boolean status =  Utility.waitFOrURL(driver,"admin");
		if(status == true ) { 
			logger.info("** login is sucessful");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("** login is NOT sucessful");
			Utility.captureScreeShot(driver);
			Assert.assertTrue(false);
		}

		lg.Logout();

		logger.info("*** user is Logged out of the  application");


	}

}
