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

public class UserManagementTest extends BaseClass {
	
	LoginPage lp;
	HomePage hp;
	UserManagementPage up;
  @Test
  public void verifyForAdduserstext() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  up=new UserManagementPage(driver);
	  lp.login(ExcelUtilities.getStringData(0, 0, "LoginPage"),ExcelUtilities.getIntegerData(0, 1, "LoginPage"));
	  hp.clickonusermanagement();
	  up.clickonAddUser();
	  String actual=up.addUserGetText();
	  System.out.println(actual);
	  Assert.assertTrue(actual.contains("Add user"));
  }
  
  @Test
  
  public void verifynewuserCreated() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  up=new UserManagementPage(driver);
	  lp.login(ExcelUtilities.getStringData(0, 0, "LoginPage"),ExcelUtilities.getIntegerData(0, 1, "LoginPage"));
	  hp.clickonusermanagement();
	  up.clickonAddUser();
	  String prefix=RandomData_Utility.getPrefix();
	  String fname=RandomData_Utility.getFirstname();
	  String lname=RandomData_Utility.getLastname();
	  String password=RandomData_Utility.getPassword();
	  String email=RandomData_Utility.getEmail();
	  up.newUserCreation(prefix, fname, email,password, password);
	  up.searchUser(fname);
	  String actual=up.textGotPopulated();
	  System.out.println(actual);
	  Assert.assertTrue(actual.contains(fname));
	  
	  
  }
}
