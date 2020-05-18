package com.qa.hubspot.testdata;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.util.AppConstants;
import com.qa.hubspot.util.Credentials;
//1.copy these two methods from login test to here @beforetest and @aftertest 
public class HomePageTest {

	BasePage basePage;  
	Properties prop;
	LoginPage loginPage;
	WebDriver driver; 
	HomePage homePage;
	//4 give the reference of credentials class here as well and import it then create its obj#5
	Credentials userCred; 

	@BeforeTest
	public void setUp()   {
	 
	basePage =new BasePage();
	prop=basePage.init_properties();
	String browserName=prop.getProperty("browser");
	driver=basePage.init_driver(browserName);
	driver.get(prop.getProperty("url"));
	loginPage= new LoginPage(driver);	
	//2.by loginpage we can do login and using prop.getprop
	//3.loginpage return is homepage so create its reference above#4 and store it inside homepage reference 
	//5 creating obj of credentials class 
	userCred=new Credentials(prop.getProperty("username"), prop.getProperty("password"));
	//6 instead of line blow write the next one 
	//homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	homePage=loginPage.doLogin(userCred);
	//note:why creating line above:to get homepage class obj reference so can call all methods of homepage
	//Thread.sleep(5000);//for time being 
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
	String title=homePage.getHomePagetitle();
	System.out.println("home page tilte is : "+title);
	//use the created in app-constants to call the generic method 
	Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyHomeHeaderTest() {
	String header=homePage.getHomePageHeader(); 
	System.out.println("home page header is : "+header);

//use the created in app-constants to call the generic method 
	Assert.assertEquals(header, AppConstants.HOME_PAGE_HEADER);
		
	}
	@Test(priority=3)
	public void verifyLoggedInUserTest() {
	String accountName=homePage.getLoggedInUUserAccountName();	
	System.out.println("logged in account name : "+accountName);
	Assert.assertEquals(accountName, prop.getProperty("accountname"));
	}
	
	
	@AfterMethod
	public void tearDown() {
	driver.quit();	
}
	
	
	
	
}
	
