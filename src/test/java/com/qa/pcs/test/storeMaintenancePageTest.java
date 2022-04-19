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

	}

	@Test
	public void storeCreationTest() {

		Assert.assertTrue(
				store.doStoreCreation("SRMTest", "Ekkaduthangal", "9876543210", "123456", "Chennai", "test@test.com"),
				"Store creation is failed");

	}

}
