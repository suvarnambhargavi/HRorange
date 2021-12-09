package testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.testng.Assert;

import PageObject.Dashboard;
import PageObject.LoginPage;
import base.TestBase;

public class LoginPageTestCases extends TestBase
{
	Logger log=Logger.getLogger(LoginPageTestCases.class);
	@Parameters({"uname","pwd"})
	@Test
	public void veifyId(String username,String pswd)
	{
		log.info("verifying the user");
		LoginPage lp=new LoginPage(driver);
		Assert.assertTrue(lp.verify(),"username inputbox not displayed");
		lp.setName(username);
		Assert.assertTrue(lp.verifyPwd(),"pwd inputbox not displayed");
		lp.setPwd(pswd);
		Assert.assertTrue(lp.verifyLogin(),"login button disabled");
		lp.click();
		Dashboard dp=new Dashboard(driver);
		String etitle="xydashboard";
		String atitle=dp.getTitle();
		Assert.assertEquals(etitle,atitle,"login failed....");
		
	}
	
	@Test (priority=1)
	public void invalidId()
	{
		LoginPage lp=new LoginPage(driver);
		Assert.assertTrue(lp.verify(),"username inputbox not displayed");
		lp.setName("Admin");
		Assert.assertTrue(lp.verifyPwd(),"pwd inputbox not displayed");
		lp.setPwd("xyz");
		Assert.assertTrue(lp.verifyLogin(),"login button disabled");
		lp.click();
		String eti="Invalid credentials";
		String aerror=lp.getInvalid();
		Assert.assertEquals(eti,aerror,"login failed....");
		
		
}
}