package Selenium.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidationConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\Lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://freecrm.com/register");
		boolean a=driver.findElement(By.id("submitButton")).isDisplayed();
		System.out.println("The submit button is dispalyed:::"+a);
		boolean a1=driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println("This button is enabled:->"+a1);
		driver.findElement(By.name("agreeTerms")).click();
		boolean a2=driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println("This button is enabled:->"+a2);
		driver.findElement(By.name("agreeTerms"));
		boolean a3=driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println("This radio button is selected:->"+a3);
		driver.findElement(By.name("agreeTerms")).click();
		boolean a4=driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println("This radio button is selected:->"+a4);
		

		
		
		

	}

}
