package com.yunidc.testScript;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yunidc.appModules.LoginPage_Action;
import com.yunidc.util.Constant;
import com.yunidc.util.Log;


public class TestLoginPage {
	WebDriver driver;
	
	@Test
	public void testLogin() throws Exception{
		
		Log.startTestcase("“登录页面”>验证登录功能是否正常");
		LoginPage_Action.excute(driver, Constant.LOGIN_PAGE_USER_NAME, Constant.LOGIN_PAGE_PASSWORD);
		
		Log.info("验证登录后的页面中是否包含用户名“test2934”");
		Assert.assertTrue(driver.getPageSource().contains("test2934"));
		
	}
	
	
	
	
	@BeforeMethod
	public void beforeMethod(){
		
		System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox");
		driver = new FirefoxDriver();
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	
	@BeforeClass
	public void beforeClass(){
		DOMConfigurator.configure("log4j.xml");
	}
}
