package com.qa.pcs.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.pcs.base.BaseClass;

public class EnrollmentUploadPageTest extends BaseClass{
	
	
	@BeforeClass
	public void EnrollmentPageSetup() {
		
		userpage=login.doLogin("storeUser");
		enroll=userpage.navigateToEnrollmentUploadPage();
		
	}
	@Test
	public void enrollmentUploadTest() throws Exception {
		
		Assert.assertTrue(enroll.doFileUpload("D:\\Selenium\\AutoIT\\FileUploadScript1.exe"+" "+"C:\\Users\\pandiarajang\\Desktop\\download.jpg"), "File Upload is failed");
	}

}
