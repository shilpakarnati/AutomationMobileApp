package com.testbase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import org.testng.asserts.SoftAssert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
/*Written to create the android driver object, This class is extended in other classes to use the driver object
 * Using DesiredCapabilities we have mentioned the emulator/device parameters 
 * Also we loaded the object properties at run time 
 * Purpose: Loading properties file at run time and create an android driver object	
 * Pre-requisite: JRE System Library,Appium Client Jar and Selenium Jars, testNg jars, .apk file has 
 * 				   to copied to src folder,Or.properties file has to be created at src\com\config	
*/
public class BaseMobileappcode {
	
	public static Properties prop;
	public static FileInputStream fip;
	
	@BeforeMethod		
	public static AndroidDriver<AndroidElement>  Capabilities() throws MalformedURLException, FileNotFoundException{
		
		fip=new FileInputStream(".\\src\\com\\config\\Or.Properties");
		//st=new SoftAssert();
		prop=new Properties();
		try {
			prop.load(fip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
//	AndroidDriver<AndroidElement>  driver;

	// TODO Auto-generated method stub
		File appDir = new File("src");
	    File app = new File(appDir, "com.ebay.mobile_v5.17.0.18-117_Android-5.0.apk");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	     //Emulator name need to mentioned for Device Name
	     capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5 API 24");
	     //If real device is used we need to mention the device name as 'Android Device'
	    /*capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
	    capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.ebay.mobile");
	    capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.ebay.mobile.activities.MainActivity");*/
	     //to start emulator in script
	   //  capabilities.setCapability("avd","AndroidTestDevice");      
	     capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	     AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	  
	   return driver;
	}
/*	@BeforeClass
	//Appium server start up code
   public void startServer(){
	   
	   AppiumDriverLocalService sr=AppiumDriverLocalService.buildDefaultService();
	   sr.start();
   }*/

}
	


