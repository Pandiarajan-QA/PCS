package com.qa.pcs.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.pcs.base.BaseClass;

public class ForgotPassowrdPageTest extends BaseClass {
	@BeforeClass
	public void setUpForgotPassword() {

		forgot = login.navigateToForgotPwdPage();
	}

	@Test
	public void passwordResetTest() {

		// forgot=login.navigateToForgotPwdPage();
		Assert.assertTrue(forgot.doResetPwd("mageshn@srmtech.com"), "Forgot Password Test is failed");
	}

}
