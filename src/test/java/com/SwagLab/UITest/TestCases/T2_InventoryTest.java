package com.SwagLab.UITest.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.SwagLab.UITest.Base.BaseClass;

public class T2_InventoryTest extends BaseClass
{
	//prerequisite:User must be login
	@BeforeClass
	public void pageSetup()
	{
		ip=lp.doLogin("standard_user","secret_sauce");
		
	}
	
  @Test(priority=1)
  public void verifyProductCount()
  {
	  int actCount=ip.getProductCount();
	  Assert.assertEquals(actCount,6);
	  System.out.println("Total Product count is matched: "+actCount);
  }
  
  @Test(priority=2)
  public void verifyProductDetails()
  {
	  ip.getProductDetails();
  }
  
  
  @Test(priority=3)
  public void validateAddToCart()
  {
	  ip.addProductToCart("Sauce Labs Bike Light");
  }
  
  
  @Test(priority=4)
  public void verifyCartPageLaunch() 
  {
	  ip.launchCartPage();
  }
}