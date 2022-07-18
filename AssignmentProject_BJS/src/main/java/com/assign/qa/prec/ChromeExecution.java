package com.assign.qa.prec;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.assign.qa.base.TestBaseAssi;

public class ChromeExecution extends TestBaseAssi {
		
		@BeforeTest
		public void instantiateBrowser() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\CodeRepo\\AssignmentQATest\\AssignmentProject_BJS\\drivers\\UpdatedDrivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);
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
