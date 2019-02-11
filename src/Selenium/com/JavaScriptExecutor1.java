package Selenium.com;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor1 {
        public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://freecrm.com");
		driver.findElement(By.name("username")).sendKeys("polai182");
		driver.findElement(By.name("password")).sendKeys("8652870778");
	WebElement btn = driver.findElement(By.xpath("//input[@type='submit']"));
	WebElement Usname=driver.findElement(By.name("username"));
	WebElement img=driver.findElement(By.xpath("//img[@class='img-responsive']"));
	
		flash(btn, driver);
		drawBorder(img, driver);
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,new File("E:\\Automation Project\\SeleniumAutomation\\MediaFolder\\crm.png"));
		alertMesssage("The img is not valid", driver);
		Thread.sleep(10000);
		driver.switchTo().alert().accept();
		}
	public static void flash(WebElement element,WebDriver driver) {
		String bgcolor=element.getCssValue("backgroundcolor");
		for (int i = 0; i <100; i++) {
			changecolor("rgb(0,200,0)",element,driver);
			changecolor(bgcolor, element, driver);
			}
       }
	public static void changecolor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundcolor='"+color+"'",element);
		try {
			Thread.sleep(20);
			
		} catch (InterruptedException e) {
	    }
		}
		public static void drawBorder(WebElement element,WebDriver driver) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].style.border='3px solid black'",element);
			}
		 public static void alertMesssage(String message,WebDriver driver) {
    	 JavascriptExecutor js=(JavascriptExecutor)driver;
    	 js.executeScript("alert('"+message+"')");
         }
         }
		
       
		
	

