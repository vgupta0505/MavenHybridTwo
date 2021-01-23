package com.MavenHybridTwo.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties pro; // create a global variable
	public ConfigReader()// create a constructor when ever an object is created for ConfigReader class it will be invoked
	{
		pro = new Properties(); // create an object of properties class 
		try {
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+ "/Config/config.properties")));// now load the property file
		
		} catch (IOException e) {		
			System.out.println("Exception while reading the file " +e.getMessage());
			e.printStackTrace();
		} 
	}
	
	
	public String getValue(String key)
	
	{
		return  pro.getProperty(key);
	}

}
