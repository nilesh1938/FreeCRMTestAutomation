package com.crm.qa.testcases.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.BasePage;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsTest extends BasePage {

	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;

	@BeforeMethod
	public void setup() {

		initialization();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		// initialization();

	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

	@Test
	public void selectCheckedRecordOptionTest() {
		// lp = PageFactory.initElements(driver, LoginPage.class);
		homePage = loginPage.loginCRM();
		contactPage = homePage.getTopMenu().clickContactLink();
		contactPage.checkedRecordoption("Subscribe to Print Campaign");
	}

	@Test
	public void checkSortofCheckedRecordOptionTest() {
		// lp = PageFactory.initElements(driver, LoginPage.class);
		homePage = loginPage.loginCRM();
		contactPage = homePage.getTopMenu().clickContactLink();
		Assert.assertTrue(contactPage.checkSortingForCheckedRecordOption(), "Dropdown values are not sorted");

	}

	@Test
	public void checkSortofViewOptionTest() {
		// lp = PageFactory.initElements(driver, LoginPage.class);
		homePage = loginPage.loginCRM();
		contactPage = homePage.getTopMenu().clickContactLink();
		Assert.assertTrue(contactPage.checkSortingViewDropdown(), "Dropdown values are not sorted");

	}

	@Test
	public void deleteCheckedRecordsTest() {
		homePage = loginPage.loginCRM();
		contactPage = homePage.getTopMenu().clickContactLink();
		contactPage.selectContacts("Rahul Kumar");
		contactPage.checkedRecordoption("Delete Checked");
		contactPage.clickDoButton();
		contactPage.testUtil.acceptAlert();

	}

	@Test
	public void createNewContact() {
		homePage = loginPage.loginCRM();
		contactPage = homePage.topMenu.clickNewContactLink();
		contactPage.createContact();

	}

}
