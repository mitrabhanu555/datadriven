package com.way2auto.testcases;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.way2auto.base.Testbase;
import com.way2auto.utilities.ExcelReader;

public class AddCustomer extends Testbase {
	
	@Test(dataProvider = "getData")
	public void addCustomer(String firstName,String lastName,String Postcode,String alerttext) throws Throwable {
		driver.findElement(By.xpath(or.getProperty("acBtn"))).click();
		driver.findElement(By.xpath(or.getProperty("fname"))).sendKeys(firstName);
		driver.findElement(By.xpath(or.getProperty("lname"))).sendKeys(lastName);
		driver.findElement(By.xpath(or.getProperty("pcode"))).sendKeys(Postcode);
		driver.findElement(By.xpath(or.getProperty("addc"))).click();;
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		
		Assert.assertTrue(alert.getText().contains(alerttext));
		alert.accept();
		Thread.sleep(4000);
		
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		
		Object[][] data = null;
		
		data= ExcelReader.getdata();
		return data;
		
				
			}
			
		}
		
	


