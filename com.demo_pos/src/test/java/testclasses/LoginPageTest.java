package testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageclasses.HomePage;
import com.pageclasses.LoginPage;
import com.pageclasses.UserManagementPage;

import baseclass.BaseClass;
import dataprovider.DataProviderClass;
import utilities.ExcelUtilities;





public class LoginPageTest extends BaseClass {
	
	LoginPage lp;
	HomePage hp;
	UserManagementPage up;
	
  @Test(priority=3)
  public void verifySuccessfulLogin() throws IOException {
	  lp=new LoginPage(driver);
	hp= lp.login(ExcelUtilities.getStringData(0, 0, "LoginPage"),ExcelUtilities.getIntegerData(0, 1, "LoginPage"));
	  hp=new HomePage(driver);
	  String actual=hp.getTextofWelcome();
	  System.out.println(actual);
	  Assert.assertTrue(actual.contains("Welcome admin,"));
  }
  @Test(dataProvider="unsuccessfulLogin",dataProviderClass=DataProviderClass.class,priority=4)
  public void verifyUnsuccessfulLogin(String n,String s ){
	  lp=new LoginPage(driver);
	  lp.login(n,s);
	  String actual=lp.getErrorMessage();
	  System.out.println(actual);
	  Assert.assertEquals(actual, "These credentials do not match our records.");
	  
  }
  @Test(priority=0)
  public void verifyLogoDisplayed() {
	  lp=new LoginPage(driver);
	 boolean bool= lp.logoDisplayed();
	 System.out.println(bool+  "  Logo got displayed");
	  
  }
  @Test(priority=1)
    
  public void verifyTitleofthePage() throws IOException {
	  lp=new LoginPage(driver);
	  String actual=lp.getTitleofthePage();
	  System.out.println(actual);
	  Assert.assertTrue(actual.contains(ExcelUtilities.getStringData(0, 0, "Title")));
  }
  @Test(priority=2)
  public void verifyIstheremembermecheckboxenaled() {
	  lp=new LoginPage(driver);
	  boolean bool=lp.checkboxenabled();
	  System.out.println(bool);
	  Assert.assertTrue(bool);
  }
}
