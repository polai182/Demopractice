package Selenium.com;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
     public static  WebDriver driver;
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","E:\\Lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
		List<WebElement>str=driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@role='option']"));
		System.out.println("The size of suggested values are::"+str.size());
		//For printing all suggested values in alphabatical order
		/*Set<String> str1 = new TreeSet<>();
		for (int i = 0; i < str.size(); i++) {
			str1.add(str.get(i).getText());
	    }
		for (String string : str1) {
			System.out.println(string);
		}*/
		for (int i = 0; i < str.size(); i++) {
			System.out.println(str.get(i).getText());
			if(str.get(i).getText().contains("selenium grid")) {
				str.get(i).click();
				break;
			}
			
		}
		
		    

	        }

            }
