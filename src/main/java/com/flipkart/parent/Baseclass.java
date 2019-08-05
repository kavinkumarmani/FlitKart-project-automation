package com.flipkart.parent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.flipkart.util.Utilities;

public class Baseclass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	
	public Baseclass() throws Exception {
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Saran\\eclipse-workspace\\Flipkartproject\\src\\main\\java\\com\\flipkart\\properties\\com.properties");
		prop.load(fis);
	}
	
	public void initilization() {
		String browsername=prop.getProperty("browser");
		//browser initilization
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","\\C:\\Users\\Saran\\Downloads\\selenium\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","\\C:\\Users\\Saran\\Downloads\\selenium\\firefoxdriver.exe");
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("There is no properties assigned for the browser");
		}
		
		//other properties
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//url of page
		driver.get(prop.getProperty("url"));
		//timeout
		driver.manage().timeouts().pageLoadTimeout(Utilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utilities.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		//driver.findElement(By.linkText(prop.getProperty("loginlinktext"))).click();
		
		
	}

}
