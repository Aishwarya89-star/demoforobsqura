package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	
	WebDriverWait wait;
	
public void waitForElementToBeClickableByXpathLocator_Utility(WebDriver driver,String locatorValue,int timeOut) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
	}


public void waitForElementToBeClickableBycssSelector_Utility(WebDriver driver,String locatorValue,int timeOut) {
	
	wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorValue)));
}

public void waitForElementToBeClickableByWebElement_Utility(WebDriver driver,int timeOut,WebElement element) {
	
	wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
public void waitForElementToBeVisiblet_Utility(WebDriver driver,int timeOut,WebElement element) {
	
	wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	wait.until(ExpectedConditions.elementToBeSelected(element));
}

public void waitForElementToBeVisibilityOf(WebDriver driver,int timeOut,WebElement element) {
	
	wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	wait.until(ExpectedConditions.visibilityOf(element));
}
public void waitForVisibilityOfelementLocated(WebDriver driver,int timeOut,By locator) {
	wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}

public void presenceOfElement(WebDriver driver,int timeOut,By locator) {
	
	wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}

public void waitForWebElementOfalert(WebDriver driver, int timeout,WebElement element) {
	wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	
}



public void fluentWaitForElementtoBeClickableByIdLocator_Utility(WebDriver driver,String locatorValue,int totalTimeOut,int pollingTimeOut ) {
	
	FluentWait<WebDriver> wait = new FluentWait<> (driver)
			.withTimeout(Duration.ofSeconds(totalTimeOut))
			.pollingEvery(Duration.ofSeconds(pollingTimeOut))
			.ignoring(NoSuchElementException.class);
	
	wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
}
}



