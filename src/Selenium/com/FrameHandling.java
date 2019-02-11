package Selenium.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class FrameHandling {
        public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\Lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("polai182");
		driver.findElement(By.name("password")).sendKeys("8652870778");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("submit")).click();

	}

}
