package com.assign.qa.prec;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.assign.qa.base.TestBaseAssi;

public class ParellelTests extends TestBaseAssi {

	ParellelTests(){
		PageFactory.initElements(driver, this);
	}
	
	@Test(testName = "test one")
	public void testOne() {
		System.out.println("test one executing");
		System.out.println("----------------------------");
	}

	@Test(testName = "test two")
	public void testTwo() {
		System.out.println("test two executing");
		System.out.println("----------------------------");
	}
	
	@Test(testName = "test three")
	public void testThree() {
		System.out.println("test three executing");
		System.out.println("----------------------------");
	}
	@Test(testName = "test four")
	public void testFour() {
		System.out.println("test four executing");
		System.out.println("----------------------------");
	}
	@Test(testName = "test five")
	public void testFive() {
		System.out.println("test five executing");
		System.out.println("----------------------------");
	}
	
}
