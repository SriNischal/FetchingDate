package com.atmecs.tutorialsninja.utils;

import java.io.File;

public class ProjectBaseConstantPaths {

	public final static String USER_HOME = System.getProperty("user.dir") + File.separator;

	public final static String CHROME_FILE = USER_HOME + "lib" + File.separator + "chromedriver.exe";
	
	public final static String IE_FILE = USER_HOME + "lib" + File.separator + "IEDriverServer.exe";

	public final static String CONFIG_FILE = USER_HOME + "src/test/resources" + File.separator + "config.properties";

	public final static String LOCATORS_FILE1 = USER_HOME + "src/test/resources" + File.separator + "locators"
			+ File.separator + "HomePage.properties";
	
	public final static String LOCATORS_FILE = USER_HOME + "src/test/resources" + File.separator + "locators"
			+ File.separator + "HeatClinic.properties";

	public final static String PHPTRAVELS_FILE = USER_HOME + "src/test/resources" + File.separator + "locators"
			+ File.separator + "PhpTravels.properties";

	
	public final static String LOG$J_FILE = USER_HOME + "src/test/resourcess" + File.separator + "log4j.properties";

	public final static String EXPECTED_FILE = USER_HOME + "src/test/resources" + File.separator + "testdata"
			+ File.separator + "tutorialninja.properties";
	
	public final static String EXPECTED_FILE1 = USER_HOME + "src/test/resources" + File.separator + "testdata"
			+ File.separator + "tutorialninja.xlsx";

	public static final String EXTENT_REPORTFILE = "extentreport.html";

	public static final String FAILED_SCREENSHOT_FILE = USER_HOME + File.separator + "FAILEDTEST" ;

}
