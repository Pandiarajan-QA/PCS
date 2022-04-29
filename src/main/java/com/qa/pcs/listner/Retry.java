package com.qa.pcs.listner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	int count;
	int max_try=1;

	public boolean retry(ITestResult result) {
		
		if(!result.isSuccess()) {
			if(count<max_try) {
				
				count++;
				result.setStatus(ITestResult.FAILURE);
				return true;
			}else
				result.setStatus(ITestResult.FAILURE);
			
		}else
			result.setStatus(ITestResult.SUCCESS);
		
		return false;
	}

	
	

}
