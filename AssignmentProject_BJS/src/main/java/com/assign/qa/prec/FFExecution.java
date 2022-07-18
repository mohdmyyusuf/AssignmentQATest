package com.assign.qa.prec;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.assign.qa.base.TestBaseAssi;

public class FFExecution extends TestBaseAssi {
	
	@BeforeTest
	public void instantiateBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\Desktop\\CodeRepo\\AssignmentQATest\\AssignmentProject_BJS\\drivers\\geckodriver.exe");
		DesiredCapabilities capab = new DesiredCapabilities().firefox();
		capab.setCapability("marionette", true);
		driver = new FirefoxDriver(capab);
		driver = new FirefoxDriver();
	}
	
	@Test(testName = "launch the url")
	public void launchUrl() {
		driver.get("https://www.demoqa.com");
		
	}

	@AfterTest
    public void afterTest() {
	 System.out.println("Closing the browser ");
	 driver.close();
    }
}
