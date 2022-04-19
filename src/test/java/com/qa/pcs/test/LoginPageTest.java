package com.qa.pcs.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pcs.base.BaseClass;
import com.qa.pcs.utils.Constants;

public class LoginPageTest extends BaseClass{
	
	@BeforeClass
	public void classNameDisplay() {
		
		System.out.println("LoginPageTest class methods are executing now");
	}

	@Test
	public void loginTest() {
		
		userpage=login.doLogin("adminUser");
		boolean logo_presence_status=login.doCheckLogo();
		Assert.assertTrue(logo_presence_status);
	}
	@Test
	public void forgotPasswordLinkTest() {
		
		boolean status=login.doCheckForgotPwdLink();
		Assert.assertTrue(status);
	}
	@Test
	public void titleTest() {
		
		String actual_title=login.doCheckTitle();
		Assert.assertEquals(actual_title, Constants.LOGIN_PAGE_TITLE, "Title is not displayed as expected");
	}
}
