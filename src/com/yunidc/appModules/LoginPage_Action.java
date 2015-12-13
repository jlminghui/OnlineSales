package com.yunidc.appModules;

import org.openqa.selenium.WebDriver;

import com.yunidc.pageObjects.LoginPage;
import com.yunidc.util.Constant;
import com.yunidc.util.Log;

public class LoginPage_Action {
	/**
	 * 初始化LoginPage对象，打开“登录”页面，最大化当前浏览器
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 */
	public static LoginPage initLoginPage(WebDriver driver) throws InterruptedException{
		
		Log.info("打开登录页面");
		driver.get(Constant.LOGIN_PAGE_RUL);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		return new LoginPage(driver);
		
	}
	
	public static void excute(WebDriver driver,String userName,String password) throws Exception{
		
		initLoginPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		Log.info("输入用户名：" + userName);
		loginPage.userName().sendKeys(userName);
		
		Log.info("输入密码" + password);
		loginPage.password().click();
		loginPage.password().sendKeys(password);
		
		Log.info("输入验证码" );
		loginPage.captcha().sendKeys("1234");
//		loginPage.captcha().sendKeys(Constant.LOGIN_PAGE_CAPTCHA);
		//暂时手动输入验证码
		Thread.sleep(8000);
		
		Log.info("点击“登录”按钮");
		loginPage.btnLogin().click();
		Thread.sleep(5000);
		
	}
}
