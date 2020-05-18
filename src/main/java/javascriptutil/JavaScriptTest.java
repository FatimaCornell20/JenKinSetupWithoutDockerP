package javascriptutil;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class JavaScriptTest {
//call these methods from javascriptutil class here to test 
	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver", "//Users//fatima//Documents//chromedriver");
	//WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
	driver.get("http://facebook.com/");	
	//driver.get("http://crmpro.com/");	

		
	//JavaScriptUtil.generateAlert(driver, "this is my pop message");
	//JavaScriptUtil.refreshBrowserByJS(driver);
	
	WebElement element=driver.findElement(By.linkText("Forgot account?"));
	//JavaScriptUtil.clickElementByJS(driver, element);
	
	//JavaScriptUtil.sendKeysUsingJSwithId(driver, "email", "fatima.bakhsh@gmail.com"); 
	
	//System.out.println(JavaScriptUtil.getBrowserInfo(driver)); //it gives browser info 
	
	
	//System.out.println(JavaScriptUtil.getPageInnerText(driver)); 
	//System.out.println(JavaScriptUtil.getTitleByJS(driver)); 
	
	
	//JavaScriptUtil.drawBorder(element, driver);
	//JavaScriptUtil.flash(driver, element);	
	 
	 //JavaScriptUtil.scrollDown(driver);
	 //JavaScriptUtil.scrollPageDown(driver);
	 //JavaScriptUtil.ScrollIntoView(element, driver);
	 
	 
	 


	 
	
	
	
	
	
	
		
		
	}

}
