package com.SwagLab.UITest.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.SwagLab.UITest.Base.BaseClass;

public class T5_OverviewTest extends BaseClass 
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
		addWait();
		op=ch.doContinueCheckout("Darshan","T S","411047");
	}
	
  @Test(priority=1)
  public void verifyPayment()
  {
	  op.getPaymentDetails();
  }
  
  
  @Test(priority=2)
  public void validateChekout()
  {
	  String actMsg=op.doFinishCheckout();
	  String expMsg="Thank you for your order!";
	  Assert.assertEquals(actMsg,expMsg);
	  System.out.println("Process Completed!");
  }
}