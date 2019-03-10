package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

//import com.crm.qa.util.SampleListner;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.TopMenu;

public class BasePage {
	
	
	public static Properties prop;
	public WebDriver driver;
	public TopMenu topMenu;
	public TestUtil testUtil;
	//public SampleListner sampleListner;

	public BasePage() {

		try {

			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Admin\\workspace\\FreeCRMTestAutomation\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fis);

		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void initialization() {

		String browsername = prop.getProperty("browser");

		// String browsername= "chrome";
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.firefox.marionette", "C:\\Users\\Admin\\Desktop\\geckodriver.exe");// webdriver.firefox.marionette
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("marionette", false);
			driver = new FirefoxDriver(options);
		} else {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Admin\\Desktop\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitWait, TimeUnit.SECONDS);
		// driver.get(BasePage.prop.getProperty("url"));
	}

	public BasePage(WebDriver driver) {
		this.driver = driver;
		testUtil = PageFactory.initElements(driver, TestUtil.class);
		topMenu = PageFactory.initElements(driver, TopMenu.class);
		//sampleListner = PageFactory.initElements(driver, SampleListner.class);

	}

	public TopMenu getTopMenu() {
		return topMenu;
	}

	public TestUtil getTestUtil() {
		return testUtil;
	}
	
	/*public SampleListner getSampleListner() {
		return sampleListner;
	}*/
}
