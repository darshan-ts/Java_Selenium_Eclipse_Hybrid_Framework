package com.SwagLab.UITest.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P3_CartPage
{
	
	private WebDriver driver;
	
	public P3_CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//locators
	@FindBy(xpath="//div[@class='cart_list']//div[@class='inventory_item_name']")
	private List<WebElement> allCartProducts;
	
	@FindBy(xpath="//button[text()='Remove']")
	private WebElement removeBtn;
	
	@FindBy(id="continue-shopping")
	WebElement continueShoppingBtn;
	
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	
	//methods
	
	public P3_CartPage getProductDetailsAddedToCart()
	{
		int count=allCartProducts.size();
		
		System.out.println("Total Products added inti Cart: "+count);
		for(WebElement i:allCartProducts)
		{
			System.out.println(i.getText());
		}
		
		return this;
		
	}
	
	public P3_CartPage removeProduct(String name)
	{
		
		for(WebElement i:allCartProducts)
		{
			
			if(i.getText().contains(name))
			{
				removeBtn.click();
			}
			
		}
		return this;
	}
	
	public P2_InventoryPage doContinueShopping()
	{
		continueShoppingBtn.click();
		return new P2_InventoryPage(driver);
	}
	
	public P4_CheckoutPage doContinueCheckout()
	{
		checkoutBtn.click();
		return new P4_CheckoutPage();
	}
	
	
	
	
	
	
	
	
	

}