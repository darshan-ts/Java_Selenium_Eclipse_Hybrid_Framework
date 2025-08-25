package com.SwagLab.UITest.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.SwagLab.UITest.Base.BaseClass;

public class T4_CheckoutTest extends BaseClass
{
	@BeforeClass
	public void pageSetup()
	{
		ip=lp.doLogin("standard_user","secret_sauce");
		addWait();
		ip=ip.addProductToCart(prop.getData("pname2"));
		addWait();
		cp=ip.launchCartPage();
		addWait();
		ch=cp.doContinueCheckout();
		
	}
	
	
  @Test
  public void validateCheckout()
  {
	  
	  ch.doContinueCheckout("Darshan","T S","560000");
  }
}