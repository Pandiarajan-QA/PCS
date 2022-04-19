package com.qa.pcs.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	
	WebDriver driver;
	OptionsManager options;
	public WebDriver browserSetup(String browserName,String Url) {
		

		options=new OptionsManager();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			//DesiredCapabilities cap=DesiredCapabilities.chrome();
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options.getChromeOption());
			
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("IE")) {
			
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}else
			System.out.println("Please enter the valid browser name");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(Url);
		return driver;
	}
	


}
