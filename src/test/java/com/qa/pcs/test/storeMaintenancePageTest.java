package com.qa.pcs.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.pcs.base.BaseClass;

public class storeMaintenancePageTest extends BaseClass {

	@BeforeClass
	public void storePageSetup() {
		userpage=login.doLogin("adminUser");
		store = userpage.navigateToStoreMaintenancePage();
		sheetName="StoreManagement";

	}

	@Test(dataProvider = "getData")
	public void storeCreationTest(String[]value) {

		Assert.assertTrue(
				store.doStoreCreation(value[0], value[1],value[2], value[3], value[4], value[5], value[6]),
				"Store creation is failed");

	}

}
