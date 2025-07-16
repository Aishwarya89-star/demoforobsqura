package testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageclasses.HomePage;
import com.pageclasses.LoginPage;
import com.pageclasses.UserManagementPage;

import baseclass.BaseClass;
import utilities.ExcelUtilities;
import utilities.RandomData_Utility;

public class HomePageTest extends BaseClass {
	
	LoginPage lp;
	HomePage hp;
  @Test(priority=0)
  public void verifyReachedUserManagementPage() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  
	  lp.login(ExcelUtilities.getStringData(0, 0, "LoginPage"),ExcelUtilities.getIntegerData(0, 1, "LoginPage"));
	  hp.clickonusermanagement();
	 String actual= hp.getTextofUsers();
	 System.out.println(actual);
	 Assert.assertTrue(actual.contains("Manage users"));
  }
  @Test(priority=1,groups = {"Groups1"})
  public void calculatorname() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	 
	  lp.login(ExcelUtilities.getStringData(0, 0, "LoginPage"),ExcelUtilities.getIntegerData(0, 1, "LoginPage"));
	  hp.clickonusermanagement();
	  hp.clickOnCalculator();
	  
	String actual= hp.addNumbersOnCalculator();
	System.out.println(actual);
	Assert.assertEquals(actual,String.valueOf(10));
	 
	 
  }
}
