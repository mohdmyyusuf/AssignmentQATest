package com.assign.qa.base.reruntests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.beust.testng.TestNG;

public class FailedTestsExecuter {
	
	@Test
	public void runFailedTests() {
		
		@SuppressWarnings("deprecation")
		TestNG runner  = new TestNG();
		List<String> li = new ArrayList<String>();
		li.add("D:\\codeRepository\\AssignmentCode\\AssignmentProject_RestAssured\\test-output\\testng-failed.xml");
		runner.setTestSuites(li);
		runner.run();
	}

}
