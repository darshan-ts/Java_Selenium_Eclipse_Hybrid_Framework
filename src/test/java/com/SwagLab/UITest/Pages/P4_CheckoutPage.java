package com.SwagLab.UITest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P4_CheckoutPage
{
	private WebDriver driver;
	
	public  P4_CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//locators
	@FindBy(id="first-name")
	private WebElement fname;
	
	
	@FindBy(id="last-name")
	private WebElement lname;
	
	@FindBy(id="postal-code")
	private WebElement postalcode;
	
	@FindBy(id="continue")
	private WebElement contBtn;
	
	//actions
	
	public P5_OverviewPage doContinueCheckout(String fn,String ln,String pc)
	{
		fname.sendKeys(fn);
		lname.sendKeys(ln);
		postalcode.sendKeys(pc);
		System.out.println("First name : "+fn+", lastname is: "+ln+", postal code is: "+pc);
		contBtn.click();
		return new P5_OverviewPage(driver); //page navigates to next page then return next page object.Here we need to pass driver to resolve error. Before it was empty!
		
	}
	
}