package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CalenderUtility {
	 public static void selectDate(WebElement calendarWidget, String dateToSelect) {
	        List<WebElement> allDates = calendarWidget.findElements(By.xpath(".//td[not(contains(@class, 'disabled')) and text()='" + dateToSelect + "']"));

	        for (WebElement date : allDates) {
	            if (date.isDisplayed()) {
	                date.click();
	                break;
	            }
	        }
	    }
	 public static String getTodayDate(String format) {
	        LocalDate today = LocalDate.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
	        return today.format(formatter);
	   }   
}
