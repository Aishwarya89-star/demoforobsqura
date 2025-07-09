package com.pageclasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ContactsPage {
	
	WebDriver driver;
	GeneralUtilities utility=new GeneralUtilities();
	WaitUtilities wait=new WaitUtilities();
	public ContactsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
		
	}
	
	@FindBy(xpath="//a[@id='tour_step4_menu']")
	WebElement contacts;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/contacts?type=supplier']")
	WebElement suppliers;
	
	@FindBy(xpath="//div[@class='box-header']/h3[text()='All your Suppliers']")
	WebElement allsuppliers;
	
	
	@FindBy(xpath="//table[@id='contact_table']/tbody/tr")
	WebElement rowsize;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/contacts/import']")
	WebElement importcontacts;
	
	@FindBy(xpath="//div[@class='form-group']/input[@type='file']")
	WebElement file;
	
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement buttonsubmit;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertmsg;
	
	@FindBy(xpath="//table[@id='contact_table']/tbody/tr/td[text()='EVSTECHNOLOGY']")
	WebElement suppliername;
	
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement searchbarsuppliername;
	
	@FindBy(xpath="//button[@data-toggle='dropdown']")//here button to click for actions
	WebElement buttonforactionatsupplier;
	
	@FindBy(xpath="//li//a[@href='https://qalegend.com/billing/public/payments/pay-contact-due/1720?type=purchase']")
	WebElement paydueamount;//payment due amount
	
	@FindBy(xpath="//form/div[@class='modal-header']/h4")
	WebElement textofpaydueamountpop;
	
	public void goToSupplierpage() {
		contacts.click();
		suppliers.click();
	}
	
	public String getTextofSupplierPage() {
		return utility.getTextofElement(allsuppliers);
	}
	public int tablerow() {
		return utility.getTableRowCount(rowsize); //rowsize
	}
	
	public void impcontacts() {
		importcontacts.click();
	}
	
	public void fileuploadaction(String filepath) {
		utility.fileUpload(file, filepath);
		
	}
public void submitbutton() {
	buttonsubmit.click();
	
}
public String  alerthandle() {
	return utility.getTextofElement(alertmsg);
	
}


public String getsuppliername() {
	return utility.getTextofElement(suppliername);
}

public void giveSuppliernametoSearch(String name) {
	searchbarsuppliername.sendKeys(name);
}

public void actionbuttononSupplierName() {
	buttonforactionatsupplier.click();
	paydueamount.click();
}

public String gettextOfPaydueAmountpopup() {
	return utility.getTextofElement(textofpaydueamountpop);
}
}
