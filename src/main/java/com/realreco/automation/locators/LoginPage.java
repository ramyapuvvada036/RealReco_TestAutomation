package com.realreco.automation.locators;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.realreco.automation.basetest.BaseTest;

public class LoginPage extends BaseTest {

	public LoginPage(WebDriver driver) throws IOException {
		super();
	}

	//Login Page
	//public By USERNAME = By.xpath("//input[@id='username']");
	public By USERNAME = By.xpath("//input[@id='username']");
	public By PASSWORD = By.xpath("//input[@name='password']");
	public By LOGIN = By.xpath("//*[@type='submit']");
	public By RRLOGO = By.xpath("//img[@class='user-image']");

}