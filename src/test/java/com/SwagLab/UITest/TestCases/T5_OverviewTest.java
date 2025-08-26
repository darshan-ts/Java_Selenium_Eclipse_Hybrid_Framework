package com.SwagLab.UITest.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.SwagLab.UITest.Base.BaseClass;
import com.SwagLab.UITest.Utilities.ExcelUtil;

public class T5_OverviewTest extends BaseClass 
{
	
	@BeforeClass
	public void pageSetup()
	{
		//ip=lp.doLogin("standard_user","secret_sauce"); //Before we used this hard-coded.Now it is replaced with below line.
		ip=lp.doLogin(ExcelUtil.getStringData("UserData",0,1),ExcelUtil.getStringData("UserData",1,1)); //We are reading data from excel based on index
		addWait();
		ip=ip.addProductToCart(prop.getData("pname2"));
		addWait();
		cp=ip.launchCartPage();
		addWait();
		ch=cp.doContinueCheckout();
		addWait();
		//op=ch.doContinueCheckout("Darshan","T S","411047"); //Before we used this hard-coded.Now it is replaced with below line.
		op=ch.doContinueCheckout(ExcelUtil.getStringData("UserData",2,1),ExcelUtil.getStringData("UserData",3,1),ExcelUtil.getStringData("UserData",4,1)); //We are reading data from excel based on index

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