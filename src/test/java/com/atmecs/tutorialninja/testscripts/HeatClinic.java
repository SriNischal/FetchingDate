package com.atmecs.tutorialninja.testscripts;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.atmecs.tutorialninja.Testsuite.Pageactions;
import com.atmecs.tutorialninja.Testsuite.TestBase;
import com.atmecs.tutorialsninja.dataprovider.DataProvides;
import com.atmecs.tutorialsninja.utils.LogReport;
import com.atmecs.tutorialsninja.utils.MyDataBase;
import com.atmecs.tutorialsninja.utils.ProjectBaseConstantPaths;
import com.atmecs.tutorialsninja.utils.Propertiesfile;
import com.atmecs.tutorialsninja.utils.ReadLocatorsFile;
import com.atmecs.tutorialsninja.utils.ThreadPool;
import com.atmecs.tutorialsninja.utils.Waitsclass;
import com.atmecs.tutorialsninja.validation.HeatClinicvalidation;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class HeatClinic extends TestBase{
	Pageactions page;
	Propertiesfile properties;
	String url;
	ReadLocatorsFile read;
	Waitsclass wait;
	LogReport log;
	HeatClinicvalidation validate;
	MyDataBase database;
	String personalizedName;
	String productQuantity;
	@BeforeClass
	public void setup() throws IOException {
		//ThreadPool.setDriver(driver);
		properties=new Propertiesfile();
		log=new LogReport();
	url=Propertiesfile.readConfig("url2", ProjectBaseConstantPaths.CONFIG_FILE);
	driver.get(url);
	//ThreadPool.setDriver(driver);
	driver.manage().window().maximize();
	log.info("Application is open...");
	}
	@Test
	public void heatclinic() throws Exception {
	
		database=new MyDataBase();
		//validate=new HeatClinicvalidation();
		page=new Pageactions(driver);
		log.info("Script started");
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.home.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		//validate.homeproductValidate(driver);
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.hotsauces.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		//validate.hotsauceproductValidate(driver);
		log.info("completed validating hotsauces");
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.merchandise.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		//validate.merchandiseproductValidate(driver);
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.clearance.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		//validate.clearanceproductValidate(driver);
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.newtohotsauce.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		//validate.newtohotsauceproductValidate(driver);
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.faq.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		//validate.faqproductValidate(driver);
		page.mouseOn(ReadLocatorsFile.readPropertiesFile("loc.merchandise.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.mens.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		//validate.mensValidate(driver);
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.red.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.medium.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		String personalizeddata=page.getdata_fromExcel("Sheet3", "Values to enter", "Value to enter");
		//String personalizeddata=database.db("assessment","heatclinic", "name", 1);
		page.sendKeys(ReadLocatorsFile.readPropertiesFile("loc.personalizwdname.txt", ProjectBaseConstantPaths.LOCATORS_FILE), personalizeddata);
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.buynow.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		//wait.threadwait();
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.cart.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		//log.info("done");
		//validate.productValidate(driver);
		//validate.priceValidate(driver);
		//validate.totalpriceValidate(driver);
		page.clear(ReadLocatorsFile.readPropertiesFile("loc.quantity.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String quantity=page.getdata_fromExcel("Sheet3", "Values to enter", "quantity");
		//String quantity=database.db("assessment", "heatclinic", "name", 2);
		page.sendKeys(ReadLocatorsFile.readPropertiesFile("loc.quantity.txt", ProjectBaseConstantPaths.LOCATORS_FILE), quantity);
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.update.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		//driver.switchTo().alert().accept();
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.update.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		//validate.updatepriceValidate(driver);
		//ExtentReport.reportLog("heatclinic", "failed");
		
	}
	/*
	 * @AfterClass public void teardown() { driver.quit(); }
	 */

}
