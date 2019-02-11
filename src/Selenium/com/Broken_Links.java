package Selenium.com;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Broken_Links {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver","E:\\Lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://freecrm.com");
		driver.findElement(By.name("username")).sendKeys("polai182");
		driver.findElement(By.name("password")).sendKeys("8652870778");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
		driver.switchTo().frame("mainpanel");
		//get all the link and images in one list
		
		List<WebElement> Linklist=driver.findElements(By.tagName("a"));
		Linklist.addAll(driver.findElements(By.tagName("img")));
		System.out.println("The number of links and images are:::"+Linklist.size());
		
		//Get all the active links which contains href properties
		List<WebElement> ActiveLinklist=new ArrayList<WebElement>();
		for (int i = 0; i < Linklist.size(); i++) {
			System.out.println(Linklist.get(i).getAttribute("href"));
			if(Linklist.get(i).getAttribute("href")!=null&&(!Linklist.get(i).getAttribute("href").contains("javascript"))) {
				ActiveLinklist.add(Linklist.get(i));
				
			}
			
		}
		//get the size of active link
		System.out.println("The number of ActiveLinks are present::::"+ActiveLinklist.size());
		int brokenImage=Linklist.size()-ActiveLinklist.size();
		System.out.println("The number of broken images and links are:::::"+brokenImage);
		
		//check the href url with httpconnection api
		//200--ok
		//404--Not found
		//500--Internal error
		//400--bad request
		
		for (int j = 0; j < ActiveLinklist.size(); j++) {
			HttpURLConnection connection=(HttpURLConnection) new URL(ActiveLinklist.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String str = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(ActiveLinklist.get(j).getAttribute("href")+"----->"+str);
			
			
		}
		

	}

}
