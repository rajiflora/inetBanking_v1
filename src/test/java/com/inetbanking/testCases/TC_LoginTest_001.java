package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException {
			
		//logger messages
		logger.info("URL is opened");
		
		//create object for page object class
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Username is entered");
		
		lp.setPassword(password);
		logger.info("password is entered");
		
		lp.clickLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
			
		
	}
	
}
