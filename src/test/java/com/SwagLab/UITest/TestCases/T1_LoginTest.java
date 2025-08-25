package com.SwagLab.UITest.TestCases;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import com.SwagLab.UITest.Base.BaseClass;
import com.SwagLab.UITest.Utilities.Utility;

public class T1_LoginTest extends BaseClass
{
  @Test(priority=1)
  public void verifyUrl() 
  {
	  String actUrl=lp.getAppUrl();
	  //String expUrl="saucedemo.com"; //Before we used this hard-coded.Now it is replaced with below line.
	  String expUrl=prop.getData("homepageUrl"); //We are reading data from Config.properties file
	  //AssertJUnit.assertTrue(actUrl.contains(expUrl),"URL not matched!"); //As soon as we create XML file, Assert class gets changed to AssertJunit. We should revert to Assert again!
	  Assert.assertTrue(actUrl.contains(expUrl),"URL not matched!");
	  System.out.println("URL Matched!");
  }
  
  @Test(priority=2)
  public void verifyTitle() 
  {
	  String actTitle=lp.getAppTitle();
	  //String expTitle="Swag Labs"; //Before we used this hard-coded.Now it is replaced with below line.
	  String expTitle=prop.getData("homepageTitle"); //We are reading data from Config.properties file
	  //AssertJUnit.assertEquals(actTitle,expTitle,"Title not matched!"); //As soon as we create XML file, Assert class gets changed to AssertJunit. We should revert to Assert again!
	  Assert.assertEquals(actTitle,expTitle,"Title not matched!");
	  System.out.println("Title matched!"); //It is Hard assertion and we are keeping pass message in this next line
	  
  }
  
  @Test(priority=3)
  public void validateLoginFunctionality() 
  {
	  lp.setUserName("standard_user");
	  lp.setPassword("secret_sauce");  
	  lp.ClickOnLoginButton();
	  //Utility.getScreenshot(driver, "Swaglabs Home Page");
	  
	  //assertion
	  //AssertJUnit.assertTrue(lp.getAppUrl().contains("inventory.html"),"Login Fail!"); //As soon as we create XML file, Assert class gets changed to AssertJunit. We should revert to Assert again!
	  Assert.assertTrue(lp.getAppUrl().contains("inventory.html"),"Login Fail!");
	  System.out.println("Login Completed!");
	  
  }
}