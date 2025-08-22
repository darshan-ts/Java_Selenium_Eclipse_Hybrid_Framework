package com.SwagLab.UITest.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import com.SwagLab.UITest.Base.BaseClass;

public class T3_CartTest extends BaseClass
{
	//prerequisite
	//user should be login and product should be available in cart and cart page should open
	@BeforeClass
	public void pageSet()
	{
		ip=lp.doLogin("standard_user","secret_sauce");
		ip=ip.addProductToCart("Sauce Labs Backpack");
		cp=ip.launchCartPage();
		
		
	}
	
  @Test(priority=1)
  public void verifyTotalProductsInCart() 
  {
	  cp.getProductDetailsAddedToCart();
  }
  
  @Test(priority=2)
  public void validateRemoveProduct()
  {
	  cp.removeProduct("Sauce Labs Backpack");
  }
  
  @Test(priority=3)
  public void validateContinueShopping()
  {
	  ip=cp.doContinueShopping();
	  ip.addProductToCart("Sauce Labs Fleece Jacket");
	  cp=ip.launchCartPage();
  }
  
  @Test(priority=4)
  public void validateContinueCheckOut()
  {
	  cp.doContinueCheckout();
  }
}