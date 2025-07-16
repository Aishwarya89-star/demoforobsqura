package baseclass;

import org.testng.annotations.Test;

import constants.ConstantsClass;
import extentReport.ExtentManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	public static WebDriver driver;
	public static Properties property;

	public static void readproperty() throws IOException {
		property = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + ConstantsClass.propertiesfilepath);
		property.load(file);
	}

	@Parameters("browser")
	@BeforeMethod(groups = { "TearUp" })
	public void beforeMethod(String browserValue) throws IOException {
		readproperty();
		if (browserValue.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (browserValue.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();

		} else {
			throw new IllegalArgumentException("Invalid Browser  " + browserValue);

		}

		driver.get(property.getProperty("base_url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(ConstantsClass.implicitwaittimeOut));

	}

	@AfterMethod(groups = { "TearDown" })
	public void afterMethod() {
		driver.quit();
	}

	@BeforeSuite(alwaysRun = true)
	public void createReport() {
		ExtentManager.createInstance();
	}

}
