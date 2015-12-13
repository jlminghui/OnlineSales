package com.yunidc.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.yunidc.util.ObjectMap;

/**
 * 登录页面元素对象，包含用户名输入框、密码输入框、验证码输入框、登录按钮、注册按钮、忘记密码元素对象。
 * @author minghui
 *
 */
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
		element = driver.findElement(objectMap.getLocator("loginPage.captcha"));
		return element;
	}
	
	/**
	 * 
	 * @return 返回“登录”按钮元素对象
	 * @throws Exception
	 */
	public WebElement btnLogin() throws Exception{
		element = driver.findElement(objectMap.getLocator("loginPage.btnLogin"));
		return element;
	}
	
	/**
	 * 
	 * @return 返回“注册”按钮元素对象
	 * @throws Exception
	 */
	public WebElement btnRegister() throws Exception{
		element = driver.findElement(objectMap.getLocator("loginPage.btnRegister"));
		return element;
	}
	
	/**
	 * 
	 * @return 返回“忘记密码”元素对象
	 * @throws Exception
	 */
	public WebElement forgotPassword() throws Exception{
		element = driver.findElement(objectMap.getLocator("loginPage.forgotPassword"));
		return element;
	}
	
}
