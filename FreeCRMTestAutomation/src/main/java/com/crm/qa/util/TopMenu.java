package com.crm.qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.pages.ContactPage;

public class TopMenu {

	WebDriver driver;
	TestUtil testUtil;

	public TopMenu(WebDriver driver) {
		this.driver = driver;
		testUtil = PageFactory.initElements(driver, TestUtil.class);
	}

	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactsLink;

	@FindBy(xpath = "//a[text()='New Contact']")
	private WebElement newContact;
	
	@FindBy(xpath="//i[@class='fa fa-sign-out icon-2x']") ////a[contains(text(),'Logout')]
	private WebElement logOutLink;

	public ContactPage clickContactLink() {
		driver.switchTo().frame("mainpanel");
		contactsLink.click();
		return PageFactory.initElements(driver, ContactPage.class);

	}

	public ContactPage clickNewContactLink() {
		driver.switchTo().frame("mainpanel");
		testUtil.moveToElement(contactsLink);
		// moveToElement(contactsLink);
		newContact.click();
		return PageFactory.initElements(driver, ContactPage.class);
	}
	
	public void logOut()
	{
		
		//testUtil.fn_click(logOutLink);
		logOutLink.click();
	}

}
