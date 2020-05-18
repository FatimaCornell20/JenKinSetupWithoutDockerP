package com.qa.hubspot.testdata;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.util.AppConstants;
import com.qa.hubspot.util.Credentials;


public class LoginPageTest {
	BasePage basePage; //2.initialize the base-page reference so the base-page could be available through class,then create its obj
	Properties prop;//5.create the properties reference as well
	LoginPage loginPage;//6. create the login-page reference first and then call it by the reference 
	WebDriver driver; //6. because browsername gives webdriver below #10 
	Credentials userCred; //12.first create its reference 

	@BeforeTest
	public void setUp() {
	//1.first thing to do in setup:launch the browser, which its method is in base page:init_driver 
	//3. create the obj of base-page and 4. call int properties first 
	basePage =new BasePage();
	prop=basePage.init_properties();//from base-page //its return type is prop
	String browserName=prop.getProperty("browser");//its return type is a string 
	driver=basePage.init_driver(browserName);//return type WebDriver 
	driver.get(prop.getProperty("url"));
	//7. creating the obj of login-page and should pass the driver 
	
	loginPage= new LoginPage(driver);
	//13.after creating its reference#12 then create the obj of Credential class here and pass its credential
	//use prop.getprop only once here as u used below #10
	userCred=new Credentials(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest()  {
	//Thread.sleep(5000);// this only for execution purpose //showing the page-title takes time 
	//8.how to get the driver:from loginPage by creating its reference#6 and #7calling its obj
    
	//14 
	String title=loginPage.getPageTitle();	
     System.out.println("login page title is: "+title);
// instead of this use the generic method created in AppConstants:Assert.assertEquals(title, "HubSpot Login");
     Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);

	}
	//9
	@Test(priority=2)
	public void verifySignUpLinkTest() {
	Assert.assertTrue(loginPage.checkSignUpLink());	
	}
	
	//10
	@Test(priority=3)
	public void loginTest() {
	//14. remove the getprop as we have our generic method of userCred	
	//	HomePage homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));//get username and pass from prop by prop.setprop...

	HomePage homePage=loginPage.doLogin(userCred);
	String accountName=homePage.getLoggedInUUserAccountName();
//to remove the hardcoded of cornell we add accountname in config file and by prop. call it
//Assert.assertEquals(accountName, "Cornell University");
	
	Assert.assertEquals(accountName, prop.getProperty("accountname"));

	}
	
	//15. use @dataprovider to provide invalid data 
	@DataProvider
	public Object[][] getLoginInvalidData() {//use different scenarios for entring username and pass
	Object data[][]= { {"test1@gmail.com","test133"} , 
						{"test1@gmail.com",""} ,
						{"","test133"} ,
						{"","test133"} ,
						{"test@gmail.com",""} ,
						{"",""}
						}; 
	return data; 
	}
	//16 provide dependency of test with data-provider equal is to the method name 
	@Test(priority=4, dataProvider="getLoginInvalidData", enabled=false)
	//16 important to provide the param String username and pass otherwise it wont work 
	public void login_InvalidTestCases(String username, String pwd) {
	userCred.setAppUsername(username);
	userCred.getAppPassword(pwd);
	
	// can remove homepage homepage now from this as it is unnecessary reference variable:not using it  
	//HomePage homePage=loginPage.doLogin(userCred);
	loginPage.doLogin(userCred);

	//17 to create assertion for this we need to create a method in loginPage#13 
	Assert.assertTrue(loginPage.checkloginErrorMessg());
	
	
	}
	
//11.how to create a negative test:pass the wrong credentials for user-name and password 
//	@Test(priority=4)
//	public void LoginTest_WrongCredentials() {
//	HomePage homePage=loginPage.doLogin("test123@gmail.com", "test1234");//give the wrong username and password..
//	String accountName=homePage.getLoggedInUUserAccountName();
//	Assert.assertEquals(accountName, "Cornell University");
//     }
//	
//8
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
	
	
	
	
}
