package com.assign.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assign.qa.base.TestBaseAssi;

public class Popuptest extends TestBaseAssi{
	
	Popuptest(){
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "")
	WebElement testName;
	
}
