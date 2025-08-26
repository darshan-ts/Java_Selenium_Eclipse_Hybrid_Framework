package com.SwagLab.UITest.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import com.SwagLab.UITest.Base.BaseClass;
import com.SwagLab.UITest.Utilities.ExcelUtil;

public class T3_CartTest extends BaseClass
{
	//prerequisite
	//user should be login and product should be available in cart and cart page should open
	@BeforeClass
	public void pageSet()
	{
		//ip=lp.doLogin("standard_user","secret_sauce"); //Before we used this hard-coded.Now it is replaced with below line.
		ip=lp.doLogin(ExcelUtil.getStringData("UserData",0,1),ExcelUtil.getStringData("UserData",1,1)); //We are reading data from excel based on index
		//ip=ip.addProductToCart("Sauce Labs Backpack"); //Before we used this hard-coded.Now it is replaced with below lines.
		addWait();
		ip=ip.addProductToCart(prop.getData("pname1")); //We are reading data from Config.properties file
		addWait();
		cp=ip.launchCartPage();
		addWait();
		
		
	}
	
  @Test(priority=1)
  public void verifyTotalProductsInCart() 
  {
	  cp.getProductDetailsAddedToCart();
  }
  
  @Test(priority=2)
  public void validateRemoveProduct()
  {
	  //cp.removeProduct("Sauce Labs Backpack"); //Before we used this hard-coded.Now it is replaced with below line.
	  cp.removeProduct(prop.getData("pname1")); //We are reading data from Config.properties file
  }
  
  @Test(priority=3)
  public void validateContinueShopping()
  {
	  ip=cp.doContinueShopping();
	  //ip.addProductToCart("Sauce Labs Fleece Jacket"); //Before we used this hard-coded.Now it is replaced with below line.
	  ip.addProductToCart(prop.getData("pname2")); //We are reading data from Config.properties file
	  cp=ip.launchCartPage();
  }
  
  @Test(priority=4)
  public void validateContinueCheckOut()
  {
	  cp.doContinueCheckout();
  }
}