package com.yunidc.testScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yunidc.util.Log;


public class HomePage {
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
		driver.get(homePageUrl);
		driver.manage().window().maximize();
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
