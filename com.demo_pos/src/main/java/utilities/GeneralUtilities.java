package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	// driver commands
	public String getUrlmethod(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getTitleOfUrl(WebDriver driver) {

		return driver.getTitle();
	}

	public String getTextofElement(WebElement element) {
		return element.getText();

	}

	public String getAttributeOfElement(WebElement element, String name) {
		return element.getAttribute(name);

	}

	// boolean functions

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();

	}

	public boolean isElementSelected(WebElement element) {
		return element.isSelected();

	}

	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();

	}

	// Dropdowns

	public void selectByValue(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectByContainVisibletext(WebElement element, String text) {

		Select select = new Select(element);
		select.selectByContainsVisibleText(text);
	}

	public void selectByIdOfElement(WebDriver driver, String id, String value) {
		WebElement element = driver.findElement(By.id(id));
		Select select = new Select(element);
		select.selectByValue(value);

	}

	public void deSelectByIndexOfElement(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);

	}

	public void deSelectByvalueOfElement(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);

	}

	public void deSelectByvalueVisibleTextSelect(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);

	}

	public void deSelectByContainVisibleTextSelect(WebElement element, String text) {
		Select select = new Select(element);
		select.deSelectByContainsVisibleText(text);

	}

	public boolean isMultiselect(WebElement element) {

		Select select = new Select(element);
		return select.isMultiple();
	}

	public List<String> getalldropdownOptions(WebElement element) {
		Select select = new Select(element);
		return select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public List<String> getAllSelectedOptions_utility(WebElement element) {
		Select select = new Select(element);
		return select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());

	}

	public List<String> getOptions(WebElement element) {
		Select select = new Select(element);
		select.selectByIndex(0);
		select.selectByIndex(1);
		// select2.deselectByIndex(1);
		select.getAllSelectedOptions();
		List<WebElement> ele = select.getOptions();
		List<String> optiontext = new ArrayList<String>();
		for (WebElement option : ele) {

			optiontext.add(option.getText());

		}
		return optiontext;

	}
	


	// frame commands
	public void switchToFrameByNameOrID_Utility(WebDriver driver, String NameOrID) {
		driver.switchTo().frame(NameOrID);
	}

	public void switchToFrameByLocator(WebDriver driver, WebElement element) {

		driver.switchTo().frame(element);

	}

	public void addSleep(long timeOut) throws InterruptedException {
		Thread.sleep(timeOut);
	}

	// alert commands

	public void alertaccept(WebDriver driver) {
		driver.switchTo().alert().accept();

	}

	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();

	}

	public void swithDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();

	}

	public String getTextofAlertMessage(WebDriver driver) {
		return driver.switchTo().alert().getText();

	}

//Actions methods

	public void mouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	public void mouseHoverandClick_utility(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}

	public void keyDown(WebElement element) {
		element.sendKeys(Keys.DOWN);
	}

	public void dblClick(WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick();

	}

	public void dblClickwithElement(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick(element);

	}

	public void dragAndDrop(WebElement source, WebElement target, WebDriver driver) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();

	}

	public void keyUp(WebElement element) {
		element.sendKeys(Keys.UP);
	}

	// filepath

	public void fileUpload(WebElement element, String filepath) {
		element.sendKeys(filepath);

	}
	
	//***********************************JavaScript*******************************************//
		public void clickUsingJavaScriptExecutor_Utility(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}

		public void scrollUsingJavaScriptExecutor_Utility(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);// page scrolls still we get an elemnt scroll by
																		// elememn also there
		}

		public void scrollUsingJavaScriptExecutor_UtilityScrolby(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");

		}
		//table
		public static int getTableRowCount(WebElement tableElement,String locator) {
		  //  List<WebElement> rows = tableElement.findElements(By.xpath("//table[@id='contact_table']/tbody/tr"));
		    List<WebElement> rows = tableElement.findElements(By.xpath(locator));
		    int rowCount = rows.size();
		    System.out.println("Row count: " + rowCount);
		    return rowCount;
		}
	    }



