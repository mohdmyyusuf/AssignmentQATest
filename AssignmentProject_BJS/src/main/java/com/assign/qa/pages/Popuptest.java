package com.assign.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.assign.qa.base.TestBaseAssi;

public class Popuptest extends TestBaseAssi {

	Popuptest() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "")
	WebElement testName;

	@Test(testName = "verify handles", priority = 1)
	public void testWindowHandles(){
		String parent = driver.getWindowHandle();
	Set<String> child = driver.getWindowHandles();
	Iterator <String> whs = child.iterator();

	while(whs.hasNext())
	{
		String childWin = whs.next();
		if(!parent.equals(childWin)) {
			
			driver.switchTo().window(childWin);
			
			
		}
	}
	}
	
	@Test(testName = "test popups", priority = 2, enabled = false)
	public void testPopups() {
		Alert alert = driver.switchTo().alert();
		String msg = driver.switchTo().alert().getText();
		driver.switchTo().alert().sendKeys("test message");
		alert.accept();
		alert.dismiss();
		driver.switchTo().defaultContent();
		
	}
	
	@Test(testName = "frame test", priority = 3, groups = {"test"} )
	public void frameTest() {
		driver.switchTo().frame(0);
		
	}

}
