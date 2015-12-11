package com.yunidc.testScript;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yunidc.pageObjects.HomePage;
import com.yunidc.util.Log;

public class TestHomePage{
	public WebDriver driver;
	HomePage homePage;
	
	@Test
	public void testRegister() throws InterruptedException{
		Log.startTestcase("“官网首页”>测试点击免费注册");
		
		homePage.register();
		Log.info("验证页面中是否包含“注册会员”（相当于验证是否打开注册页面）" );
		Assert.assertTrue(homePage.getDriver().getPageSource().contains("注册会员"));
	}
	
	@Test
	public void testOpenLoginPage() throws InterruptedException{
		
		Log.startTestcase("“官网首页”>测试打开登录页面");
		homePage.login();
		
		Log.info("验证页面中是否包含“云自服务系统”" );
		Assert.assertTrue(homePage.getDriver().getPageSource().contains("云自服务系统"));
		
	}
	
	@BeforeMethod
	public void beforeMethod(){
		homePage = new HomePage();
		homePage.get();
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException{
		Thread.sleep(3000);
		homePage.quit();
	}
	
	@BeforeClass
	public void beforeClass(){
		DOMConfigurator.configure("log4j.xml");
	}
	
	/**
	 * 功能：高亮显示被操作页面元素
	 * @param element
	 */
	public void highlightElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style',arguments[1])",element,"background:yellow;border:1px solid red;" );
	}
}
