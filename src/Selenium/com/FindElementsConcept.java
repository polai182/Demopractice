package Selenium.com;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver","E:\\Lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://facebook.com");
		List<WebElement> linklist=driver.findElements(By.tagName("a"));
		System.out.println("Size of the link::::"+linklist.size());
		for (int i = 0; i < linklist.size(); i++) {
			if(!linklist.get(i).getText().equalsIgnoreCase("")) {
				System.out.println(linklist.get(i).getText());
			}else if (linklist.get(i).getText().equalsIgnoreCase("")) {
				System.out.println(linklist.get(i).getText().length());
				
			}
			
		}
		

	}

}
