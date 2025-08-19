package com.SwagLab.UITest.Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import com.SwagLab.UITest.Pages.*;

public class BaseClass 
{
	//BaseClass should consists of public variables + Annotations + Page class object
	public WebDriver driver;
	public P1_LoginPage lp; //this is coming from Pages package, so we have imported it.
	
	@BeforeTest
	public void setUp()
	{
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		lp=new P1_LoginPage(driver); //Now Pages and BaseClass are completely linked.Whatever BaseClass will do setup,same driver instance is passed to Pages.
	}
	

}