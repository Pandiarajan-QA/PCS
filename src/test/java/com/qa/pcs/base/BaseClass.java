package com.qa.pcs.base;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.qa.pcs.factory.BrowserFactory;
import com.qa.pcs.pages.EnrollmentUploadPage;
import com.qa.pcs.pages.ForgotPasswordPage;
import com.qa.pcs.pages.LoginPage;
import com.qa.pcs.pages.StoreMaintenancePage;
import com.qa.pcs.pages.UserManagementPage;
import com.qa.pcs.utils.ExcelUtil;
import com.qa.pcs.utils.Log;
import com.qa.pcs.utils.PropertyUtil;

public class BaseClass {

	private WebDriver driver;
	public String sheetName;
	public PropertyUtil prop;
	public BrowserFactory bfactory;
	public LoginPage login;
	public UserManagementPage userpage;
	public ForgotPasswordPage forgot;
	public StoreMaintenancePage store;
	public EnrollmentUploadPage enroll;

	@Parameters({ "browserName" })
	@BeforeClass
	public void doApplicationLaunch(String browser) {
		System.out.println("Parent Class Before Class Method is running");
		prop = new PropertyUtil();
		Log.info("Property file is loaded");
		bfactory = new BrowserFactory();
		Log.info("Object is created for the class Browser Factory");
		driver = bfactory.browserSetup(browser, prop.getPropertyValue("URL"));
		Log.info("Driver value is initialized");
		// driver = bfactory.browserSetup(prop.getPropertyValue("browserName"),
		// prop.getPropertyValue("URL"));
		login = new LoginPage(driver);
		Log.info("Login page object reference is initialized");
	}

	//@AfterClass
	public void teardown() {

		driver.quit();
		Log.info("Browser is closed");
	}

	@AfterMethod
	public void getScreenshot(ITestResult result) {
		Log.info("Screenshot method is invoked");
		// System.out.println(driver);
		if (result.getStatus() == ITestResult.FAILURE) {
			Log.info("Screenshot process is started");
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
			Date date = new Date();
			String time = format.format(date);

			String path = System.getProperty("user.dir") + "\\screenshots\\" + result.getMethod().getMethodName() + time
					+ ".png";

			File destination = new File(path);
			try {
				FileUtils.copyFile(src, destination);
				Log.info("Screenshot is taken");
			} catch (IOException e) {
				e.printStackTrace();
				Log.error("Screenshot taken is failure");
			}

		}

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = ExcelUtil.getTestData(sheetName);
		return data;
	}
}
