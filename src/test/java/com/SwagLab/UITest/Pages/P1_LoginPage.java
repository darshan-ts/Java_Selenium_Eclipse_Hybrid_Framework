package com.SwagLab.UITest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P1_LoginPage 
{
	//Encapsulation=Private data + public method
	
	private WebDriver driver; //this is instance variable
	
	//constructor:used to initialize current class object(Here it is WebDriver driver object). Constructor should always be declared as public.
	public P1_LoginPage(WebDriver driver) //reading driver from base class
	{
		this.driver=driver; //Here we called instance variable with the help of "this" keyword and assigned "driver" coming from base class to current class object(that is instance variable).
		//to initialize elements identified by @FindBy annotation
		PageFactory.initElements(driver,this); // passing current driver and current class object(this).
	}
	
	//locator
	@FindBy(id="user-name") //inside @FindBy annotation pass our locator strategy
	private WebElement usernameEle; //Every @FindBy annotation returns separate WebElement
	
	@FindBy(id="password")
	private WebElement passwordEle; //Every locator we should write with respect to private only.Data should be private and it is called as Encapsulation.For security reason we need to maintain each and every page object and every data as private data.
	
	@FindBy(id="login-button")
	private WebElement loginBtn;
	
	//actions/method
	
	public String getAppUrl()
	{
		return driver.getCurrentUrl(); //We wanted to reuse this particular return type or CurrentUrl for further validation. Whenever it comes to framework, it is always best practice to return something from every method.If any method is there and which is not returning anything, do return current class object. It will maintain stability for the application under test.  
	} 
	
	public String getAppTitle()
	{
		return driver.getTitle();
	}
	
	public P1_LoginPage setUserName(String un)
	{
		
		usernameEle.sendKeys(un);
		return this; // this points to current class object(P1_LoginPage) and we are not navigating to any new page. We are returning everything because there should be sequential flow and link between the pages which helps us to automate an entire application.
	}
	
	
	public P1_LoginPage setPassword(String psw)
	{
		passwordEle.sendKeys(psw);
		return this; // this points to current class object(P1_LoginPage) and we are not navigating to any new page. We are returning everything because there should be sequential flow and link between the pages which helps us to automate an entire application.
	}
	
	public P2_InventoryPage ClickOnLoginButton()
	{
		loginBtn.click();
		//page navigates to next page then return next page object
		return new P2_InventoryPage();
	}
	
	
	
	
	

}