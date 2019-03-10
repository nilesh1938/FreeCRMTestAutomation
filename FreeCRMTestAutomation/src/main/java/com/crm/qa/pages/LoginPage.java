package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BasePage;

public class LoginPage extends BasePage {

	// WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameTxt;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement pwdTxt;

	@FindBy(xpath = "//input[@type='submit' and @value='Login']")
	private WebElement loginBtn;

	public HomePage loginCRM() {
		driver.get(prop.getProperty("url"));
		userNameTxt.sendKeys(prop.getProperty("username"));
		pwdTxt.sendKeys(prop.getProperty("password"));
		testUtil.fn_click(loginBtn);
		return PageFactory.initElements(driver, HomePage.class);

	}

}
