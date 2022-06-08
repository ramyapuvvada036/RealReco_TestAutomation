package com.realreco.automation.util;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.realreco.automation.basetest.BaseTest;

public class WebUtil extends BaseTest {
	
	/**
	 * @author Ramya Puvvada
	 * @throws Exception
	 */

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	public WebUtil() throws IOException {
		super();
	}

	public void clickElement(By element, WebDriver driver) throws InterruptedException {

		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(element));
		ele.click();

	}

	public void inputText(By element, String text, WebDriver driver) throws Exception {
		WebElement inputText = wait.until(ExpectedConditions.presenceOfElementLocated(element));
		System.out.println("expected text to input: " + text);
		String value = "";
		int i = 0;
		do {
			inputText.clear();
			inputText.sendKeys(text);
			Thread.sleep(1000);
			value = inputText.getAttribute("value").toString();
			System.out.println("actual text in textbox: " + value);
			i++;
			if (i > 50) {
				throw new Exception("WebUtil.inputText: input string still mismatch after 50 tries");
			}
		} while (!(value.toLowerCase().equals(text.toLowerCase())));
	}

	public String getText(By element, WebDriver driver) {
		WebElement inputText = wait.until(ExpectedConditions.presenceOfElementLocated(element));
		return inputText.getText();

	}

	public void scrollToElement(By selector, WebDriver driver) throws Exception {
		WebElement dom = wait.until(ExpectedConditions.presenceOfElementLocated(selector));
		JavascriptExecutor jsExe = (JavascriptExecutor) driver;
		jsExe.executeScript("arguments[0].scrollIntoView(true);", dom);
	}

	public void waitForVieworTab(By element, WebDriver driver) {
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}

	public void invisibilityOfElement(By element, WebDriver driver) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}

	public void waitForVieworTab_Longer(By element, WebDriver driver) throws Exception {
		// new WebDriverWait(driver,10000,10000).until(ExpectedConditions
		// .presenceOfElementLocated(element));
		//
		Thread.sleep(5000);
	}

	public void waitFor(int milliSeconds) throws Exception {
		Thread.sleep(milliSeconds);
	}

	public void rightClick(By element, WebDriver driver) {
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(element));
		Actions act = new Actions(driver);
		act.contextClick(ele).build().perform();
		/*new WebDriverWait(driver, 2000);*/
	}

	public void set30DaysInDateRange(WebDriver driver) {
		wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector(".daterangepicker.active-daterangepicker li[data-range-key='30D']"))).click();
	}

	public void set90DaysInDateRange(WebDriver driver) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector(".daterangepicker.active-daterangepicker li[data-range-key='90D']"))).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.cssSelector(".daterangepicker.active-daterangepicker li[data-range-key='90D']")));
		Thread.sleep(3000);
	}

}
