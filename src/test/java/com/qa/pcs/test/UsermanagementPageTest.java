package com.qa.pcs.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pcs.base.BaseClass;
import com.qa.pcs.utils.ExcelUtil;
import com.qa.pcs.utils.Log;

public class UsermanagementPageTest extends BaseClass {
	
	@BeforeClass
	public void setUpUserManagement() {
		Log.info("SetupUserManagement method is invoked");
		//System.out.println("User Managerment Class before class method is running");
		userpage=login.doLogin("adminUser");
		Log.info("Login method is invoked");
		userpage.navigateToUserManagementAddPage();
		sheetName="UserManagement";
	}
	
	/*
	 * @DataProvider public Object[][] getData() {
	 * 
	 * Object[][] data=ExcelUtil.getTestData("UserManagement"); return data; }
	 */
	
	/*
	 * @Test(dataProvider = "getData") public void userCreationTest(String
	 * firstName,String lastName,String emailID,String roleName,String storeName) {
	 * Log.onTestCaseStart("UserCreationTest");
	 * //userpage=login.doLogin("adminUser");
	 * Assert.assertTrue(userpage.userCreationSetUp(firstName,lastName ,emailID
	 * ,roleName ,storeName ), "User Creation is failed");
	 * Log.onTestCaseEnd("UserCreationTest"); }
	 */
	@Test(dataProvider = "getData",priority = 1)
	public void userCreationTest(String[]value) {
		//Log.onTestCaseStart("UserCreationTest");
		//userpage=login.doLogin("adminUser");
		Assert.assertTrue(userpage.userCreationSetUp(value[0],value[1] ,value[2] ,value[3] ,value[4] ), "User Creation is failed");
		Log.onTestCaseEnd("UserCreationTest");
	}
	@Test(dataProvider = "getData",priority = 2)
	public void editUserTest(String[]value) {
		
		userpage.editUserDetails(value[5],value[6]);
	}

}
