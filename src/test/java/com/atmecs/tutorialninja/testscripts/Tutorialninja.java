package com.atmecs.tutorialninja.testscripts;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.tutorialninja.Testsuite.Pageactions;
import com.atmecs.tutorialninja.Testsuite.TestBase;
import com.atmecs.tutorialsninja.utils.LogReport;
import com.atmecs.tutorialsninja.utils.MyDataBase;
import com.atmecs.tutorialsninja.utils.ProjectBaseConstantPaths;
import com.atmecs.tutorialsninja.utils.Propertiesfile;
import com.atmecs.tutorialsninja.utils.ReadLocatorsFile;

public class Tutorialninja extends TestBase{
	Propertiesfile properties;
	LogReport log;
	String url;
	@BeforeClass
	public void setup() throws IOException {
		properties=new Propertiesfile();
		log=new LogReport();
	url=Propertiesfile.readConfig("url1", ProjectBaseConstantPaths.CONFIG_FILE);
	driver.get(url);
	driver.manage().window().maximize();
	log.info("Application is open...");
	}
	Pageactions page;
	@Test
	public void heatclinic() throws Exception {
	page=new Pageactions(driver);
	page.mouseOn(ReadLocatorsFile.readPropertiesFile("loc.merchandise.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.mens.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	JavascriptExecutor execute = (JavascriptExecutor) driver;
	Object texts = execute.executeScript("return document.querySelector('ul li.Red:nth-of-type(2)')").toString();
}
}
