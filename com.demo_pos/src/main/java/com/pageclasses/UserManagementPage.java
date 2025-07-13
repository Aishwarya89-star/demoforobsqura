package com.pageclasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class UserManagementPage {

WebDriver driver;
GeneralUtilities utility=new GeneralUtilities();
WaitUtilities wait=new WaitUtilities();
	public UserManagementPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/users/create']")
	WebElement add;
	
	@FindBy(xpath="//section[@class='content-header']/h1[contains(text(),'Add user')]")
	WebElement adduser;
	
	@FindBy(xpath="//input[@name='surname']")
	WebElement surname;
	
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	
	
	@FindBy(xpath="//select[@id='role']/option[contains(text(),'Producer')]")
	WebElement role;
	
	@FindBy(xpath="(//div[@class='col-md-6']/div[@class='form-group']/input[@type='password'])[1]")
	WebElement firstpassword;
	
	@FindBy(xpath="(//div[@class='col-md-6']/div[@class='form-group']/input[@type='password'])[2]")
	WebElement secondpassword;
	
	@FindBy(css="#submit_user_button")
	WebElement save;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	
	@FindBy(xpath="//table[@id='users_table']/tbody/tr/td[2]")
	WebElement searchedname;
	
	//calci
	
	
	

	
	public void clickonAddUser() {
		add.click();
	}
	
	public String addUserGetText() {
		return utility.getTextofElement(adduser);
	}
	
	public void newUserCreation(String sname, String fname,String emailformat,String fpass,String spass) {
		surname.sendKeys(sname);
		firstname.sendKeys(fname);
		email.sendKeys(emailformat);
		
		role.click();
		//role.sendKeys(Keys.ENTER);
		firstpassword.sendKeys(fpass);
		secondpassword.sendKeys(spass);
		save.click();
	}
	
	public void searchUser(String name) {
		search.sendKeys(name);
		search.sendKeys(Keys.ENTER);
	}
	
	public String textGotPopulated() {
		return utility.getTextofElement(searchedname);
	}

}
