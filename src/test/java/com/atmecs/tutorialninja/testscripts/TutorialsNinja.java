package com.atmecs.tutorialninja.testscripts;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.atmecs.tutorialninja.Testsuite.TestBase;
import com.atmecs.tutorialninja.Testsuite.Pageactions;
import com.atmecs.tutorialsninja.utils.LogReport;
import com.atmecs.tutorialsninja.utils.MyDataBase;
import com.atmecs.tutorialsninja.utils.ProjectBaseConstantPaths;
import com.atmecs.tutorialsninja.utils.ReadLocatorsFile;
import com.atmecs.tutorialsninja.utils.ThreadPool;
import com.atmecs.tutorialsninja.utils.Propertiesfile;
import com.atmecs.tutorialsninja.utils.Waitsclass;
import com.atmecs.tutorialsninja.validation.HomePageValidation;

public class TutorialsNinja extends TestBase {
	Pageactions page;
	Propertiesfile properties;
	ReadLocatorsFile read;
	Waitsclass wait;
	HomePageValidation validate;
	LogReport log;
	String url;
	MyDataBase database;
	static ArrayList<String> databaseValues;
	static String personalizedName;
	static String productQuantity;
	ResultSet rs = null;
	Statement stmt = null;
	Connection con = null;
	String expectedvalue;

	@BeforeClass
	public void setup() throws IOException {
		
		System.out.println("suraj");
		properties = new Propertiesfile();
		log = new LogReport();
		url = Propertiesfile.readConfig("url1", ProjectBaseConstantPaths.CONFIG_FILE);
		System.out.println("nischal");
		driver.get(url);
	//	ThreadPool.setDriver(driver);
		driver.manage().window().maximize();
		log.info("Application is open...");
	}

	@Test
	public void home() throws Exception {
		page = new Pageactions(driver);
		properties = new Propertiesfile();
		validate = new HomePageValidation();
		read = new ReadLocatorsFile(driver);
		wait = new Waitsclass();
		database = new MyDataBase();
		validate = new HomePageValidation();
		validate.titleValidate(driver);
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.searchtext.txt", ProjectBaseConstantPaths.LOCATORS_FILE1));
		// String data = page.getdata_fromExcel("Sheet1", "Product Reqirements", "Product1");
		String name = database.db("assessment", "project", "name", 1);
		page.sendKeys(ReadLocatorsFile.readPropertiesFile("loc.searchtext.txt", ProjectBaseConstantPaths.LOCATORS_FILE1),name);
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.searchbutton.btn", ProjectBaseConstantPaths.LOCATORS_FILE1));
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.image.btn", ProjectBaseConstantPaths.LOCATORS_FILE1));
		validate.avilabilityValidation(driver);
		//validate.productdescriptionValidation(driver);
		validate.priceValidation(driver);
		validate.taxValidation(driver);
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.quantity.txt", ProjectBaseConstantPaths.LOCATORS_FILE1));
		page.clear(ReadLocatorsFile.readPropertiesFile("loc.quantity.txt", ProjectBaseConstantPaths.LOCATORS_FILE1));
		//String iphonequantity = page.getdata_fromExcel("Sheet1", "Product Reqirements", "Quantity1");
		String iphonequantity= database.db("assessment", "project", "name", 3);
		page.sendKeys(ReadLocatorsFile.readPropertiesFile("loc.quantity.txt", ProjectBaseConstantPaths.LOCATORS_FILE1),iphonequantity);
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.addtocart.btn", ProjectBaseConstantPaths.LOCATORS_FILE1));
		wait.threadwait();
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.cart.btn", ProjectBaseConstantPaths.LOCATORS_FILE1));
		wait.threadwait();
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.viewcart.btn", ProjectBaseConstantPaths.LOCATORS_FILE1));
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.continue.btn", ProjectBaseConstantPaths.LOCATORS_FILE1));
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.search.txt", ProjectBaseConstantPaths.LOCATORS_FILE1));
		// String macproduct = page.getdata_fromExcel("Sheet1", "Product Reqirements",
		// "Product2");
		String name1 = database.db("assessment", "project", "name", 2);
		page.sendKeys(ReadLocatorsFile.readPropertiesFile("loc.search.txt", ProjectBaseConstantPaths.LOCATORS_FILE1),name1);
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.search.btn", ProjectBaseConstantPaths.LOCATORS_FILE1));
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.image.btn", ProjectBaseConstantPaths.LOCATORS_FILE1));
		// validate.avilabilityValidation(driver);
		//validate.macproductdescriptionValidation(driver);
		validate.macpriceValidation(driver);
		validate.mactaxValidation(driver);
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.quantity.txt", ProjectBaseConstantPaths.LOCATORS_FILE1));
		page.clear(ReadLocatorsFile.readPropertiesFile("loc.quantity.txt", ProjectBaseConstantPaths.LOCATORS_FILE1));
		//String macquantity = page.getdata_fromExcel("Sheet1", "Product Reqirements", "Quantity2");
		String macquantity=database.db("assessment","project", "name", 4);
		page.sendKeys(ReadLocatorsFile.readPropertiesFile("loc.quantity.txt", ProjectBaseConstantPaths.LOCATORS_FILE1),macquantity);
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.addtocart.btn", ProjectBaseConstantPaths.LOCATORS_FILE1));
		wait.threadwait();
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.cart.btn", ProjectBaseConstantPaths.LOCATORS_FILE1));
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.viewcart.btn", ProjectBaseConstantPaths.LOCATORS_FILE1));
		validate.totalValidation(driver);
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.remover.txt", ProjectBaseConstantPaths.LOCATORS_FILE1));
		// validate.updatedtotalValidation(values, driver);
	//	ExtentReport.reportLog("home", "failed");
	}
	/*
	 * @AfterClass public void teardown() { driver.close(); }
	 */

}
