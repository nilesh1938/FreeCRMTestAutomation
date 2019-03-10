package com.crm.qa.testcases.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.BasePage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
//import com.crm.qa.util.SampleListner;

//@Listeners(com.crm.qa.util.SampleListner.class)
public class LoginTest extends BasePage {

	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setup() {

		initialization();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		 //initialization();

	}

	@Test
	public void loginTest() {
		// lp = PageFactory.initElements(driver, LoginPage.class);
		homePage = loginPage.loginCRM();
		homePage.testUtil.getTitleOfPage();
		//Assert.assertEquals(homePage.testUtil.getTitleOfPage(), "CRMPRO1");
		homePage.topMenu.logOut();

	}
	
	

	@AfterMethod
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus())
		{
			loginPage.testUtil.CaptureScreenShot(result.getName());
		}
		
	
		driver.quit();
	}

}
