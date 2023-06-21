package com.automationexercise.utilities;

import org.apache.log4j.Logger;

public class Log {
	public static Logger Log=Logger.getLogger(Log.class.getName());
	
	public static void startTest(String stestCaseName) {
		Log.info("==========================="+stestCaseName+ "===StartTestCase================================");
	}
	public static void endTest(String stestCaseName) {
		Log.info("==========================="+stestCaseName+ "=====EndTestCase==============================");
	}
	public static void info(String meassage) {
		Log.info(meassage);
	}
	public static void debug(String meassage) {
		Log.debug(meassage);
	}
	public static void warn(String meassage) {
		Log.warn(meassage);
	}
	public static void error(String meassage) {
		Log.error(meassage);
	}
	public static void fatal(String meassage) {
		Log.fatal(meassage);
	}

}
