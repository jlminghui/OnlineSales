package com.yunidc.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//需要调试和完善，最终要实现对元素操作的时候高亮，操作完后取消高亮的功能。
public class HighlightElement {
	public void highlightElement(WebDriver driver,WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style',arguments[1])",element,"background:yellow;border:1px solid red;" );
	}
}
