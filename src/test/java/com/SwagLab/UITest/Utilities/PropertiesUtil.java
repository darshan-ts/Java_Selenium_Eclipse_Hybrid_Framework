package com.SwagLab.UITest.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class PropertiesUtil
{
	
	public Properties p1;
	//file should be loaded
	public PropertiesUtil(String fileName)
	{
		//create object of Properties class
		  p1=new Properties();
		
		//read data from file we need path
		  File f1=new File(System.getProperty("user.dir")+"//ConfigData//"+fileName+".properties");
		  
		  //read a file in stream: FileInputStream
		  FileInputStream fs;
		try {
			fs = new FileInputStream(f1);
			 //load the file
			  p1.load(fs);
		} catch (FileNotFoundException e) {

			System.out.println("File path is wrong!");
		} catch (IOException e) {

			System.out.println("Properties file not loaded!");
		}
		  	  
		 
		  
	}
	
	
	//file reading
	public String getData(String key)
	{
		return p1.getProperty(key);
	}
	

}