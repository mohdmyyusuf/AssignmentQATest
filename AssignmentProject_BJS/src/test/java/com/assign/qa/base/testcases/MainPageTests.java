package com.assign.qa.base.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assign.qa.base.TestBaseAssi;
import com.assign.qa.pages.TestPage;


public class MainPageTests extends TestBaseAssi{

	TestPage testPageobj;
	public MainPageTests(){
		super();
	}
	
	@BeforeMethod
	public void setUpTests() {
		initialization();
		testPageobj = new TestPage();
	}
	
	@Test(testName ="verify Home Page Title Test", priority = 1)
	public void verifyHomePageTitleTest()
	{
		String title = testPageobj.validatePageTitle();
		Assert.assertEquals(prop.getProperty("pagetitle"), title);
	}
	
	@Test(testName = "verify login functionality", priority = 2)
	public void verifyDefaultTabSelected() throws InterruptedException
	{
		String email = prop.getProperty("email");
		String pwd = prop.getProperty("password");
		testPageobj.enterEmail(email);
		testPageobj.enterPassword(pwd);
		testPageobj.verifyDefaultTab();
		String sender = testPageobj.senderName();
		String subj = testPageobj.subjectLine();
		System.out.println("Sender of the email is "+sender);
		System.out.println("The subject line of the email is "+subj);
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
