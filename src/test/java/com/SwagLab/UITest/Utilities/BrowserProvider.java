package com.SwagLab.UITest.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserProvider 
{
	/*
	 * ThreadLocal is class in java used to design one thread through out all the test case/pages.
	 *It has only 2 Methods:
	 *-------
	 *get()
	 *set()
	 */
	
	public static WebDriver driver;
	
	public static ThreadLocal<WebDriver> tdriver=new ThreadLocal<WebDriver>();
	
	public static WebDriver setDriver(String bname)
	{
		switch(bname)
		{
		
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
			
		}
		
		tdriver.set(driver);
		return getDriver();
		
	}
	
	public static WebDriver getDriver()
	{
		return tdriver.get();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}