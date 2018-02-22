package com.testbase;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import xls.ShineXlsReader;

/*To run the new registration with multiple data we are using this DataDrivenTest
 *Purpose : It fetches data data from Datapool.xlsx and pass the data to registration method 
 *Pre-Requisite: JRE System Library,Appium Client Jar and Selenium Jars, testNg jars,ShineXLS.jar
 * Methods in this class are passed objects from Or.Properties file and test data from DataPool.xlsx
*/
public class DataDrivenTest {
	
	@Test (dataProvider="getdata")
	public void testcase123(String firstName,String lastName,String Mail,String Password
			,String countryList,String enterAddress,String apartment, String city,String state,
			String pincode,String mobilenumber) throws Throwable{
		
	NewUserRegistration reg=new NewUserRegistration();
	reg.registration(firstName, lastName, Mail, Password, countryList, enterAddress, apartment, city, state, pincode, mobilenumber);

		
		
	}

	@DataProvider
    public Object[][] getdata(){
        ShineXlsReader xls=new ShineXlsReader(".\\src\\com\\excelFiles\\DataPool.xlsx");
        int rcount = xls.getRowCount("Test1");
        int ccount = xls.getColumnCount("Test1");
        Object obj[][]=new Object[rcount-1][ccount];
        for(int i=2;i<=rcount;i++){
            for( int j=0;j<ccount;j++){
                obj[i-2][j]=xls.getCellData("Test1", j, i);
            }
        }
        
        return obj;
    }


	}


