package dataprovider;

import org.testng.annotations.Test;

import utilities.ExcelUtilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
  

  @DataProvider(name="unsuccessfulLogin")
  public Object[][] dp() throws IOException {
    return new Object[][] {
      new Object[] { ExcelUtilities.getStringData(1, 0, "LoginPage"),ExcelUtilities.getIntegerData(1, 1, "LoginPage")},
      new Object[] { ExcelUtilities.getStringData(2, 0, "LoginPage"),ExcelUtilities.getIntegerData(2, 1, "LoginPage") },
      new Object[] {ExcelUtilities.getStringData(3, 0, "LoginPage"),ExcelUtilities.getStringData(3, 1, "LoginPage")},
    };
  }
}
