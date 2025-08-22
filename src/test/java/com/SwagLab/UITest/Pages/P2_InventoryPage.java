package com.SwagLab.UITest.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P2_InventoryPage 
{
	
	private WebDriver driver;
	
	public P2_InventoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	//locators
	@FindBy(xpath="//div//div[@class='inventory_item_name ']")
	private List<WebElement> products;
	
	@FindBy(id="add-to-cart")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement cartOption;
	
	
	//actions
	public int getProductCount()
	{
		return products.size();
	}

	public P2_InventoryPage getProductDetails()
	{
		System.out.println("***Product details are***");
		for(WebElement i:products)
		{
			System.out.println(i.getText());
//			if(i.getText().contains(pname))
//			{
//				System.out.println("Product Found!");
//				break;
//			}else
//			{
//				System.out.println("Product not found!");
//			}
		}
		
		//return pname;
		return this;
	}
	
	
	public P2_InventoryPage addProductToCart(String pname)
	{
		for(WebElement i:products)
		{
			if(i.getText().contains(pname))
			{
				
				//click on product
				i.click();//page will open
				System.out.println("Product found: "+pname);
				break;
			}
		}
		
		//click on addToCart button
		addToCartBtn.click();
		return this;
		
		
	}
	
	public P3_CartPage launchCartPage()
	{
		cartOption.click();
		//navigate to cart page
		return new P3_CartPage(driver); //page navigates to next page then return next page object.Here we need to pass driver to resolve error. Before it was empty! 
	}
}