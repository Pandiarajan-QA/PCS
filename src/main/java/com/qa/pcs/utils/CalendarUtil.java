package com.qa.pcs.utils;

<<<<<<< HEAD
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarUtil {
	
	WebDriver driver;
	@BeforeMethod
	public void setup(String url) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}
=======
public class CalendarUtil {
>>>>>>> 6119fc469ad6fcea5576af36e888485d86157fd0

}
