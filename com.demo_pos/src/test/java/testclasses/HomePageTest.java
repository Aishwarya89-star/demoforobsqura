package testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageclasses.HomePage;
import com.pageclasses.LoginPage;

import baseclass.BaseClass;
import utilities.ExcelUtilities;

public class HomePageTest extends BaseClass {
	
	LoginPage lp;
	HomePage hp;
  @Test
  public void verifyReachedUserManagementPage() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  
	  lp.login(ExcelUtilities.getStringData(0, 0, "LoginPage"),ExcelUtilities.getIntegerData(0, 1, "LoginPage"));
	  hp.clickonusermanagement();
	 String actual= hp.getTextofUsers();
	 System.out.println(actual);
	 Assert.assertTrue(actual.contains("Manage users"));
  }
}
