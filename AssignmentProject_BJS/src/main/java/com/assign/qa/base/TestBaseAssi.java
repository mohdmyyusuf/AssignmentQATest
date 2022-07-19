package com.assign.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import Utils.TimeOutsExplicit;
import io.github.sukgu.Shadow;

public class TestBaseAssi {

	public static WebDriver driver;
	public static Properties prop;

	public TestBaseAssi() {
		prop = new Properties();
		try {
			FileInputStream fistr = new FileInputStream(
					"C:\\Users\\user\\Desktop\\CodeRepo\\AssignmentQATest\\AssignmentProject_BJS\\src\\main\\java\\com\\assign\\qa\\config\\config.properties");
			prop.load(fistr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("ff")) {

			System.setProperty("webdriver.gecko.driver", prop.getProperty("ffpath"));
			DesiredCapabilities capab = new DesiredCapabilities().firefox();
			capab.setCapability("marionette", true);
			driver = new FirefoxDriver(capab);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeOutsExplicit.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeOutsExplicit.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));

	}
	
	public WebElement expandHost(WebElement element, WebDriver driver) {
		WebElement ele = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",
				element);
		return ele;
	}
	
	public WebElement shadowElementEtender(String locator) {
		Shadow shadow = new Shadow(driver);
		WebElement element = shadow.findElement(locator);
		return element;
	}
	
	

}
