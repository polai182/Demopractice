package Selenium.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Window;

public class JavaScriptExecutor {
	@Test
	public void login() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","E:\\Lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.get("http://google.com");
		String url=js.executeScript("return document.URL;").toString();
		String pageTitle=js.executeScript("return document.title;").toString();
		String domain=js.executeScript("return document.domain;").toString();
		System.out.println("URL of the page:->   "+url+", domain of the page:->  "+domain+", title of the page:->  "+pageTitle);
		driver.findElement(By.name("q")).sendKeys("selenium");
		driver.findElement(By.name("btnK")).click();
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,1000)"); 
			System.out.println("Succesfully scrolled down");
			
		
        
        
		/*System.setProperty("webdriver.chrome.driver","E:\\Lib\\chromedriver.exe");
		  WebDriver driver= new ChromeDriver();	
		  

	        //Creating the JavascriptExecutor interface object by Type casting		
	        JavascriptExecutor js = (JavascriptExecutor)driver;		
	        		
	        //Launching the Site.		
	        driver.get("http://demo.guru99.com/V4/");			
	     
	          //Maximize window		
	          driver.manage().window().maximize();		
	        		
	          //Set the Script Timeout to 20 seconds		
	          driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);			
	             
	          //Declare and set the start time		
	          long start_time = System.currentTimeMillis();			
	                   
	          //Call executeAsyncScript() method to wait for 5 seconds		
	          js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");			
	          		
	         //Get the difference (currentTime - startTime)  of times.		
	         System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));
		
		
		
*/	}

}