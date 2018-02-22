package com.testbase;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/*When the user is trying to purchase an item for the first time it shows this, billing information activity page
 *Purpose : Enters data and completes billing address for the first time user 
 *Pre-Requisite: JRE System Library,Appium Client Jar and Selenium Jars, testNg jars
 * Methods in this class are passed objects from Or.Properties file 
 * we handled few of the gestures like scroll, press in this scenario. Could not implement TouchAction class as no functionality present w.r.t to this
*/
public class UpdateBillingInfo extends BaseMobileappcode {
	@Test
	public static void Billinginfo() throws MalformedURLException, FileNotFoundException {
		AndroidDriver<AndroidElement>  driver=Capabilities();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  
		//Clicking on Ok button on update information alert
		String updateinfok=prop.getProperty("updateinfok");
		 driver.findElementByXPath(updateinfok).click();
		 		  
		  //code to click on list to select a country
		 String countryid=prop.getProperty("countryid");
		  driver.findElementById(countryid).click();
		  //Country code selection code
		 //Scrolls until India is visible		  
		  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));");
		 
		  
		  //Select the radio button
		  String cntyradio=prop.getProperty("cntyradio");
		  driver.findElementByXPath(cntyradio).click();
		  
		  //Entering address
		  String addr=prop.getProperty("addr");
		  driver.findElementByXPath(addr).sendKeys("HSR Layout");
		  
		  //Entering apartment number
		  driver.findElementByXPath("//android.widget.EditText[@text='Apartment, suite, floor, etc. (optional)']").sendKeys("334");
		  //Entering city name
		  String city=prop.getProperty("city");		  
		  driver.findElementByXPath(city).sendKeys("Bangalore");
		  
		  //Entering state
		  String state=prop.getProperty("state");
		  driver.findElementById(state).click();
		  //to scroll until telangana is visible
		  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Telangana\"));");
		  //selecting Telangana
		  String stateT=prop.getProperty("stateT");		  
		  driver.findElementByXPath(stateT).click();
		  
		  //Entering Zip Code
		  String zipcode=prop.getProperty("zipcode");		  
		  driver.findElementByXPath(zipcode).sendKeys("560103");
		  
		  //Entering phone country code
		  String countycode=prop.getProperty("countycode");
		  driver.findElementById(countycode).click();
		  
		  //Selecting required code
		  String reqcode=prop.getProperty("reqcode");
		  driver.findElementByAndroidUIAutomator(reqcode).click();
		  
		  //Enter mobile number
		  String mobno=prop.getProperty("mobno");
		  driver.findElementByXPath(mobno).sendKeys("9544545622");
		  
		  //selecting terms and conditions
		  String tandcond=prop.getProperty("tandcond");
		  driver.findElementByXPath(tandcond).click();
		  
		  //Click on continue
		  String subbtn=prop.getProperty("subbtn");
		  driver.findElementById(subbtn).click();
		  
		  //buying options- alert handling
		  String buyingoptalert=prop.getProperty("buyingoptalert");
		  if(driver.findElementByXPath(buyingoptalert).isDisplayed()){
			  
			  //click on OK
			  String buyoptok=prop.getProperty("buyoptok");
			  driver.findElementByXPath(buyoptok).click();
			  
		  }
		/*  //Given here few methods which i cannot implement as part of the excercise but asked to handle
		// Few gestures like can be handled with below code
		  //Swipe can be done with below lines of code
		  TouchAction t=new TouchAction(driver);
		  t.press(driver.findElementByXPath("Object1")).waitAction(2000).moveTo(driver.findElementByXPath("Object2")).release().perform();
		  
		  //to get orientation of the emulator
		  driver.getOrientation();
		  //To handle screen size and resoltuions
		  driver.manage().window().getSize();
		  driver.manage().window().setSize(Dimension);
		  driver.manage().window().maximize();*/

	}

}
