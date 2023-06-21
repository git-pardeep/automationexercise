package com.automationexercise.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automationexercise.base.BaseClass;
import com.aventstack.extentreports.Status;

public class ListenerTest extends ExtentManager implements ITestListener {

	public void onTestStart(ITestResult Result) {
		System.out.println(Result.getName() + " test case started");
		test = extent.createTest("test is statrted :" + Result.getName());
	}

	public void onTestFailure(ITestResult Result) {
		System.out.println("The name of the testcase failed is :" + Result.getName());
		if (Result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL,"The name of the testcase failed is :" + Result.getName() );
			Log.info("The name of the testcase failed is :" + Result.getName());
			Date date=new Date();
			String timeStamp=date.toString().replace(":", "-").replace(" ", "-");
			System.out.println(timeStamp);
			File screenshot=((TakesScreenshot)BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshot, new File(".\\ScreenShots\\"+timeStamp+"_"+Result.getName()+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	}

	// When Test case get Skipped, this method is called.

	public void onTestSkipped(ITestResult Result) {
		System.out.println("The name of the testcase Skipped is :" + Result.getName());
		if (Result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "test is skiiped " + Result.getName());
			Log.info("test is skiped :" + Result.getName());
		}
	}

	// When Test case get Started, this method is called.

	// When Test case get passed, this method is called.

	public void onTestSuccess(ITestResult Result) {
		System.out.println("The name of the testcase passed is :" + Result.getName());
		if (Result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "The name of the testcase passed is :" + Result.getName());
			Log.info("The name of the testcase passed is :" + Result.getName());
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		System.out.println("The name of the testcase failed in percentage is :" + Result.getName());
		if (Result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "The name of the testcase failed in percentage is :" + Result.getName());
			Log.info("The name of the testcase failed in percentage is :" + Result.getName());
		}

	}

	// When Test case get failed, this method is called.
	public void onFinish(ITestContext Context) {
		System.out.println("test is finish "+Context.getName());
		

	}

	public void onStart(ITestContext Context) {

	}
}