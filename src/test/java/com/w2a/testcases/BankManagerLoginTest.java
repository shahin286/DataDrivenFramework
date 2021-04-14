package com.w2a.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase {

	@Test
	public void bankManagerLoginTest() throws InterruptedException, IOException {

		String actual = driver.getTitle();
		verifyEquals(actual, "Protractor practice website - Banking App");
		Thread.sleep(3000);
		
		log.debug("Inside Login Test");
		log.debug("The Page Title: "+driver.getTitle());
		log.debug(driver.findElement(By.cssSelector(OR.getProperty("bmlBtn_CSS"))).isEnabled());
		click("bmlBtn_CSS");
		log.debug("Successfully clicked on bank manager login button");

		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustomerBtn_CSS"))), "Login Not Successful");
		//driver.findElement(By.cssSelector(OR.getProperty("addCustomerBtn"))).click();
	
		log.debug("Login Successfully Executed");

	}

}
