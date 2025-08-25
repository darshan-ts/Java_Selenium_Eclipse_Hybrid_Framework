package com.SwagLab.UITest.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P5_OverviewPage 
{
	
	private WebDriver driver;
	
	public P5_OverviewPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='summary_info']//div[contains(@class,'summary')]")
	private List<WebElement> paymentDetails;//8
	
	@FindBy(id="finish")
	private WebElement finishBtn;
	
	@FindBy(xpath="//h2")
	private WebElement resultMsg;
	
	
	//actions
	
	public P5_OverviewPage getPaymentDetails()
	{
		System.out.println("----payment details are-----");
		
		for(WebElement i:paymentDetails)
		{
			System.out.println(i.getText());
		}
		
		return this;
	}
	
	public String doFinishCheckout()
	{
		finishBtn.click();
		
		return resultMsg.getText();
		
	}
	
	
	
	
	

}