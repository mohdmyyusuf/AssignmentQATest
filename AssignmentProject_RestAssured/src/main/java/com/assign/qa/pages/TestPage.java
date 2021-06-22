package com.assign.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assign.qa.base.TestBaseAssi;

public class TestPage extends TestBaseAssi{
	
	@FindBy(xpath = "//input[@class ='new-todo']")
	WebElement searchBar;
	
	@FindBy(xpath = "//input[@class = 'toggle']")
	WebElement checkBox;
	
	@FindBy(xpath = "/html/body/section/div/footer/span/strong")
	WebElement count;
	
	@FindBy(xpath = "(//li[1]/a)[3]")
	WebElement allLink;
	
	@FindBy(xpath = "(//li[2]/a)[3]")
	WebElement activeLink;
	
	@FindBy(xpath = "(//li[3]/a)[3]")
	WebElement completeLink;
	
	
	
	
	
	public TestPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public void createTestItem(String data) throws InterruptedException {
		searchBar.sendKeys(data);
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		if(checkBox.isEnabled()) {
			System.out.println(count.getText()+" New item has been created...");
			
		}
		else {
			System.out.println("The data is not there...");
		}
	}
	
	public void verifyClassifications(String data) throws InterruptedException {
		searchBar.sendKeys(data);
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		if(checkBox.isEnabled()) {
			
			String linkall = allLink.getText();
			System.out.println(linkall);
			System.out.println(activeLink.getText());
			System.out.println(completeLink.getText());
		}
	}

}
