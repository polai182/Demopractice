package Selenium.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopupHandiling {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","E:\\Lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		/*driver.get("http://rediffmail.com");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(5000);
		Alert alrt=driver.switchTo().alert();
		String str = alrt.getText();
		System.out.println(str);
		alrt.accept();
		if (str.equals("please enter a valid username")) {
			System.out.println("Correct alrt msg");
			
		}else {
			System.out.println("In-correct alrt msg");
		}*/
		driver.get("http://www.myntra.com");
		Thread.sleep(5000);
		Alert alrt=driver.switchTo().alert();
		String str = alrt.getText();
		System.out.println(str);
		alrt.accept();
		if (str.equals("please enter a valid username")) {
			System.out.println("Correct alrt msg");
			
		}else {
			System.out.println("In-correct alrt msg");
		
		
		
		
		}
	}

}
