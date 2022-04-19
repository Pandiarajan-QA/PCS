package com.qa.pcs.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.qa.pcs.factory.BrowserFactory;
import com.qa.pcs.pages.EnrollmentUploadPage;
import com.qa.pcs.pages.ForgotPasswordPage;
import com.qa.pcs.pages.LoginPage;
import com.qa.pcs.pages.StoreMaintenancePage;
import com.qa.pcs.pages.UserManagementPage;
import com.qa.pcs.utils.PropertyUtil;


public class BaseClass {

	private WebDriver driver;

	public PropertyUtil prop;
	public BrowserFactory bfactory;
	public LoginPage login;
	public UserManagementPage userpage;
	public ForgotPasswordPage forgot;
	public StoreMaintenancePage store;
	public EnrollmentUploadPage enroll;

	@Parameters({"browserName"})
	@BeforeTest
	public void doApplicationLaunch(String browser) {

	
		
		prop = new PropertyUtil();
		bfactory = new BrowserFactory();
		driver = bfactory.browserSetup(browser, prop.getPropertyValue("URL"));
		//driver = bfactory.browserSetup(prop.getPropertyValue("browserName"), prop.getPropertyValue("URL"));
		login = new LoginPage(driver);
	}

	
	@AfterTest
	public void teardown() {
		driver.quit();

	}
}
