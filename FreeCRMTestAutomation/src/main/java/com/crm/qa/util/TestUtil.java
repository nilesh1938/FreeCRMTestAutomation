package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

public class TestUtil {

	public WebDriver driver;
	public Select selObj;
	public Actions action;
	public FileInputStream fis;
	public Workbook wb;
	public Sheet s;
	public Row row;
	public String cell;

	public TestUtil(WebDriver driver) {
		this.driver = driver;
	}

	public static long PageLoadTimeOut = 20;
	public static long implicitWait = 10;

	public void fn_Select(WebElement WE, String VisibleTextOrValue) {
		selObj = new Select(WE);
		try {
			selObj.selectByVisibleText(VisibleTextOrValue);
		} catch (Exception e) {
			selObj.selectByValue(VisibleTextOrValue);
		}

	}

	public void fn_Select(WebElement WE, int IndexValue) {
		selObj = new Select(WE);
		selObj.selectByIndex(IndexValue);
	}

	public void fn_click(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public boolean checkSortingFromDropDown(WebElement WE) {
		selObj = new Select(WE);
		List<WebElement> lst = selObj.getOptions();
		List<String> optionList = new ArrayList<String>();
		for (WebElement option : lst) {
			optionList.add(option.getText());
		}
		List<String> tempList = new ArrayList<String>(optionList);

		Collections.sort(optionList);
		return optionList.equals(tempList);

	}

	public String getTitleOfPage() {
		return driver.getTitle();
	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void moveToElement(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void dragElement(WebElement element, int xOffset, int yOffset) {
		action = new Actions(driver);
		action.dragAndDropBy(element, xOffset, yOffset).build().perform();
	}

	/*public static Object[][] getTestData(String SheetName, String... colName) {

		Workbook wb = null;
		FileInputStream fis = null;
		int col_Num = -1;

		try {
			fis = new FileInputStream("");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		}

		catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Sheet sheet = wb.getSheet(SheetName);
		Object[] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		Row row = sheet.getRow(1);

		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName[i].trim()))
				col_Num = i;
			String cell = row.getCell(col_Num).getStringCellValue();

			for (int j = 0; j < sheet.getLastRowNum(); j++) {
				for (int k = i; k < sheet.getRow(0).getLastCellNum(); k++) {
					data[j][k] = sheet.getRow(j + 1).getCell(k).toString();
				}
			}
		}
		return data;
	}
	*/
	
	public String getTestData(String sheetName, int rowNum, int colNum)
	{
		try {
			
			FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\workspace\\FreeCRMTestAutomation\\src\\main\\java\\com\\crm\\qa\\testdata\\CRM_DATA.xlsx");
			wb = WorkbookFactory.create(fis);
			s = wb.getSheet(sheetName);
			row = s.getRow(rowNum);
			cell = row.getCell(colNum).getStringCellValue();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cell;
		
	}
	
	public String getTestData(String sheetName, int rowNum, String colName)
	{
		try {
			
			int colNum = -1;
			
			FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\workspace\\FreeCRMTestAutomation\\src\\main\\java\\com\\crm\\qa\\testdata\\CRM_DATA.xlsx");
			wb = WorkbookFactory.create(fis);
			s = wb.getSheet(sheetName);
			row = s.getRow(0);
			
			for(int i = 0; i < row.getLastCellNum(); i++)
            {
                if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName.trim()))
                    colNum = i;
            }
			cell = s.getRow(rowNum).getCell(colNum).getStringCellValue();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cell;
		
	}
	
	public  void CaptureScreenShot(String ScreenshotName) {
		// TODO Auto-generated method stub
		//this.driver = ((BasePage)result.getInstance()).driver;
		//String testname = result.getMethod().getMethodName();
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File destFile= new File("C:\\Users\\Admin\\Desktop\\Screenshot"+testname+".png");
		
		File destFile= new File("C:\\Users\\Admin\\workspace\\FreeCRMTestAutomation\\Screenshot\\"+ScreenshotName+".png");
		try {
			FileUtils.copyFile(srcFile,destFile);
			//String filePath = destFile.toString();
			//String path = "<a href=\\\"\" + snapfile + \"\\\"><p align=\\\"left\\\">Add New PR screenshot at \" + subDir + \"</p>";
			//Reporter.log(path);
			
			/*String filePath = destFile.toString();
			String path = "<img src=\"file://" + filePath + "\" alt=\"\"/>";
			Reporter.log(path);*/

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
