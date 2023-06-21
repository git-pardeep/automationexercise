package com.automationexercise.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.automationexercise.base.BaseClass;
import com.automationexercise.utilities.Log;

public class IndexPage extends BaseClass {
	Actions act = new Actions(getDriver());
	@FindBy(xpath = "//img[@alt='Website for automation practice']")
	private WebElement logo;
	@FindBy(xpath = "//a[text()=' Signup / Login']")
	private WebElement signin;
	@FindBy(xpath = "//h2[text()='New User Signup!']")
	private WebElement newusersignup;
	@FindBy(xpath = "//input[@name='name']")
	private WebElement name;
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	private WebElement emailaddress;
	@FindBy(xpath = "//button[text()='Signup']")
	private WebElement signup;
	@FindBy(xpath = "//b[text()='Enter Account Information']")
	private WebElement enteraccountinformation;
//	@FindBy(xpath="//input[@id='id_gender1']") private WebElement title;
	@FindBy(xpath = "//input[@id='id_gender1']")
	private WebElement title;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	@FindBy(xpath = "//Select[@id='days']")
	private WebElement days;
	@FindBy(xpath = "//Select[@id='months']")
	private WebElement months;
	@FindBy(xpath = "//Select[@id='years']")
	private WebElement years;
	@FindBy(xpath = "//input[@id='newsletter']")
	private WebElement newslettercheckbox;
	@FindBy(xpath = "//input[@id='optin']")
	private WebElement specialoffercheckbox;
	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement firstname;
	@FindBy(xpath = "//input[@id='last_name']")
	private WebElement lastname;
	@FindBy(xpath = "//input[@id='company']")
	private WebElement companyname;
	@FindBy(xpath = "//input[@id='address1']")
	private WebElement address1;
	@FindBy(xpath = "//input[@id='address2']")
	private WebElement address2;
	@FindBy(xpath = "//Select[@id='country']")
	private WebElement country;
	@FindBy(xpath = "//input[@id='state']")
	private WebElement state;
	@FindBy(xpath = "//input[@id='city']")
	private WebElement city;
	@FindBy(xpath = "//input[@id='zipcode']")
	private WebElement zipcode;
	@FindBy(xpath = "//input[@id='mobile_number']")
	private WebElement mobilenumber;
	@FindBy(xpath = "//button[text()='Create Account']")
	private WebElement creataccountbtn;
	@FindBy(xpath = "//b[text()='Account Created!']")
	private WebElement accountcreattext;
	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement continuebtn;
	@FindBy(xpath = "//a[text()=' Logged in as ']")
	private WebElement loggedas;
	@FindBy(xpath = "//a[text()=' Delete Account']")
	private WebElement deleteaccount;
	@FindBy(xpath = "//b[text()='Account Deleted!']")
	private WebElement verifieddelete;
	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement deletecontinue;
	
	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement loginemail;
	
	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement loginpassword;
	
	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement loginbtn;
	
	

	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean homepageVisible() {
		System.out.println("Home page is visible :" + logo.isDisplayed());
		Log.info("Home page is visible :" + logo.isDisplayed());
		return logo.isDisplayed();
	}

	public void signup() throws InterruptedException {
		signin.click();
		String newuser = "New User Signup!";
		String newsignup = newusersignup.getText();
		Assert.assertEquals(newsignup, newuser, "new user not matchted");
		name.sendKeys("Pardeepkumar");
		emailaddress.sendKeys("zzjjk123@gmail.com");
		Thread.sleep(2000);
		signup.click();
		System.out.println("singup page success full loging ");
//		System.out.println("account text :"+enteraccountinformation.getText());
//		System.out.println("account text is visible :"+enteraccountinformation.isDisplayed());
//		Assert.assertEquals("Enter Account Information", enteraccountinformation.getText(), "text is not matched");
		System.out.println("title is click");
		title.click();
		Thread.sleep(1000);
		password.click();
		password.sendKeys("123456789");
		password.submit();
		act.moveToElement(days).build().perform();
		Select select = new Select(days);
		select.selectByValue("10");
		act.moveToElement(months).build().perform();
		Select select1 = new Select(months);
		select1.selectByValue("10");
		act.moveToElement(years).build().perform();
		Select select2 = new Select(years);
		select2.selectByValue("1993");
		newslettercheckbox.click();
		specialoffercheckbox.click();
		Thread.sleep(1000);
		firstname.sendKeys("Pardeep");
		lastname.sendKeys("kumar");
		act.moveToElement(companyname).build().perform();
		companyname.sendKeys("ISmartu India pvt ltd");
		address1.sendKeys("block d");
		address2.sendKeys("sector 63");
		act.moveToElement(country).build().perform();
		Select select3 = new Select(country);
		select3.selectByValue("India");
		state.sendKeys("utar pardes");
		city.sendKeys("Noida");
		zipcode.sendKeys("201301");
		mobilenumber.sendKeys("123456789");
		act.moveToElement(creataccountbtn).build().perform();
		Thread.sleep(1000);
		creataccountbtn.click();
		Thread.sleep(1000);
		System.out.println("continue text is :" + accountcreattext.getText());
//		Assert.assertEquals("ACCOUNT CREATED!", accountcreattext.getText(),"text not matched");
		continuebtn.click();
		Thread.sleep(1000);
//		Assert.assertEquals("Logged in as", loggedas.getText());
		deleteaccount.click();
		Thread.sleep(1000);
//		Assert.assertEquals("ACCOUNT DELETED!",verifieddelete.getText() );
		deletecontinue.click();
		Thread.sleep(1000);
	}
	public void loginPage() throws InterruptedException {
		signin.click();
		loginemail.sendKeys("ismartu@transsion.com");
		loginpassword.sendKeys("123456789");
		loginbtn.click();
		deleteaccount.click();
		Thread.sleep(2000);
		Alert alert =getDriver().switchTo().alert();
		alert.dismiss();
		String delete=verifieddelete.getText();
		if ("Account Deleted!".equalsIgnoreCase(delete)) {
			System.out.println("successful deleted");
		}
	}
}
