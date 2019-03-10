package com.crm.qa.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.crm.qa.base.BasePage;

public class ContactPage extends BasePage {

	public ContactPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//select[@name='do_action']")
	public WebElement checkedRecordDropdown;

	@FindBy(xpath = "//select[@name='view_id']")
	private WebElement viewDropdown;

	@FindBy(xpath = "//input[@type='button' and @value='DO' ]")
	private WebElement doButton;

	@FindBy(name = "first_name")
	private WebElement firstName;

	@FindBy(name = "surname")
	private WebElement lastName;

	@FindBy(xpath = "//input[@name='image_file' and@type='file']")
	private WebElement chooseFileBtn;

	@FindBy(name = "category")
	private WebElement categoryDropdown;

	@FindBy(xpath = "//select[@name='status']/following-sibling::input")
	private WebElement statusHelpLink;

	@FindBy(xpath = "//input[@type='radio' and @name='receive_sms']")
	private List<WebElement> rcvdSMSRadioButton;

	@FindBy(xpath = "//img[@id='f_trigger_c_birthday']")
	private WebElement birthdayCalendar;

	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//tr[@class='footrow']/td")
	private WebElement moveCalendar;

	public void checkedRecordoption(String option) {
		testUtil.fn_Select(checkedRecordDropdown, option);
	}

	public boolean checkSortingForCheckedRecordOption() {
		return testUtil.checkSortingFromDropDown(checkedRecordDropdown);
	}

	public boolean checkSortingViewDropdown() {
		return testUtil.checkSortingFromDropDown(viewDropdown);
	}

	public void selectContacts(String name) {
		List<WebElement> lst = driver.findElements(By.xpath("//a[text()='" + name + "']/../preceding-sibling::td/input"
				+ "[@type='checkbox' and @name='contact_id']"));

		for (WebElement element : lst) {
			element.click();
		}
	}

	public void clickDoButton() {
		doButton.click();
	}

	public void createContact() {

		firstName.sendKeys(testUtil.getTestData("Contacts", 1, 0));
		lastName.sendKeys(testUtil.getTestData("Contacts", 1, "Last Name"));
		chooseFileBtn.sendKeys("C:\\Users\\Admin\\Desktop\\test.txt");
		testUtil.fn_Select(categoryDropdown, "Lead");
		rcvdSMSRadioButton.get(1).click();
		birthdayCalendar.click();
		testUtil.moveToElement(moveCalendar);
		testUtil.dragElement(moveCalendar, 150, 0);
		saveBtn.click();

	}

}
