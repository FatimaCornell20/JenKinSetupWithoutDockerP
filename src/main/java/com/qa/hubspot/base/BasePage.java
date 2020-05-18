package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


//in the base class: initializing driver and properties 
public class BasePage {
	 
//1. initializing webDriver and properties reference at class level so we can access it everywhere in the class
	public WebDriver driver;
	public Properties prop; //doing this helps prop to be globally available 
//6 use highlight in javasc. config prop to highlight elements, first initialize the reference 	
	public static boolean highlightElement; 
	
  public WebDriver init_driver(String browserName){
//7 provide the getprop with condition as follows 
	  highlightElement=prop.getProperty("highlight").equals("yes") ? true:false;
	  
	  System.out.println("browser name is:"+ browserName);//6.after creating prop in login-page-test 
	  if(browserName.equals("chrome")) {
	  WebDriverManager.chromedriver().setup();
	  
	  if(prop.getProperty("headless").equals("yes")) {
 
//2 to do execute the test in headless mode for chrome use ChromeOptions class
		  ChromeOptions co=new ChromeOptions(); 
		  co.addArguments("--headless");
//pass co reference here 
		  driver=new ChromeDriver(co);
	  }
	  else {
		  driver=new ChromeDriver();
		  }
	  }
	  else if (browserName.equals("firefox")) {
		  WebDriverManager.firefoxdriver().setup();
		  driver=new FirefoxDriver();
}
	  else if (browserName.equals("safari")) {
		  WebDriverManager.getInstance(SafariDriver.class).setup();
		  driver=new SafariDriver();
	  }
	
	  else {
		  System.out.println("browser Name" +browserName + "is not found, please pass the correct browser");
		  }
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().window().fullscreen();
	  
//driver.get(url);
	  
	  return driver;
	  
  }
  
  	public Properties init_properties() {
  		
  		//1.Properties prop=new Properties();
  		prop=new Properties();
  		String path=null;//providing null as path 
  		String env=null;//providing null as env 
  		try {
  			env=System.getProperty("env"); 	// 
  		if(env.equals("qa")) {//env equals to qa 
  		   path="./src/main/java/com/qa/hubspot/config/qa.config.properties";	
  		}
  		else if(env.equals("stg")) {//stage equals to env 
  		   path="./src/main/java/com/qa/hubspot/config/stg.config.properties";	
  		} }
  		catch(Exception e) {
  		}
  		//2.String path="/Users/fatima/Documents/POMSessions_Naveen/src/main/java/com/qa/hubspot/config/config.properties";
  		//because it is hard-coded we use only src so it works other places as well
  		//String 
  		//if no env run the conifg prop...below 
  		path="./src/main/java/com/qa/hubspot/config/config.properties";//3.if anything happened to file:try catch helps handle the issue 
  		try {
			FileInputStream ip=new FileInputStream(path);
			prop.load(ip);//4.load all the properties class obj and it leads to second catch clause 
		} catch (FileNotFoundException e) {
		System.out.println("some issues with config properties.. please correct your config..");
		} catch (IOException e) {
			e.printStackTrace();
		}
  		//5. return type changed
  		return prop;
  		
  			
  	}
  	}
  		
