package com.yunidc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

/**
 * 用于实现在外部配置文件中配置页面元素的定位表达式。
 * @author minghui
 *
 */
public class ObjectMap {
	Properties properties;
	
	public ObjectMap(String properFile){
		properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(properFile);
			properties.load(in);
			in.close();
		} catch (IOException e) {
			System.out.println("读取对象文件出错！");
			e.printStackTrace();
		}
	}
	
	public By getLocator(String ElementNameInproFile) throws Exception{
		//根据ElementNameInproFile，从属性配置文件中读取对应的配置对象
		String locator = properties.getProperty(ElementNameInproFile);
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		
		//解决配置文件读取中文乱码问题
//		locatorValue = new String(locatorValue.getBytes("IOS-8859-1"),"UTF-8");
		//验证locatorType，locatorValue是否正确
		System.out.println("获取的定位类型：" + locatorType + "\t 获取的定位表达式" + locatorValue );
		
		//根据locatorType的变量内容判断返回何种定位方式的By对象
		if (locatorType.toLowerCase().equals("id")){
			return By.id(locatorValue);
		}else if (locatorType.toLowerCase().equals("name")){
			return By.name(locatorValue);
		}else if (locatorType.toLowerCase().equals("classname") || locatorType.toLowerCase().equals("class")){
			return By.className(locatorValue);
		}else if (locatorType.toLowerCase().equals("tagname") || locatorType.toLowerCase().equals("tag")){
			return By.tagName(locatorValue);
		}else if (locatorType.toLowerCase().equals("linktext") || locatorType.toLowerCase().equals("link")){
			return By.linkText(locatorValue);
		}else if (locatorType.toLowerCase().equals("partiallinktext")){
			return By.partialLinkText(locatorValue);
		}else if (locatorType.toLowerCase().equals("cssselector") || locatorType.toLowerCase().equals("css")){
			return By.cssSelector(locatorValue);
		}else if (locatorType.toLowerCase().equals("xpath")){
			return By.xpath(locatorValue);
		}else throw new Exception("输入的locator type 未在程序中被定义：" + locatorType);
	}
	
}
