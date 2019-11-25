package com.atmecs.tutorialsninja.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.relevantcodes.extentreports.LogStatus;

/**
 * Configure the log4j file path.
 */
public class LogReport {

	Logger logger = null;

	public LogReport() {
		getlogger();
		logger = Logger.getLogger(LogReport.class.getName());
	}

	public void getlogger() {
		PropertyConfigurator
				.configure("C:\\Users\\srinischal.thiparani\\AssessmentTwo\\tutorialninja\\src\\test\\resources\\log4j.properties");
	}

	public void info(String message) {
		logger.info(message);
		//ThreadPool.getExtentTest().log(LogStatus.INFO, message);
	}
}
