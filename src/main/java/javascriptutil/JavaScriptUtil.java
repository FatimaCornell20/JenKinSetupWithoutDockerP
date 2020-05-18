package javascriptutil;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

	
public static void flash(WebElement element, WebDriver driver) {
JavascriptExecutor js=((JavascriptExecutor) driver); 
String bgcolor =element.getCssValue("backgroundColor");
for (int i=0; i<20; i++) {
//changeColor("rgb(0,200,0)", element, driver); 
//changeColor(color, element, driver); 
	}
}

public static String getTitleByJS(WebDriver driver) {
JavascriptExecutor js=((JavascriptExecutor)driver);//type-cast your driver into java- script interface
String title=js.executeScript("return document.title").toString();//method:execute java script and execute your java script in () then turns it into string
return title; 	
}
public static String getPageInnerText(WebDriver driver) {
JavascriptExecutor js=((JavascriptExecutor) driver); 
String pageText=js.executeScript("return document.documentElement.innerText;").toString();
return pageText;
}

public static void generateAlert(WebDriver driver, String message) {
JavascriptExecutor js=((JavascriptExecutor)	driver); 
js.executeScript("alert('"+message+"')");  

}
public static void scrollPageDown(WebDriver driver) {
JavascriptExecutor js=((JavascriptExecutor) driver); 
js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
}

public static void ScrollIntoView(WebElement element, WebDriver driver) {
JavascriptExecutor js=((JavascriptExecutor) driver); 
js.executeScript("arguments[0].scrollIntoView(true);", element);

}

public static void refreshBrowserByJS(WebDriver driver) {
JavascriptExecutor js=((JavascriptExecutor) driver); 
js.executeScript("history.go(0)");

}


public static String getBrowserInfo(WebDriver driver) {
JavascriptExecutor js=((JavascriptExecutor) driver);//type-cast java script into driver 
String uAgent=js.executeScript("return navigator.userAgent;").toString();//because we get info, need to turn it into string 
return uAgent; 
}
public static void sendKeysUsingJSwithId(WebDriver driver, String id, String value) {
JavascriptExecutor js=((JavascriptExecutor) driver);
js.executeScript("document.getElementById('"+id+"').value='"+value+"'");
	
}
public static void clickElementByJS(WebDriver driver, WebElement element) {
JavascriptExecutor js=((JavascriptExecutor) driver);
js.executeScript("arguments[0].click();", element); 	
}
public static void drawBorder(WebElement element, WebDriver driver) {
JavascriptExecutor js=((JavascriptExecutor) driver);
js.executeScript("arguments[0].style.border='3px solid red'", element); 

}
public static void changeColor(String color, WebElement element, WebDriver driver) {
JavascriptExecutor js=((JavascriptExecutor) driver);
js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
	
}

public static void scrollIntoView(WebElement element, WebDriver driver) {
JavascriptExecutor js=((JavascriptExecutor) driver);
js.executeScript("arguments[0].scrollIntoView(true);" ,element);

}
public static void scrollDown(WebDriver driver) {
JavascriptExecutor js=((JavascriptExecutor) driver);
js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); 
}



} 


	
	


