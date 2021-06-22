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
	
	@Test(testName = "verify Data Created", priority = 2)
	public void verifyDataCreated() throws InterruptedException
	{
		testPageobj.createTestItem("Test");
		//Assert.assertEquals(prop.getProperty("pagetitle"), title);
	}
	
	@Test(testName = "verify Data Classification", priority = 3)
	public void verifyDataClassification() throws InterruptedException  
	{
		testPageobj.verifyClassifications("Test");
		//Assert.assertEquals(prop.getProperty("pagetitle"), title);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
