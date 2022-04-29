package com.qa.pcs.factory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.pcs.utils.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	
	private WebDriver driver;
	OptionsManager options;
	public WebDriver browserSetup(String browserName,String Url) {
		
		Log.info("Browser setup method is invoked");

		options=new OptionsManager();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			//DesiredCapabilities cap=DesiredCapabilities.chrome();
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options.getChromeOption());
			Log.info("The selected browser is chrome and driver value is initialized with chrome driver");
			
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			Log.info("The selected browser is Firefox and driver value is initialized with Firefox driver");

		}else if (browserName.equalsIgnoreCase("IE")) {
			
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			Log.info("The selected browser is IE and driver value is initialized with IE driver");

		}else {
			System.out.println("Please enter the valid browser name");
		Log.error("Invalid brower value is passed");
		}
		driver.manage().window().maximize();
		Log.info("Browser is maximized");
		driver.manage().deleteAllCookies();
		Log.info("Cookie deletion is done");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Log.info("Time out of 30 seconds is given to the elements");
		driver.get(Url);
		Log.info("URL is launched");
		return driver;
	}
	
	
	  public void getScreenshot() {
	  
		  System.out.println(driver);
		  
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); String
	  path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis(
	  )+".png"; File destination=new File(path); try { FileUtils.copyFile(src,
	  destination); } catch (IOException e) { e.printStackTrace(); } }
	 
	}
	
	



