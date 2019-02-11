package Selenium.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadpropertiesFile {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		Properties pro=new Properties();
		//String filepath="E:\\Automation Project\\SeleniumAutomation\\src\\Selenium\\com\\config.properties";
		ReadpropertiesFile rf = new ReadpropertiesFile();
		InputStream resourceAsStream = rf.getClass().getClassLoader().getResourceAsStream("config.properties");
		//FileInputStream fi=new FileInputStream(filepath);
		pro.load(resourceAsStream);
		String browsername=pro.getProperty("browser");
		String url=pro.getProperty("URL");
		System.out.println(browsername);
		if (browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","E:\\Lib\\chromedriver.exe");
			  driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		} else if(browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","E:\\Lib\\geckodriver.exe");
			 driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		}else if(browsername.equals("IE")) {
			System.setProperty("webdriver.ie.driver","E:\\Lib\\internetexplorer.exe");
			  driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		driver.get(url);
		driver.findElement(By.name(pro.getProperty("searchBoxname"))).sendKeys(pro.getProperty("searchvalues"));
		driver.findElement(By.name(pro.getProperty("searchbuttonname"))).click();
		

	}

}
