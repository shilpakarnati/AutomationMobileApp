package com.testbase;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class PurchaseItem extends BaseMobileappcode {
	
	/* 
	 *Purpose : ITem purchase in ebay will be carried in this class, Need to specify this class name testng.xml to run this
	 *Pre-Requisite: JRE System Library,Appium Client Jar and Selenium Jars, testNg jars
	 * Methods in this class are passed objects from Or.Properties file and test data from DataPool.xlsx
	*/
	@Test
	public void  itemPurchase() throws MalformedURLException, FileNotFoundException{
		AndroidDriver<AndroidElement>  driver=Capabilities();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  //To identify objects we rely only on xpath(is an address to an element to identify the object), id, class name and androidUIAutomator
		  /*   //tagname[@attribute='value']-->syntax for xpath, class name serves as tagname
		    
		   */
		 String logoimg=prop.getProperty("logoimg");
		  //Clciking on image beside Ebay
		  driver.findElementByXPath(logoimg).click();
		  
		  //Clicking on Sign In
		  String signimg=prop.getProperty("signimg");
		  driver.findElementById(signimg).click();
		  //Entering Username 
		  String uname=prop.getProperty("uname");		  		  
		  driver.findElementById(uname).sendKeys("testwiprodemo@gmail.com");
		  
		  //enter password field
		  //String pwd=prop.getProperty("pwd");
		  driver.findElementById("edit_text_password").sendKeys("purposedemo12$");
		  
		  //Click on sign in button
		  String signinbtn=prop.getProperty("signinbtn");
		  driver.findElementById(signinbtn).click();
		  
		  //handling an alert
		  String nothanks=prop.getProperty("nothanks");		  
		  if((driver.findElementByXPath(nothanks)).isDisplayed()){
			  
			  driver.findElementByXPath(nothanks).click();
		  }
			 
		 //Entering an Item(autoIT) in Search for anything text field	
		  String searchB=prop.getProperty("searchB");
		 driver.findElementByXPath(searchB).sendKeys("Mobiles");
		 //Press on enter to get search results
		 driver.pressKeyCode(AndroidKeyCode.ENTER);
		 
		  //Clicking on required item
		 String itemlink=prop.getProperty("itemlink");
		  driver.findElementsByClassName(itemlink).get(1).click();
		  
		  
		  //Clicking on Buy IT Now button
		  String buyit=prop.getProperty("buyit");
		  driver.findElementByXPath(buyit).click();
		  

		  //Updating billing information
		  String billinginfo=prop.getProperty("billinginfo");
		  if(driver.findElementByXPath(billinginfo).isDisplayed()){
			  UpdateBillingInfo updatebilling=new UpdateBillingInfo();
			  UpdateBillingInfo.Billinginfo();
		  }
		
	/*	  //Without entering new address, user clicks on Done
		  String donebtn=prop.getProperty("donebtn");
		  driver.findElementByXPath(donebtn).click();
		  	
		  
		  //Handling Logout
		  String logoutbtn=prop.getProperty("logoutbtn");
		  driver.findElementByXPath(logoutbtn).click();*/
		  
		  //clicking on Signout
		  String signout=prop.getProperty("signout");
		  driver.findElementByXPath(signout).click();
		  
		  //Alert handling while signing out
		  String sgnoutalert=prop.getProperty("sgnoutalert");
		  if (driver.findElementByXPath(sgnoutalert).isDisplayed()){
			  String sgnoutalertok=prop.getProperty("sgnoutalertok");
			  driver.findElementByXPath(sgnoutalertok).click();
			  
		  }
		  		  
		
	}
	

	}
	


