package com.yunidc.appModules;

import org.openqa.selenium.WebDriver;

import com.yunidc.pageObjects.HomePage;
import com.yunidc.util.Constant;
import com.yunidc.util.Log;

public class HomePage_Action {
	
	/**
	 * 初始化HomePage，访问首页链接，最大化浏览器窗口。
	 * @param driver
	 * @return HomePage对象
	 * @throws InterruptedException 
	 */
	public static HomePage initHomePage(WebDriver driver) throws InterruptedException{
		
		Log.info("访问首页URL");
		driver.get(Constant.HOME_PAGE_URL);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		return new HomePage(driver);
		
	}
	
	/**
	 * 点击首页“登录”按钮，并等待5秒
	 * @param driver
	 * @throws Exception
	 */
	public static void login(WebDriver driver) throws Exception{
		
		HomePage homePage = initHomePage(driver);
		
		Log.info("点击“登录”按钮");
		homePage.login().click();
		Thread.sleep(5000);
	}
	
	/**
	 * 点击首页“注册”按钮，并等待5秒
	 * @param driver
	 * @throws Exception
	 */
	public static void register(WebDriver driver) throws Exception{
		HomePage homePage = initHomePage(driver);

		Log.info("点击“注册”按钮");
		homePage.register().click();
		Thread.sleep(5000);
	}
	
	/**
	 * 点击首页“控制台”按钮，并等待5秒
	 * @param driver
	 * @throws Exception
	 */
	public static void console(WebDriver driver) throws Exception{
		HomePage homePage = initHomePage(driver);
		
		Log.info("点击“控制台”按钮");
		homePage.console().click();
		Thread.sleep(5000);
	}
	
}
