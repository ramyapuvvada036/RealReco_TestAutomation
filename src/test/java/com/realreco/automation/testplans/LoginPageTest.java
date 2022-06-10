package com.realreco.automation.testplans;

import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.realreco.automation.basetest.BaseTest;
import com.realreco.automation.locators.LoginPage;
import com.realreco.automation.util.DataReader;
import com.realreco.automation.util.WebUtil;

public class LoginPageTest extends BaseTest {

	LoginPage loginPage = new LoginPage(driver);
	com.realreco.automation.util.WebUtil util;

	public LoginPageTest() throws IOException {
		super();
	}

	private HashMap<String, HashMap<String, String>> testdatamap = new HashMap<String, HashMap<String, String>>();
	private HashMap<String, String> testcaseData;

	@BeforeMethod
	public void readDataFromExcel() throws Exception {
		initialization();
		Thread.sleep(2000);
		testdatamap = DataReader.readData("Sheet1");
	}

	@Test
	public void SuperAdminLoginTest() throws Exception {

		testcaseData = testdatamap.get("SuperAdminLoginTest");

		String Username = DataReader.getData(testcaseData, "Username");
		String Password = DataReader.getData(testcaseData, "Password");

		util = new WebUtil();
		util.inputText(loginPage.USERNAME, Username, driver);
		util.inputText(loginPage.PASSWORD, Password, driver);
		util.clickElement(loginPage.LOGIN, driver);
		Thread.sleep(2000);

		if (driver.getPageSource().contains("Create Organization")) {
			System.out.println("Login done as RVADMIN");
			System.out.println("Login done as RVADMIN");
		} else {
			System.out.println("RVADMIN Login Failed");
		}
		Thread.sleep(1000);
	}

	@Test
	public void AdminLoginTest() throws Exception {

		testcaseData = testdatamap.get("AdminLoginTest");

		String Username = DataReader.getData(testcaseData, "Username");
		String Password = DataReader.getData(testcaseData, "Password");

		util = new WebUtil();
		util.inputText(loginPage.USERNAME, Username, driver);
		util.inputText(loginPage.PASSWORD, Password, driver);
		util.clickElement(loginPage.LOGIN, driver);
		Thread.sleep(2000);

		if (driver.getPageSource().contains("ORG_ADMIN")) {
			//System.out.println("Login done as Admin");
			System.out.println("Login done as Admin");
		} else {
			//System.out.println("Admin Login Failed");
			System.out.println("Admin Login Failed");
		}
		Thread.sleep(1000);
	}

	@Test
	public void ASMLoginTest() throws Exception {

		testcaseData = testdatamap.get("ASMLoginTest");

		String Username = DataReader.getData(testcaseData, "Username");
		String Password = DataReader.getData(testcaseData, "Password");

		/*
		 * String Username = "hrasm001@hrorg.com"; String Password = "RVDAS@2020";
		 */

		WebUtil util = new WebUtil();
		util.inputText(loginPage.USERNAME, Username, driver);
		util.inputText(loginPage.PASSWORD, Password, driver);
		util.clickElement(loginPage.LOGIN, driver);
		Thread.sleep(2000);

		if (driver.getPageSource().contains("AREA SALES MANAGER")) {
			System.out.println("Login done as Area Sales Manager");
		} else {
			System.out.println("Area Sales Manager Login Failed");
		}
		Thread.sleep(1000);
	}

	@Test
	public void RSMLoginTest() throws Exception {

		testcaseData = testdatamap.get("RSMLoginTest");

		String Username = DataReader.getData(testcaseData, "Username");
		String Password = DataReader.getData(testcaseData, "Password");

		WebUtil util = new WebUtil();
		util.inputText(loginPage.USERNAME, Username, driver);
		util.inputText(loginPage.PASSWORD, Password, driver);
		util.clickElement(loginPage.LOGIN, driver);
		Thread.sleep(2000);

		if (driver.getPageSource().contains("REGIONAL SALES MANAGER")) {
			System.out.println("Login done as Regional Sales Manager");
		} else {
			System.out.println("Test Failed");
		}
		Thread.sleep(1000);
	}

	@Test
	public void ZSMLoginTest() throws Exception {

		testcaseData = testdatamap.get("ZSMLoginTest");

		String Username = DataReader.getData(testcaseData, "Username");
		String Password = DataReader.getData(testcaseData, "Password");

		util = new WebUtil();
		util.inputText(loginPage.USERNAME, Username, driver);
		util.inputText(loginPage.PASSWORD, Password, driver);
		util.clickElement(loginPage.LOGIN, driver);
		Thread.sleep(2000);

		if (driver.getPageSource().contains("NATIONAL SALES HEAD")) {
			System.out.println("Login done as ZSM");
		} else {
			System.out.println("ZSM Login Failed");
		}
		Thread.sleep(1000);
	}

	@Test
	public void DispatcherLoginTest() throws Exception {

		testcaseData = testdatamap.get("DispatcherLoginTest");

		String Username = DataReader.getData(testcaseData, "Username");
		String Password = DataReader.getData(testcaseData, "Password");

		util = new WebUtil();
		util.inputText(loginPage.USERNAME, Username, driver);
		util.inputText(loginPage.PASSWORD, Password, driver);
		util.clickElement(loginPage.LOGIN, driver);
		Thread.sleep(2000);

		if (driver.getPageSource().contains("HOME")) {
			System.out.println("Login done as Dispatcher");
		} else {
			System.out.println("Dispatcher Login Failed");
		}
		Thread.sleep(1000);
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}
}