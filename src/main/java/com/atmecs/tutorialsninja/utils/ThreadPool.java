package com.atmecs.tutorialsninja.utils;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class ThreadPool {
	private static ThreadPool threadPool = new ThreadPool();;

	public final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>();

	public final ThreadLocal<ExtentTest> extentThreadLocal=new ThreadLocal<ExtentTest>();

	/**
	 * The method is used for getting the driver used in the thread
	 * 
	 * @return driver
	 */
	public static WebDriver getDriver() {
		return threadPool.driverThreadLocal.get();
	}

	/**
	 * The method is used for setting the driver in the thread
	 * 
	 * @param driver
	 */
	public static void setDriver(WebDriver driver) {

		threadPool.driverThreadLocal.set(driver);
	}

	/**
	 * The method is used for getting the ExtentTest object used in the thread
	 * 
	 * @return driver
	 */
	public static ExtentTest getExtentTest() {
		return threadPool.extentThreadLocal.get();
	}

	/**
	 * The method is used for setting the ExtentTest object in the thread
	 * 
	 * @param testReporter
	 */
	public static void setExtentTest(ExtentTest testReporter) {

		threadPool.extentThreadLocal.set(testReporter);
	}

}