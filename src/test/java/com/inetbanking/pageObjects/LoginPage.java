package com.inetbanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public WebDriver driver=null;
	
	//Add object locators
	
	By txtUserName=By.name("uid");
	By txtPassword=By.name("password");
	By btnLogin=By.name("btnLogin");
	By btnReset=By.name("btnReset");
	By linkLogout=By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[15]/a[1]");
	
	//Add action methods for each objects
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void setUserName(String uname) {
		driver.findElement(txtUserName).sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		driver.findElement(txtPassword).sendKeys(pwd);
	}
	
	public void clickLogin() {
		driver.findElement(btnLogin).click();
	}
	
	public void clickReset() {
		driver.findElement(btnReset).click();
	}
	
	public void clickLogout() {
		driver.findElement(linkLogout).click();
	}
}
