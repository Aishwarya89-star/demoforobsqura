package baseclass;

import org.testng.annotations.Test;

import constants.ConstantsClass;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	public WebDriver driver;
	public static Properties property;
	
	public static void readproperty() throws IOException {
		property=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+ConstantsClass.propertiesfilepath);
		property.load(file);
	}
 
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  readproperty();
	  driver=new ChromeDriver();
	  driver.get("https://qalegend.com/billing/public/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  //driver.close();
  }

}
