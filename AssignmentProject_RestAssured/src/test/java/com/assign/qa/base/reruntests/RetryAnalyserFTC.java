package com.assign.qa.base.reruntests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserFTC implements IRetryAnalyzer{

	int counter = 0;
	int retryLimit = 2;
	@Override
	public boolean retry(ITestResult result) {
		if(counter<retryLimit) {
			counter++;
			System.out.println("Running the "+counter + " time");
			return true;			
		}
		else {
			return false;
		}
	}

}
