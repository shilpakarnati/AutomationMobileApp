package com.testbase;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class NewUserRegistration extends BaseMobileappcode{
	/* 
	 *Purpose : User Registration in ebay will be carried in this class, Need to specify this class name testng.xml to run this
	 *Pre-Requisite: JRE System Library,Appium Client Jar and Selenium Jars, testNg jars
	 * Methods in this class are passed objects from Or.Properties file and test data from DataPool.xlsx
	*/
	//@Test
	public void registration(String firstName, String lastName, String mail, String password, String countryList,
			String enterAddress, String apartment, String city, String state, String pincode, String mobilenumber) throws MalformedURLException, FileNotFoundException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement>  driver=Capabilities();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  //Enter first name
		  String regfname=prop.getProperty("regfname");
		  driver.findElementByXPath(regfname).sendKeys(firstName);
		  //Enter last name
		  String reglname=prop.getProperty("reglname");
		  driver.findElementByXPath(reglname).sendKeys(lastName);
		  //Enter email
		  String regemail=prop.getProperty("regemail");		  
		  driver.findElementByXPath(regemail).sendKeys(mail);
		 
		  //Enter password
		  String pwd=prop.getProperty("pwd");
		  driver.findElementByXPath(pwd).sendKeys(password);
		  
		  //Submit button
		  String regsubtn=prop.getProperty("regsubtn");
		  driver.findElementByXPath("//android.widget.Button[@resource-id='ppaFormSbtBtn']").click();

		
	}
	


}
