package com.qa.pcs.listner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.pcs.factory.BrowserFactory;
import com.qa.pcs.utils.Log;


public class TestListner implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		//System.out.println("The test method"+" "+ methodName+" "+"is running now");
		Log.onTestCaseStart(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		System.out.println("The test method"+" "+ methodName+" "+"is excecuted successfully and result is pass");
		
	}

	public void onTestFailure(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		System.out.println("The test method"+" "+ methodName+" "+"is excecuted successfully and result is fail");
BrowserFactory fac=new BrowserFactory();
//fac.getScreenshot();
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
			}

	public void onFinish(ITestContext context) {
		
		
	}
	
	
}
