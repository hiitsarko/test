package com.arko.prac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CrossBrowserScript {
	WebDriver driver;

	@BeforeTest
	@org.testng.annotations.Parameters({"browser"})
	public void setup(String browser) throws Exception{
		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\server\\geckodriver.exe");
			//driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\server\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	@Test
	public void testParameterWithXML() throws InterruptedException{
		driver.get("https://www.google.co.in/");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@title='Search']"))));
		
		WebElement search = driver.findElement(By.xpath("//input[@title='Search']"));
		search.sendKeys("cognizant");

		WebElement enter = driver.findElement(By.xpath("//input[@value='Google Search']"));
		enter.click();
		
	}
	
	
	@AfterTest
	public void afterTest() {	 
		 driver.quit();
	}
	
}
