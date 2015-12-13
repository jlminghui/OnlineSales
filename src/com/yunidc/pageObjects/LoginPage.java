package com.yunidc.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.yunidc.util.ObjectMap;

public class LoginPage {
	private WebElement element = null;
	private WebDriver driver;
	//页面元素定位表达式配置文件的绝对路径
	private ObjectMap objectMap = new ObjectMap("/Users/minghui/Documents/workspace/OnlineSales/objectMap.properties");
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	 * 
	 * @return 返回“登录”对话框元素对象
	 * @throws Exception
	 */
	public WebElement userName() throws Exception{
		element = driver.findElement(objectMap.getLocator("loginPage.userName"));
		return element;
	}
	
	/**
	 * 
	 * @return 返回“密码”对话框元素对象
	 * @throws Exception
	 */
	public WebElement password() throws Exception{
		element = driver.findElement(objectMap.getLocator("loginPage.password"));
		return element;
	}
	
	/**
	 * 
	 * @return 返回“验证码”对话框元素对象
	 * @throws Exception
	 */
	public WebElement captcha() throws Exception{
		element = driver.findElement(objectMap.getLocator("loginPage.id_captcha_1"));
		return element;
	}
	
	
	/**
	 * 
	 * 下面三个没写完
	 * loginPage.btnLogin = id>btnLogin
	loginPage.btnRegister = id>register-btn
	loginPage.forgotPassword = partiallinktext>\u5FD8\u8BB0\u5BC6\u7801
	 */
	
}
