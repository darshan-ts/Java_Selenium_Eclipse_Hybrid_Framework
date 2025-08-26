package com.SwagLab.UITest.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.SwagLab.UITest.Base.BaseClass;
import com.SwagLab.UITest.Utilities.ExcelUtil;

public class T4_CheckoutTest extends BaseClass
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
		
	}
	
	
  @Test
  public void validateCheckout()
  {
	  
	  //ch.doContinueCheckout("Darshan","T S","560000"); //Before we used this hard-coded.Now it is replaced with below line.
	  ch.doContinueCheckout(ExcelUtil.getStringData("UserData",2,1),ExcelUtil.getStringData("UserData",3,1),ExcelUtil.getStringData("UserData",4,1)); //We are reading data from excel based on index
	  addWait();
  }
}