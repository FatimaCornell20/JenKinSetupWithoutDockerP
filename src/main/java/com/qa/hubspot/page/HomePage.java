package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.AppConstants;
import com.qa.hubspot.util.ElementUtil;

public class HomePage extends BasePage{//1. create locators for home-page elements 
	//4.initialize the web-driver reference here 
	WebDriver driver; 
	//7. create elementUtil reference so we can call it in all classes
	ElementUtil elementUtil; 
	
	By header=By.partialLinkText("Take a closer look at"); 
	By accoutName=By.className("account-name "); 
	
	public HomePage(WebDriver driver) {//2.create the constructor of HomePage class 3.pass web-driver as param
	this.driver=driver; //4.Initialize web-driver to local driver 5. pass the driver to homepage class obj in loginpage
	
	//8. create obj of ElementUtil class and pass the driver 
	elementUtil=new ElementUtil(driver); 

	
	}//6. create 3 methods to get home-page info then create home-page test in its test class 
//9. change driver to generic method of elementUtil 
	public String getHomePagetitle() {
//12 use wait method for title here to get rid of threadsleep
		elementUtil.waitForTitlePresent(AppConstants.HOME_PAGE_TITLE); 
		//return driver.getTitle();
	return elementUtil.doGetPageTitle();
		}
//10. replace generic method with driver hard-coded. 
	public String getHomePageHeader() {
	//return driver.findElement(header).getText();
	return elementUtil.doGetText(header); 
	
	}
//11. apply same for this driver 
	public String getLoggedInUUserAccountName() {
	//return driver.findElement(accoutName).getText();
	return elementUtil.doGetText(accoutName);
	
	}
	
}
