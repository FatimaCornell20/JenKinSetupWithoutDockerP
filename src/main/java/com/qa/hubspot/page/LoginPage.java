package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.AppConstants;
import com.qa.hubspot.util.Credentials;
import com.qa.hubspot.util.ElementUtil;
import com.qa.hubspot.util.JavaScriptUtil;

public class LoginPage extends BasePage{
// creating by locators and page actions for each page 
//2.create the web-driver reference  
//7. call the until class here, by its class name:first make its reference 
	WebDriver driver; 
	ElementUtil elementUtil; 
//16 create javascutil reference and then its obj#17
	JavaScriptUtil jsUtil; 

	
//1.create locators using By 
	By emailId= By.id("username");
	By pwd= By.id("password");
	By loginButton= By.id("loginBtn");
	By signUpLink=By.linkText("Sign up");
	By loginErrorText=By.xpath("//div[class='private-alert__inner']"); 

	
//3. create the class constructor and pass the WebDriver 
	public LoginPage(WebDriver driver) {
	this.driver=driver; 
//8. initialization is here fir ElementUtil and pass the driver  
	elementUtil= new ElementUtil(driver);
//17 create obj of javascriputil and pass the driver so u can call its methods inside here 
	jsUtil=new JavaScriptUtil(driver); 
	
}
//4. write page action 
	public String getPageTitle() {
//15 using wait method for title to get rid of threadsleep 
	elementUtil.waitForTitlePresent(AppConstants.LOGIN_PAGE_TITLE); 
//9. change the diver to element-util because we got own generic method 
	//return driver.getTitle();
	return elementUtil.doGetPageTitle();
	}

//18 if in case above get title did not work we go with javasc as alternative 
	public String getPageTitleUsingJS() {
		return jsUtil.getTitleByJS(); 
	}
	
	public boolean checkSignUpLink() {
//10. do same for the following 
	//return driver.findElement(signUpLink).IsDisplayed();
//14 can call waitforelement method as individual and also inside if see elementUtil#16 
	elementUtil.waitForElementPresent(signUpLink); 
	return elementUtil.doIsDisplayed(signUpLink); 
	}
	
	
//11. use same generic method=elementUtil instead of using driver 
//12. to replace num of param in page library:pass credential class reference and import it 
	//public HomePage doLogin(String username, String password) {

	public HomePage doLogin(Credentials userCred) {
	//elementUtil.waitForElementPresent(emailId); 
	elementUtil.doSendKeys(emailId, userCred.getAppUsername());//13.pass its methods:getApppass
	elementUtil.doSendKeys(pwd, userCred.getAppPassword());
	elementUtil.doClick(loginButton);

	
//	driver.findElement(emailId).sendKeys(username);
//	driver.findElement(pwd).sendKeys(password);
//	driver.findElement(loginButton).click();//it is landing on home-page after clicking on login-button so we say return#5
	
	return new HomePage(driver);//5. return new home-page class obj, change void to HomePage 
								//6.pass the driver to home-page after creating its constructor in home-page 
	
	
	}

//13 this is for assertion purpose of the invalid login data 
	
	public boolean checkloginErrorMessg() {
	return elementUtil.doIsDisplayed(loginErrorText);
	}
	
}
