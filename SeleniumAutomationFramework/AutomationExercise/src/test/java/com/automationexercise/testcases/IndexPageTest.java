package com.automationexercise.testcases;

import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationexercise.base.BaseClass;
import com.automationexercise.pages.IndexPage;
import com.automationexercise.utilities.Log;

public class IndexPageTest extends BaseClass{
	private IndexPage indexpage;
	@Parameters({"browser","url"})
	@BeforeClass
	public void launchApp(String browser,String url) {
		launchBrowser(browser,url);
	}
	@AfterClass
	public void closeBrowser() {
		getDriver().close();
	}
	@Test
	public void homepageVisible() {
		indexpage=new IndexPage();
		Log.info("homepagevisible test started");
		indexpage.homepageVisible();
		Log.info("homepagevisible test end");
	}
////	@Test
//	public void singUpMail() throws InterruptedException {
//		indexpage=new IndexPage();
//		Log.info("signUpmail test started");
//		indexpage.signup();
//	}
	@Test
	public void loginPageTest() throws InterruptedException {
		indexpage=new IndexPage();
		indexpage.loginPage();
	}

}
