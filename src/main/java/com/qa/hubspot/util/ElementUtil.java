package com.qa.hubspot.util;

import java.util.Properties;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;

public class ElementUtil extends BasePage {
///1. create local reference/define reference driver 
	WebDriver driver; 
//12 give the reference of webdriverwait 
	WebDriverWait wait; 
	JavaScriptUtil jsUtil; 
	Properties prop; 
	
	
//2.create constructor so we can call driver within the class
	public ElementUtil(WebDriver driver) { 
	prop=super.prop; 
	
	this.driver=driver; 
//13 create the obj of wait but pass the constant value and avoid hard-coding 
		// wait= new WebDriverWait(driver, 20); 
	wait= new WebDriverWait(driver, AppConstants.DEFAULT_TIME_OUT);
	jsUtil=new JavaScriptUtil(driver); 
}
	
//14 created in case presence of elements did not work so it acts based on visibility 
	public boolean waitForElementVisible(By locator) {
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); 
	return true; 
	}
//15 
	public boolean waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)); 
		return true; 
		}
	
//16 wait for non-element but title and to remove the thread-sleep hard-coded
	public boolean waitForTitlePresent(String title) {
		wait.until(ExpectedConditions.titleIs(title)); 
		return true; 
		}
	
//10. create get title method as well 
	public String doGetPageTitle() {//you can ignore writing try/catch 
	try {
		return driver.getTitle(); }
	catch(Exception e ) {
	System.out.println("some exception got occured while getting the tile....");

}
	return null;//11. add return statement 
	}
	
	/**
	 * this method is used to create the web-element on the basis of By locator 
	 * @param locator
	 * @return element 
	 */
	public WebElement getElement(By locator) {//3.we use by locators in page layers so create its generic method 
		//4.exception handling should be there
		WebElement element=null;//5.initialize web-element to null 
		try {
//16 try wait in try block so wait for element to be present applies before execution
//			if(waitForElementPresent(locator));
		element=driver.findElement(locator);
//17 used for highlighting the element 
		if(highlightElement) {
			jsUtil.flash(element);
	}
		 }
		catch(Exception e) {
		System.out.println("some exception got occured while creating the web element....");
		}
		return element; 

	}
	//6. call get-element method which is the common method inside other methods 
	public void doClick(By locator) {
		try {
		getElement(locator).click();
		}
		catch(Exception e) {
		System.out.println("some exception got occured while clicking on the web element....");
	    }
	}
	//7.call get-element method which is the common method inside other methods 
	public void doSendKeys(By locator, String value) {
		try {
			WebElement ele =getElement(locator);
			ele.clear();
			ele.sendKeys(value);}
			catch(Exception e) {
			System.out.println("some exception got occured while entering values in a field....");
}
	
	}
	
	public boolean doIsDisplayed(By locator) {
//8. this method must return a result of boolean type so we add return type:return false
		try {
		return getElement(locator).isDisplayed();}
		catch(Exception e) {
		System.out.println("some exception got occured....");
	
		}
		return false;
	}
	
	
	public String doGetText(By locator) {
		
//9. this method must return a result of boolean type so we add return type:return false
		try {
		return getElement(locator).getText();
		}
		catch(Exception e) {
		System.out.println("some exception got occured while getting the text....");
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
