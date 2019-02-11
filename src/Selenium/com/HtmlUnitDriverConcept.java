package Selenium.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\Lib\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver=new HtmlUnitDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://freecrm.com");
		System.out.println("Before login Title is:"+driver.getTitle());
		driver.findElement(By.name("username")).sendKeys("polai182");
		driver.findElement(By.name("password")).sendKeys("8652870778");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
		System.out.println("After login Title is:"+driver.getTitle());

	}

}
