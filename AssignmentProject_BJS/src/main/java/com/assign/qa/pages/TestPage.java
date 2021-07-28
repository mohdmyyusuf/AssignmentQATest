package com.assign.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assign.qa.base.TestBaseAssi;

public class TestPage extends TestBaseAssi {

	@FindBy(xpath = "//*[@id=\"identifierId\"]")
	WebElement userEmail;

	@FindBy(xpath = "//span[text()='Next']")
	WebElement nextToPswrdBtn;

	@FindBy(xpath = "//input[@class = 'whsOnd zHQkBf' and @type = 'password']")
	WebElement userPwrd;

	@FindBy(xpath = "(//span[@class = 'VfPpkd-vQzf8d'])[1]")
	WebElement nextafterPwrd;

	@FindBy(xpath = "//*[@id=\":1w\"]")
	WebElement primaryTab;

	@FindBy(xpath = "//*[@id=\"gb\"]//child::a[@class='gb_C gb_Ma gb_h']")
	WebElement gaccount;

	@FindBy(xpath = "(//span[@class = 'Dj']//descendant::span[@class = 'ts'])[3]")
	WebElement totalMailCount;

	List<WebElement> a = driver.findElements(By.xpath("//*[@class='yW']/span"));

	public TestPage() {
		PageFactory.initElements(driver, this);
	}

	public String validatePageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	public void enterEmail(String email) throws InterruptedException {
		userEmail.sendKeys(email);
		Thread.sleep(2000);
		nextToPswrdBtn.click();
	}

	public void enterPassword(String pswrd) throws InterruptedException {
		userPwrd.sendKeys(pswrd);
		Thread.sleep(2000);
		nextafterPwrd.click();
		Thread.sleep(3000);

	}

	public void moveToGmail() {

		gaccount.click();

	}

	public void verifyDefaultTab() {
		boolean flag = primaryTab.isEnabled();
		System.out.println(flag);
		if (flag) {
			String count = totalMailCount.getText();
			System.out.println("Total mails in inbox are " + count);

			System.out.println(a.size());
			for (int i = 0; i < a.size(); i++) {
				System.out.println(a.get(i).getText());
				if (a.get(i).getText().equals("Mohd Yusuf")) { // if u want to click on the specific mail then here u
																// can pass it
					a.get(i).click();
				}
			}
		} else {
			primaryTab.click();
		}
	}

	public String senderName() {
		WebElement mailName = driver.findElement(By.xpath("(//*[@class = 'yW'])[1]"));
		String sender = mailName.getText();
		
		return sender;
	}
	
	public String subjectLine() {
		WebElement subLine = driver.findElement(By.xpath("(//*[@class = 'bqe' ])[2]"));
		String sbjLine = subLine.getText();

		return sbjLine;
	}
}
