package com.qa.pcs.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarUtil {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void selectPastDate() throws Exception {

		String dateTobeSelected = "15-06-2022";
		try {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat dformat = new SimpleDateFormat("dd-MM-yyyy");
			dformat.setLenient(false);
			Date formattedDate = dformat.parse(dateTobeSelected);
			cal.setTime(formattedDate);
			int targetDay = cal.get(Calendar.DAY_OF_MONTH);
			int targetMonth = cal.get(Calendar.MONTH);
			int targetYear = cal.get(Calendar.YEAR);

			driver.findElement(By.id("second_date_picker")).click();
			String currentDayMonth = driver.findElement(By.className("ui-datepicker-title")).getText();
			Date formattedCurrentDayMonth = new SimpleDateFormat("MMM yyyy").parse(currentDayMonth);
			cal.setTime(formattedCurrentDayMonth);
			int currentMonth = cal.get(Calendar.MONTH);
			int currentYear = cal.get(Calendar.YEAR);

			while (targetMonth < currentMonth || targetYear < currentYear) {

				driver.findElement(By.xpath("//a/span[.='Prev']")).click();
				currentDayMonth = driver.findElement(By.className("ui-datepicker-title")).getText();
				formattedCurrentDayMonth = new SimpleDateFormat("MMM yyyy").parse(currentDayMonth);
				cal.setTime(formattedCurrentDayMonth);
				currentMonth = cal.get(Calendar.MONTH);
				currentYear = cal.get(Calendar.YEAR);
			}

			while (targetMonth > currentMonth || targetYear > currentYear) {

				driver.findElement(By.xpath("//a/span[.='Next']")).click();
				currentDayMonth = driver.findElement(By.className("ui-datepicker-title")).getText();
				formattedCurrentDayMonth = new SimpleDateFormat("MMM yyyy").parse(currentDayMonth);
				cal.setTime(formattedCurrentDayMonth);
				currentMonth = cal.get(Calendar.MONTH);
				currentYear = cal.get(Calendar.YEAR);
			}
			
			
			
			driver.findElement(By.xpath(
					"//table[@class='ui-datepicker-calendar']/tbody/tr//td[not(contains(@class,'ui-datepicker-other-month'))]//a[text()='"
							+ targetDay + "']"))
					.click();

		} catch (ParseException e) {
			throw new Exception("Given date is not valid. Please check the date once again");
		}

	}

}
