package com.qa.pcs.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pcs.base.BaseClass;
import com.qa.pcs.utils.ExcelUtil;

public class UsermanagementPageTest extends BaseClass {
	
	@BeforeClass
	public void setUpUserManagement() {
		
		userpage=login.doLogin("adminUser");
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data=ExcelUtil.getTestData("UserManagement");
		return data;
	}
	
	@Test(dataProvider = "getData")
	public void userCreationTest(String firstName,String lastName,String emailID,String roleName,String storeName) {
		
		//userpage=login.doLogin("adminUser");
		Assert.assertTrue(userpage.userCreationSetUp(firstName,lastName ,emailID ,roleName ,storeName ), "User Creation is failed");
		
	}

}
