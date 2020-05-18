package com.qa.hubspot.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	
	WebDriver driver; //1give the driver to this class by creating its constructor 
	
	public JavaScriptUtil(WebDriver driver) {//2pass web-driver and driver in constructor 

	this.driver=driver;
	
	}
//3 copy all methods from javascriptutil from previous sessions to here and remove webdriver driver and static from all methods here 
		public void flash(WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor) driver); 
		String bgcolor =element.getCssValue("backgroundColor");
		for (int i=0; i<20; i++) {
		//changeColor("rgb(0,200,0)", element, driver); 
		//changeColor(color, element, driver); 
			}
		}

		public  String getTitleByJS() {
		JavascriptExecutor js=((JavascriptExecutor)driver);//type-cast your driver into java- script interface
		String title=js.executeScript("return document.title").toString();//method:execute java script and execute your java script in () then turns it into string
		return title; 	
		}
		public String getPageInnerText() {
		JavascriptExecutor js=((JavascriptExecutor) driver); 
		String pageText=js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
		}

		public void generateAlert(String message) {
		JavascriptExecutor js=((JavascriptExecutor)	driver); 
		js.executeScript("alert('"+message+"')");  

		}
		public void scrollPageDown() {
		JavascriptExecutor js=((JavascriptExecutor) driver); 
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}

		public void ScrollIntoView(WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor) driver); 
		js.executeScript("arguments[0].scrollIntoView(true);", element);

		}

		public void refreshBrowserByJS() {
		JavascriptExecutor js=((JavascriptExecutor) driver); 
		js.executeScript("history.go(0)");

		}

		public String getBrowserInfo() {
		JavascriptExecutor js=((JavascriptExecutor) driver);//type-cast java script into driver 
		String uAgent=js.executeScript("return navigator.userAgent;").toString();//because we get info, need to turn it into string 
		return uAgent; 
		}
		public void sendKeysUsingJSwithId(String id, String value) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('"+id+"').value='"+value+"'");
			
		}
		public void clickElementByJS(WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element); 	
		}
		public void drawBorder(WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element); 

		}
		public void changeColor(String color, WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
			
		}
		
		public void scrollIntoView(WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);" ,element);

		}
		public void scrollDown() {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); 
		}
	

}
