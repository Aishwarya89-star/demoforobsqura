package com.pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class LoginPage {
	
	WebDriver driver;
	GeneralUtilities utility=new GeneralUtilities();
	WaitUtilities wait=new WaitUtilities();
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement button;
	
	@FindBy(xpath="//div/span[@class='help-block']")
	WebElement msg_error;
	
	@FindBy(xpath="//div/h1[text()='Demo POS']")
	WebElement logo;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement rememberme;
	
	public String getTitleofthePage() {
		return utility.getTitleOfUrl(driver);
	}
	
	public boolean checkboxenabled() {
		return utility.isElementEnabled(rememberme);
	}
	public HomePage login(String uname, String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
		button.click();
		return new HomePage(driver);
	}
	
	public String getErrorMessage() {
		return utility.getTextofElement(msg_error);
	}
	
	public boolean logoDisplayed() {
	return	utility.isElementDisplayed(logo);
		
	}
	

}
