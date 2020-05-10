package com.way2auto.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.way2auto.base.Testbase;

public class BankManagerLogin extends Testbase{
	
	
	@Test
	public static void loginAsBm() throws Throwable {
		//log.info("bank manager login btn click");
		driver.findElement(By.cssSelector(or.getProperty("bmlBtn"))).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("acBtn"))),"Login not success");
		
	}
	
	

}
