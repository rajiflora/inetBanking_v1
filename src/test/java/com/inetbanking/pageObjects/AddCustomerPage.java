package com.inetbanking.pageObjects;

import org.openqa.selenium.Keys;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//Add object locators using FindBy and WebElement
	@FindBy(how=How.XPATH, using="//a[contains(text(),'New Customer')]")
	WebElement newCustlink;
	
	//By newCustlink=By.xpath("//a[contains(text(),'New Customer')]");
	
	@FindBy(how=How.NAME, using="name")
	WebElement txtName;
	
	@FindBy(how=How.XPATH, using="//tbody/tr[5]/td[2]/input[1]")
	WebElement rdGenderM;
	
	@FindBy(how=How.XPATH, using="//tbody/tr[5]/td[2]/input[2]")
	WebElement rdGenderF;

	@FindBy(how=How.NAME, using="dob")
	WebElement txtDob;
	
	@FindBy(how=How.NAME, using="addr")
	WebElement txtAddress;
	
	@FindBy(how=How.NAME, using="city")
	WebElement txtCity;
	
	@FindBy(how=How.NAME, using="state")
	WebElement txtState;
	
	@FindBy(how=How.NAME, using="pinno")
	WebElement txtPinno;
	
	@FindBy(how=How.NAME, using="telephoneno")
	WebElement txtTelephoneno;
	
	@FindBy(how=How.NAME, using="emailid")
	WebElement txtEmailid;
	
	@FindBy(how=How.NAME, using="password")
	WebElement txtPassword;
	
	@FindBy(how=How.NAME, using="sub")
	WebElement btnSubmit;
	
	@FindBy(how=How.NAME, using="res")
	WebElement btnReset;


	public void clickNewCustomer() {
		newCustlink.click();
	}

	public void setCustName(String cname) {
		txtName.sendKeys(cname);
	}
	
	public void selectGender(String cgender) {
		if(cgender=="male") {
			rdGenderM.click();	
		}
		else if (cgender=="female"){
			rdGenderF.click();
		}
		
	}
	
	public void setDob(String yy, String mm, String dd) {
		txtDob.sendKeys(yy);
		txtDob.sendKeys(Keys.TAB);
		txtDob.sendKeys(mm);
		txtDob.sendKeys(dd);
	}
	
	public void setAddr(String caddr) {
		txtAddress.sendKeys(caddr);
	}
	
	public void setCity(String ccity) {
		txtCity.sendKeys(ccity);
	}
	
	public void setState(String cstate) {
		txtState.sendKeys(cstate);
	}
	
	public void setPinno(String cpinno) {
		txtPinno.sendKeys(String.valueOf(cpinno));
	}
	
	public void setTelephoneno(String cphoneno) {
		txtTelephoneno.sendKeys(cphoneno);
	}
	
	public void setEmailid(String cemailid) {
		txtEmailid.sendKeys(cemailid);
	}
	
	public void setPassword(String cpassword) {
		txtPassword.sendKeys(cpassword);
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
	
	public void clickReset(String cgender) {
		btnReset.click();
	}
}
