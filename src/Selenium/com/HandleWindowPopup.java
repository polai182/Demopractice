package Selenium.com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopup {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Lib\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://gmail.com");
		String username="polaiautomation1990@gmail.com";
		String psw="8652870778";
		driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(psw);
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();
		driver.findElement(By.xpath("//*[@id=\":7a\"]/div/div")).click();
		String parentWindow=driver.getWindowHandle();
		System.out.println("parentWindow id"+driver.getTitle());
		Set<String> set = driver.getWindowHandles();
		Iterator<String>it=set.iterator();
		
		while(it.hasNext()) {
			String childwindow=it.next();
			if (!parentWindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);
				System.out.println("childwindow ID:"+driver.getTitle());
				Thread.sleep(3000);
				driver.close();
				
			}
			
		}
		
		
				
				
			}}


