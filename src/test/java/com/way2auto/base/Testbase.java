package com.way2auto.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.model.Log;
import com.way2auto.utilities.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	
	public static WebDriver driver;
	
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream input1;
	public static FileInputStream input2;
	public static ExcelReader excel = new ExcelReader("E:\\frameworkmindq\\datadriven\\src\\test\\resources\\excel\\test.xlsx");
  
  
    
    
	@BeforeSuite
	public void setUp() throws IOException {
    	 
    	 if (driver==null) {
    		 
    		     input1 = new FileInputStream((System.getProperty("user.dir")) + "\\src\\test\\resources\\properties\\config.properties");
    	 		//System.out.println((System.getProperty("user.dir")));
    	 		 input2 = new FileInputStream("E:\\frameworkmindq\\datadriven\\src\\test\\resources\\properties\\OR.properties");
    	 		 
    	 		config.load(input1);
    	 		//log.info("config file loaded");
    	 		or.load(input2);
    	 		//log.info("OR file upload");
    	 		//System.out.println(config.getProperty("browser"));
    	 		//System.out.println(or.getProperty("bmlBtn"));	
			
		}
    	 if (config.getProperty("browser").equals("chrome")) {
    		 
    		 WebDriverManager.chromedriver().setup();
    		 driver= new ChromeDriver();
    		// log.info("chrome driver opened");
			}else if (config.getProperty("browser").equals("firefox")) {
				
				 WebDriverManager.firefoxdriver().setup();
	    		 driver= new FirefoxDriver();
	    		// log.info("firefox driver opened");
				
			}else if (config.getProperty("browser").equals("ie")) {
				
				WebDriverManager.iedriver().setup();
	    		 driver= new InternetExplorerDriver();
				
			}
    	 
    	 driver.get(config.getProperty("testSiteUrl"));
    	 driver.manage().window().maximize();
    	 driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("time")), TimeUnit.SECONDS);
    	 
		
	}
	
	public static boolean isElementPresent(By by) {
		
		try {
			
			driver.findElement(by);
			return true;
			
		} catch (NoSuchElementException e) {
			return false;
		}
		
	}
     @AfterSuite
	public void tearDown() {
    	// log.info("browser closed");
		driver.quit();
		
	}
	
	
}
