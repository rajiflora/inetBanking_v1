package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

		@Test(dataProvider="LoginData")
		public void loginDDT(String username,String password) throws InterruptedException {
			LoginPage lp=new LoginPage(driver);
			lp.setUserName(username);
			logger.info("Username Provided");
			lp.setPassword(password);
			logger.info("Password Provided");
			lp.clickLogin();
			Thread.sleep(1000);
			//Alert appears, if login failed. so check if Alert is present or not
			if(isAlertPresent()==true) {
				driver.switchTo().alert().accept(); //close alert
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
				logger.warn("Login Failed");
			}
			else {
				Assert.assertTrue(true);
				logger.info("Login Passed");
				Thread.sleep(1000);
				lp.clickLogout();
				driver.switchTo().alert().accept(); //close logout alert
				driver.switchTo().defaultContent();
			}
		}
		
		//To check if alert is present or not
		public boolean isAlertPresent() {
			try {
				driver.switchTo().alert();
				return true;
			}
			catch(NoAlertPresentException e) {
				return false;
			}
		}
		
		//to get the data from the excel and store it in 2 dimensional array and return it to the actual test case, the loginDDT method
		@DataProvider(name="LoginData")
		String[][] getData() throws IOException{
			String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
			int rownum=XLUtils.getRowCount(path, "Sheet1");
			int colcount=XLUtils.getCellCount(path, "Sheet1", rownum);
			
			String logindata[][]=new String[rownum][colcount];
			
			for(int i=1; i<=rownum;i++) {
				for(int j=0; j<colcount;j++) {
					logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i , j);
				}
			}
			return logindata;
					
		}
		
}
