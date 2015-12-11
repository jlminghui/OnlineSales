package com.yunidc.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.yunidc.util.Log;
import com.yunidc.util.ObjectMap;

public class HomePage {
	private WebElement element = null;
	private WebDriver driver;
	//页面元素定位表达式配置文件的绝对路径
	private ObjectMap objectMap = new ObjectMap("/Users/minghui/Documents/workspace/OnlineSales/objectMap.properties");
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	 * 
	 * @return 返回HomePage页面右上角登录元素对象
	 * @throws Exception
	 */
	public WebElement login() throws Exception{
		element = driver.findElement(objectMap.getLocator("homePage.loginButton"));
		return element;
	}
	
	/**
	 * 
	 * @return 返回HomePage页面右上角注册元素对象
	 * @throws Exception
	 */
	public WebElement register() throws Exception{
		element = driver.findElement(objectMap.getLocator("homePage.registerButton"));
		return element;
	}
	
	/**
	 * 
	 * @return 返回HomePage页面右上角控制台元素对象
	 * @throws Exception
	 */
	public WebElement console() throws Exception{
		element = driver.findElement(objectMap.getLocator("homePage.console"));
		return element;
	}
	
}

public class HomePage extends LoadableComponent<HomePage>{
	public WebDriver driver;
	public String homePageUrl = "http://101.251.234.166/";
	
	//首页“登录”
	@FindBy(xpath = "//*[@id='id_online_login']/a")
	public WebElement login;
	
	//首页“免费注册”
	@FindBy(xpath = "//*[@id='id_online_register']")
	public WebElement register;
	
	//首页“控制台”
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/ul[2]/li[1]/a")
	public WebElement console;
	
	public HomePage(){
		System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox");
		driver = new FirefoxDriver();
		PageFactory.initElements(driver, this);
	}
	
	//访问首页
	public void load(){
		driver.get(homePageUrl );
		driver.manage().window().maximize();
	}
	
	@Override
	protected void isLoaded() throws Error {
		Assert.assertTrue(driver.getTitle().contains("CDS北京首都在线科技股份有限公司"));
	}
	
	//关闭浏览器
	public void quit(){
		driver.quit();
	}
	
	//点击“登录”
	public void login(){
		Log.info("点击“登录”按钮");
		login.click();
	}
	
	//点击“免费注册”
	public void register(){
		Log.info("点击“注册”按钮");
		register.click();
	}
	
	public WebDriver getDriver(){
		return driver;
	}

}
