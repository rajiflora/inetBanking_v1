package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws IOException, InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickLogin();
		
		Thread.sleep(2000);
		
		AddCustomerPage addCust=new AddCustomerPage(driver);
		
		logger.info("Clicking on New Customer link....");
		addCust.clickNewCustomer();
		Thread.sleep(2000);
		WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
		driver.switchTo().frame(frame1);
		WebElement frame2 = driver.findElement(By.id("ad_iframe"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		logger.info("Providing Customer Details....");
		addCust.setCustName("Melvyn");
		addCust.selectGender("male");
		Thread.sleep(1000);
		addCust.setDob("1983", "10", "06");
		Thread.sleep(3000);
		addCust.setAddr("INDIA");
		Thread.sleep(1000);
		addCust.setCity("CHN");
		Thread.sleep(1000);
		addCust.setState("TN");
		Thread.sleep(1000);
		addCust.setPinno("523564");
		Thread.sleep(1000);
		addCust.setTelephoneno("8799823134");
		Thread.sleep(1000);
		String emailId=randomString()+"@gmail.com";

		addCust.setEmailid(emailId);
		Thread.sleep(1000);
		addCust.setPassword("abcdef");
		Thread.sleep(1000);
		logger.info("Customer details entered successfully...");
		
		addCust.clickSubmit();
		
		Thread.sleep(2000);
		
		logger.info("Validation Starts...");
		
		if(driver.getPageSource().contains("Customer Registered Successfully!!!")) {
			Assert.assertTrue(true);
			logger.info("Customer Added Successfully - Test Case Passed");
		}
		else {
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Adding Customer failed");
		}
			
	}
	
	//user defined function to create random email address
	public String randomString() {
		String generatedString= RandomStringUtils.randomAlphabetic(5);
		return(generatedString);
	}
	
}
	

