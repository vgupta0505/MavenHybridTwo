package com.MavenHybridTwo.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MavenHybridTwo.DataProvider.XLUtils;
import com.MavenHybridTwo.Helper.BaseClass;
import com.MavenHybridTwo.PageObjects.LoginPage;

public class TC_LoginDDT_002 extends BaseClass {


	String path = System.getProperty("user.dir")+ "/testdata/Book4.xlsx";


	@Test ( dataProvider = "logindata")
	public void loginTest(String uname, String pwd ) throws InterruptedException
	{
		logger.info("** Starting the Login Test ***");
		LoginPage lg =	 PageFactory.initElements(driver, LoginPage.class);
		lg.loginintosite(uname, pwd);	
		Thread.sleep(5000);
//Assert.assertTrue(driver.getCurrentUrl().contains("admin"), " The Url is Not as expected") ;
		String exp_title="Dashboard / nopCommerce administration";
		String act_title= driver.getTitle();

		if(act_title.equalsIgnoreCase(exp_title)) {
			logger.info("****Login Test is Passed ****");
			lg.Logout();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			Assert.assertTrue(true);
		}

		 if(!act_title.equalsIgnoreCase(exp_title))
		{ 

			logger.warn("***Login test is failed***");
			Assert.assertTrue(false);               
		}



		//String exp_title="Dashboard / nopCommerce administration";
		//String act_title= driver.getTitle();
		//		if(exp_title.equalsIgnoreCase(act_title))
		//		{
		//			if(exp.equalsIgnoreCase("Pass"))
		//			{
		//				logger.info("****Login Test is Passed ****");
		//				lg.Logout();
		//				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//				Assert.assertTrue(true);
		//			}
		//			else if(exp.equalsIgnoreCase("Fail"))
		//			{
		//				logger.warn("**** Login test is Failed ***");
		//				lg.Logout();
		//				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//				Assert.assertTrue(false);
		//
		//			}
		//		}
		//		else if(!exp_title.equalsIgnoreCase(act_title))
		//		{ 
		//			if(exp.equalsIgnoreCase("Pass"))
		//			{
		//				logger.warn("***Login test is failed***");
		//				Assert.assertTrue(false);               
		//			}
		//
		//			else if( exp.equalsIgnoreCase("Fail"))
		//			{
		//				logger.warn("***Login test is Passed***");
		//				Assert.assertTrue(true);   
		//			}
	}



	@DataProvider ( name ="logindata")	
	public Object[][] getData() throws IOException
	{ 

		XLUtils excel = new XLUtils();
		int rowct=	excel.getRowCount(path, "Login");
		int colct =	  excel.getCellCount(path, "Login", 1);

		Object data[][] = new Object[rowct][colct];	

		for(int r = 1; r<rowct ; r++)
		{
			for(int c = 0 ; c< colct ; c++)
			{
				data[r-1][c] = excel.getCellData(path, "Login" , r , c);
			}
		}			
		return data;		


	}	





}
