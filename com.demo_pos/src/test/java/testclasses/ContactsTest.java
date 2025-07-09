package testclasses;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageclasses.ContactsPage;
import com.pageclasses.HomePage;
import com.pageclasses.LoginPage;

import baseclass.BaseClass;
import constants.ConstantsClass;
import utilities.ExcelUtilities;

public class ContactsTest extends BaseClass {
	
	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
  @Test
  public void verifyReachedSupplierPage() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  cp=new ContactsPage(driver);
	  lp.login(ExcelUtilities.getStringData(0, 0, "LoginPage"),ExcelUtilities.getIntegerData(0, 1, "LoginPage"));
	  hp.clickonusermanagement();
	  cp.goToSupplierpage();
	  String actual=cp.getTextofSupplierPage();
	  System.out.println(actual);
	  Assert.assertTrue(actual.contains("All your Suppliers"));
  }
  @Test
  public void verifytogetRowCount() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  cp=new ContactsPage(driver);
	  lp.login(ExcelUtilities.getStringData(0, 0, "LoginPage"),ExcelUtilities.getIntegerData(0, 1, "LoginPage"));
	  hp.clickonusermanagement();
	  cp.goToSupplierpage();
	int count=cp.tablerow();
	System.out.println(count);
	Assert.assertEquals(count, 25);
  }
  @Test
  public void verifyFileUploadedfailedmsg() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  cp=new ContactsPage(driver);
	  lp.login(ExcelUtilities.getStringData(0, 0, "LoginPage"),ExcelUtilities.getIntegerData(0, 1, "LoginPage"));
	  hp.clickonusermanagement();
	  cp.goToSupplierpage();
	  cp.impcontacts();
	  cp.fileuploadaction(System.getProperty("user.dir")+ConstantsClass.propertiescsvfile);
	  cp.submitbutton();
	 String actual= cp.alerthandle();//warning
	  System.out.println(actual);
	  Assert.assertTrue(actual.contains("mismatch"));
	 
  }
  @Test
  public void VerifyforPaydueAmounttext() {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  cp=new ContactsPage(driver);
	  lp.login("admin", "123456");
	  hp.clickonusermanagement();
	  cp.goToSupplierpage();
	String actual=cp.getsuppliername();
	System.out.println(actual);
	cp.giveSuppliernametoSearch(actual);
	cp.actionbuttononSupplierName();
	String actualresult=cp.gettextOfPaydueAmountpopup();
	System.out.println(actualresult);
	Assert.assertTrue(actualresult.contains("Add"));
	  
  }
  
  
  
}
