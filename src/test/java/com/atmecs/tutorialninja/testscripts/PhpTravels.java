package com.atmecs.tutorialninja.testscripts;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.tutorialninja.Testsuite.Pageactions;
import com.atmecs.tutorialninja.Testsuite.TestBase;
import com.atmecs.tutorialsninja.utils.LogReport;
import com.atmecs.tutorialsninja.utils.ProjectBaseConstantPaths;
import com.atmecs.tutorialsninja.utils.Propertiesfile;
import com.atmecs.tutorialsninja.utils.RandomNumber;
import com.atmecs.tutorialsninja.utils.ReadLocatorsFile;
import com.atmecs.tutorialsninja.validation.PhpTravelsValidation;

public class PhpTravels extends TestBase{
	Pageactions page;
	Propertiesfile properties;
	LogReport log;
	String url;
	RandomNumber random;
	ReadLocatorsFile read;
	PhpTravelsValidation validate;
	@BeforeClass
	public void setup() throws IOException {
		properties=new Propertiesfile();
		log=new LogReport();
	url=Propertiesfile.readConfig("PhpTravels_url", ProjectBaseConstantPaths.CONFIG_FILE);
	driver.get(url);
	driver.manage().window().maximize();
	log.info("Application is open...");
	}
	@Test
	public void PhpTravels_login() throws Exception {
		page=new Pageactions(driver);
		validate=new PhpTravelsValidation();
		random=new RandomNumber();
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.username.txt", ProjectBaseConstantPaths.PHPTRAVELS_FILE));
		String username=page.getdata_fromExcel("PhpTravels", "Input Data", "username");
		page.sendKeys(ReadLocatorsFile.readPropertiesFile("loc.username.txt", ProjectBaseConstantPaths.PHPTRAVELS_FILE), username);
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.password.txt", ProjectBaseConstantPaths.PHPTRAVELS_FILE));
		String password=page.getdata_fromExcel("PhpTravels", "Input Data", "password");
		page.sendKeys(ReadLocatorsFile.readPropertiesFile("loc.password.txt", ProjectBaseConstantPaths.PHPTRAVELS_FILE), password);
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.login.btn", ProjectBaseConstantPaths.PHPTRAVELS_FILE));
		Thread.sleep(3000);
		page.clickOnElement(ReadLocatorsFile.readPropertiesFile("loc.gotit.txt", ProjectBaseConstantPaths.PHPTRAVELS_FILE));
		validate.contentTextValidate(driver);
		validate.bookingValidation(driver);   
		validate.timeValidation(driver);
		validate.dateValidation(driver);
		validate.paymentValidation(driver);
		String number=ReadLocatorsFile.readPropertiesFile("loc.invoice.btn", ProjectBaseConstantPaths.PHPTRAVELS_FILE);
		String invoiceLocator=number.replace("*",number);
		System.out.println(invoiceLocator);
		page.clickOnElement(invoiceLocator);
		//validate.bookingnumberValidation(driver);
	}

}
