package com.qa.pcs.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.pcs.utils.Constants;
import com.qa.pcs.utils.ElementUtil;
import com.qa.pcs.utils.PropertyUtil;

public class LoginPage {

	private WebDriver driver;
	ElementUtil eutil;

	private By username = By.xpath("//div//input[@name='user-name']");
	private By password = By.xpath("//div//input[@name='password']");
	private By login_btn = By.xpath("//div[text()='Login']");
	private By logo = By.xpath("(//a/img)[2]");
	private By forgot_pwd_link = By.xpath("//a[contains(text(),'Forgot')]");

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		eutil = new ElementUtil(driver);
	}

	/*
	 * public boolean loginTestSetup(String roleType) {
	 * 
	 * String uname=getLoginCredentials().get(roleType).split(":")[0]; String
	 * pwd=getLoginCredentials().get(roleType).split(":")[1];
	 * 
	 * eutil.doSendKeys(username, uname); eutil.doSendKeys(password, pwd);
	 * eutil.doClickWhenReady(login_btn, 5);
	 * 
	 * if(eutil.GetElement(logo).isDisplayed()) return true; else return false; }
	 */

	public UserManagementPage doLogin(String roleType) {

		String uname = getLoginCredentials().get(roleType).split(":")[0];
		String pwd = getLoginCredentials().get(roleType).split(":")[1];

		eutil.doSendKeys(username, uname);
		eutil.doSendKeys(password, pwd);
		eutil.doClickWhenReady(login_btn, 5);
		return new UserManagementPage(driver);

	}

	public boolean doCheckLogo() {

		return eutil.GetElement(logo).isDisplayed();
	}

	public boolean doCheckForgotPwdLink() {

		return eutil.GetElement(forgot_pwd_link).isDisplayed();
	}

	public ForgotPasswordPage navigateToForgotPwdPage() {

		eutil.GetElement(forgot_pwd_link).click();
		return new ForgotPasswordPage(driver);
	}

	public String doCheckTitle() {

		String title = driver.getTitle();
		return title;
	}

	public HashMap<String, String> getLoginCredentials() {

		PropertyUtil prop = new PropertyUtil();

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("adminUser", prop.getPropertyValue("adminUser"));
		map.put("storeUser", prop.getPropertyValue("storeUser"));
		map.put("dataCentre", prop.getPropertyValue("dataCentre"));
		return map;
	}

}
