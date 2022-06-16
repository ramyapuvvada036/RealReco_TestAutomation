package com.realreco.automation.testplans;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Window_Tab_Functionalities {

	public static WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void beforeMethod()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://testproject.io/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Title of the page is: "+driver.getTitle());
	}

	@Test
	public void f() {
		WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
		newWindow.get("https://blog.testproject.io/");
		System.out.println("Title of the page is: "+driver.getTitle());
	}
	
	@AfterMethod
	public void afterMethos()
	{
		driver.quit();
	}
}