package com.pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class HomePage {
	
	WebDriver driver;
	GeneralUtilities utility=new GeneralUtilities();
	WaitUtilities wait=new WaitUtilities();
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
		
	}
	@FindBy(xpath="//div[contains(@class,'popover')]/div[@class='popover-navigation']/button[@class='btn btn-default btn-sm']")
	WebElement endtour;
	@FindBy(xpath="//section/h1[contains(text(),'Welcome admin,')]")
	WebElement welcome;
	
	@FindBy(xpath="(//ul[@class='sidebar-menu']/li)[2]")
	WebElement usermanagement;

	@FindBy(xpath="//li/a[@href='https://qalegend.com/billing/public/users']")
	WebElement users;
	
	
	@FindBy(xpath="//section/h1/small[text()='Manage users']")
	WebElement manageusers;
	
	@FindBy(xpath="//button[@id='btnCalculator']")
	WebElement calculator;
	
	@FindBy(xpath="//form//input[@name='result']")
	WebElement result;
	
	@FindBy(xpath="//button[@id='9']")
	WebElement nine;
	@FindBy(xpath="//button[@id='1']")
	WebElement one;
	
	@FindBy(xpath="//button[@id='+']")
	WebElement addition;
	
	@FindBy(xpath="//button[@id='equals']")
	WebElement equals;
	
	public String getTextofWelcome() {
		
		return utility.getTextofElement(welcome);
		
	}
	
	public void clickonusermanagement() {
		endtour.click();
		usermanagement.click();
		users.click();
		
	}
	public String getTextofUsers() {
		return utility.getTextofElement(manageusers);
	}
	
	public void clickOnCalculator() {
		utility.mouseHoverandClick_utility(calculator, driver);
		
	}
	
	public String addNumbersOnCalculator() {
	
		nine.click();
		addition.click();
		one.click();
		equals.click();
		return utility.getAttributeOfElement(result, "value");
		
		
	}

	
	
	
	
	
}
