package com.realreco.automation.testplans;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorsExample {

	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void Test001() throws InterruptedException {

		String str = driver.getTitle();
		System.out.println("Title of the page: " + str);
		Thread.sleep(1000);

		driver.findElement(RelativeLocator.with(By.linkText("Gmail")).toLeftOf(By.linkText("Images"))).click();
		Thread.sleep(3000);

	}

	@AfterMethod
	public void AfterMethod() {
		driver.quit();
	}
}