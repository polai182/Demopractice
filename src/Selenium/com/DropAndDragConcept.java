package Selenium.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DropAndDragConcept {
	public static WebDriver driver;
    
	    public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://www.jqueryui.com");
		driver.findElement(By.linkText("Droppable")).click();
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		           WebElement e1 = driver.findElement(By.id("draggable"));
		           WebElement e2 = driver.findElement(By.id("droppable"));
		           Actions act=new Actions(driver);
                   act.clickAndHold(e1).moveToElement(e2).build().perform();
	}

}
