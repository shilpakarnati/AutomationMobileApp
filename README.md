# AutomationMobileApp
Pre-requisite:
1. Eclipse need to be installed.
2. Need to add all the required Jars such as JRE system library,Selenium jars,Appium client jars and testNG library.
3.Appium server should be started.
4.Using android studio manager, need to create an emulator and should start this emulator before test tun.
5.Create a project and add configuration of the project,testdata parameterization and automation code.
6.download .apk file of ebay applicaiton to src folder
7. environment variables have to be set properly.
8.ShineXls reader jars to be added to work with excel

Used software:
1. Eclipse IDE used: Mars.2 Release (4.5.2)
2. JRE system library - Java SE -1.8
3. Selenium jars :Selenium 3.4
4.appium jars:java-client-4.1.2.jar
5. testNg: testNg for eclipse
6. Appium: Appium v1.7.2
7.Emulator : Nexus 5 API 24
8.Android studio : V 3.0.1

Src folder:
This is having a 3 subfolders handling configuration of the project, test data parameterization and automation code to achieve the test case
to test the AUT. These are respectivily config,excelfiles and test base.
In config I have placed all the required ebay application properties in Or.properties file.
In excelfiles, I have given test data to run the registration of multiple users in DataPool.xlsx
In testbase, I have written the entire logic to achieve the test case.
This is having BaseMobileappcode.java,DataDrivenTest.java,NewUserRegistration.java,PurchaseItem.java,UpdateBillingInfo.java

BaseMobileappcode.java : Implemented the code logic to initialize the app using android driver by giving desired capabilities and also 
implemented the Or.properties file loading at run time.
DataDrivenTest.java: Implemented the code to read the DataPool.xslx file and call registration method using parameters 
in NewUserRegistration class.
NewUserRegistration.java: New user registration logic is implemented with parameterization.
PurchaseItem.java: Purchasing an Item in ebay appp logic implemented.
UpdateBillingInfo.java : For the first time users, while purchasing it prompts to enter billing information. This logic iplemented to show
the various gestures like press,swipte,scroll can be achieved using the andriod driver object.

test out put:
Though, I have implemented the code logic for purchase item,new user registration,update billing information, I have just included only
PurchaseItem class in testNg suite. 
The reason for not keeping other class UpdateBillingInfo in TestSuite is that this feature is enabled only for the first time user. Need to
do some manual setups every time by removing billing info before we start test.
The reason for not keeping other class new user registration is that it is throwing some captcha while running. First time when I wrote code
it was not showing. but later it was prompting to enter captcha text. So unable to include this too in test suite.

Only PurchaseItem class added in test suite and ran as testNg suite. But do to a fucntional bug I couldnot run the steps after login.
It is showing "Too many requests" prompt. Hence my TestNg.html is failed with "Capabilities [{app=C:\Users\shgarlap.ORADEV\workspace\MobileappTestingMine\src\com.ebay.mobile_v5.17.0.18-117_Android-5.0.apk, appPackage=com.ebay.mobile, deviceScreenSize=1080x1920, networkConnectionEnabled=true, warnings={}, appWaitPackage=com.ebay.mobile, appWaitActivity=com.ebay.mobile.activities.MainActivity, databaseEnabled=false, deviceName=emulator-5554, platform=LINUX, deviceUDID=emulator-5554, appActivity=com.ebay.mobile.activities.MainActivity, desired={app=C:\Users\shgarlap.ORADEV\workspace\MobileappTestingMine\src\com.ebay.mobile_v5.17.0.18-117_Android-5.0.apk, platformName=Android, deviceName=Nexus 5 API 24}, platformVersion=7.0, webStorageEnabled=false, locationContextEnabled=false, takesScreenshot=true, javascriptEnabled=true, deviceModel=Android SDK built for x86, platformName=Android, deviceManufacturer=unknown}]
Session ID: 3862b27e-600b-43b5-86e4-2446c2165b9f
*** Element info: {Using=xpath, value=//android.widget.Button[@text='NO THANKS']}" which is a next step after login.

While implementing the code logic I did not face this issue, hence the code was tested properly. Later faced this  issue, so we can see 
one failure in report.
