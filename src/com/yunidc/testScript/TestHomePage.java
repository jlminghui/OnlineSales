package com.yunidc.testScript;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yunidc.appModules.HomePage_Action;
import com.yunidc.util.Log;


public class TestHomePage {
	public WebDriver driver;
	
	@Test(enabled = true)
	public void testRegister() throws Exception{
		
		Log.startTestcase("“官网首页”>测试点击“免费注册”按钮页面跳转");
		HomePage_Action.register(driver);
		
		Log.info("验证页面中是否包含“注册会员”（相当于验证是否打开注册页面）" );
		Assert.assertTrue(driver.getPageSource().contains("注册会员"));
	}
	
	@Test(enabled = true)
	public void testOpenLoginPage() throws Exception{
		
		Log.startTestcase("“官网首页”>测试点击“登录”按钮页面跳转");
		HomePage_Action.login(driver);
		
		Log.info("验证登录页面中是否包含“云自服务系统”" );
		Assert.assertTrue(driver.getPageSource().contains("云自服务系统"));
	}
	
	@Test(enabled = true)
	public void testConsole() throws Exception{
		
		Log.startTestcase("“官网首页”>测试点击“控制台”页面跳转");
		HomePage_Action.console(driver);
		Log.info("验证登录页面中是否包含“云自服务系统”" );
		Thread.sleep(10000);
//		此处是又启动一个窗口打开登录页面，不能直接用下面断言判断，要识别新窗口，并断言里面是否包含关键字
//		Assert.assertTrue(driver.getPageSource().contains("云自服务系统"));
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
