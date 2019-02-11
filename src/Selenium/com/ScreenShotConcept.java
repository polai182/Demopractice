package Selenium.com;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.host.URL;
import com.gargoylesoftware.htmlunit.javascript.host.file.File;

public class ScreenShotConcept {

	public static void main(String[] args) throws IOException {
		 System.setProperty("webdriver.chrome.driver","E:\\Lib\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.get("http://facebook.com");
	     java.io.File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(f,new java.io.File("E:\\Automation Project\\SeleniumAutomation\\MediaFolder\\Facebook.png"));

	}

}
