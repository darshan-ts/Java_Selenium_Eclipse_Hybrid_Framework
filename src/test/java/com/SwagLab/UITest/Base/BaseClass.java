package com.SwagLab.UITest.Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import com.SwagLab.UITest.Pages.*;
import com.SwagLab.UITest.Utilities.BrowserProvider;
import com.SwagLab.UITest.Utilities.PropertiesUtil;

public class BaseClass 
{
	//BaseClass should consists of public variables + Annotations + Page class object
	public WebDriver driver;
	public P1_LoginPage lp; //this is coming from Pages package, so we have imported it.
	public P2_InventoryPage ip;
	public P3_CartPage cp;
	public P4_CheckoutPage ch;
	public P5_OverviewPage op;
	public PropertiesUtil prop;
	
	//@BeforeTest-Before it was @BeforeTest annotation. Now we changed it to @BeforeClass
	@BeforeClass
	@Parameters({"bname"})
	public void setUp(String bname)
	{
		prop=new PropertiesUtil("Config");
		driver=BrowserProvider.setDriver(bname); //This is coming from BrowserProvider Utility.ThreadLocal is class in java used to design one thread through out all the test case/pages.
		//driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://www.saucedemo.com/"); //Before we used this hard-coded URL.Now it is replaced with below line.
		driver.get(prop.getData("url")); //We are reading data from Config.properties file
		lp=new P1_LoginPage(driver); //Now Pages and BaseClass are completely linked.Whatever BaseClass will do setup,same driver instance is passed to Pages.
		ip=new P2_InventoryPage(driver); //Now Pages and BaseClass are completely linked.Whatever BaseClass will do setup,same driver instance is passed to Pages.
		cp=new P3_CartPage(driver); //Now Pages and BaseClass are completely linked.Whatever BaseClass will do setup,same driver instance is passed to Pages.
		ch=new P4_CheckoutPage(driver); //Now Pages and BaseClass are completely linked.Whatever BaseClass will do setup,same driver instance is passed to Pages.
		op=new  P5_OverviewPage(driver); //Now Pages and BaseClass are completely linked.Whatever BaseClass will do setup,same driver instance is passed to Pages.
	}
	
	@AfterMethod
	public void waitForTest()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void addWait()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	  public void tearDown()
	  {
		//close browser
		  driver.quit();
	  }
	
}