/*package com.crm.qa.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.crm.qa.base.BasePage;

import org.apache.commons.io.FileUtils;



public class SampleListner  implements ITestListener {
	
	public WebDriver driver;
	
	//public SampleListner(WebDriver driver) {
	//	this.driver = driver;
	//}
	
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		this.driver = ((BasePage)result.getInstance()).driver;
		String testname = result.getMethod().getMethodName();
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File destFile= new File("C:\\Users\\Admin\\Desktop\\Screenshot"+testname+".png");
		
		File destFile= new File("C:\\Users\\Admin\\workspace\\FreeCRMTestAutomation\\Screenshot\\"+testname+".png");
		try {
			FileUtils.copyFile(srcFile,destFile);
			//String filePath = destFile.toString();
			//String path = "<a href=\\\"\" + snapfile + \"\\\"><p align=\\\"left\\\">Add New PR screenshot at \" + subDir + \"</p>";
			//Reporter.log(path);
			
			/*String filePath = destFile.toString();
			String path = "<img src=\"file://" + filePath + "\" alt=\"\"/>";
			Reporter.log(path);*/
/*
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}*/
