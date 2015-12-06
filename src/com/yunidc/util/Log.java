package com.yunidc.util;

import org.apache.log4j.Logger;

public class Log {
	//初始化一个Logger对象
	private static Logger Log = Logger.getLogger(Log.class.getName());
	public static void startTestcase(String sTestCaseName){
		Log.info("----------------------------------------------------------------------");
		Log.info("**********               " + sTestCaseName + "              **********");
	}
	
	//测试用例执行结束的日志信息
	public static void endTestCase(String sTestCaseName){
		Log.info("**********               " + sTestCaseName + "测试用例执行结束" + "              **********");
		Log.info("----------------------------------------------------------------------");
	}
	
	//打印自定义的info级别日志信息
	public static void info(String message){
		Log.info(message);
	}
	
	//warn级别日志信息
	public static void warn(String message){
		Log.warn(message);
	}
	
	//error级别日志信息
	public static void error(String message){
		Log.error(message);
	}
	
	//fatal级别日志信息
	public static void fatal(String message){
		Log.fatal(message);
	}
	
	//debug级别日志信息
	public static void debug(String message){
		Log.debug(message);
	}
	
	
}
