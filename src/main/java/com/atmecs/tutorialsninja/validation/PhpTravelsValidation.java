package com.atmecs.tutorialsninja.validation;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.tutorialninja.Testsuite.Pageactions;
import com.atmecs.tutorialninja.helper.PhpTravelsHelper;
import com.atmecs.tutorialsninja.utils.DateConversion;
import com.atmecs.tutorialsninja.utils.LogReport;
import com.atmecs.tutorialsninja.utils.MyDataBase;
import com.atmecs.tutorialsninja.utils.ProjectBaseConstantPaths;
import com.atmecs.tutorialsninja.utils.RandomNumber;
import com.atmecs.tutorialsninja.utils.ReadLocatorsFile;

public class PhpTravelsValidation {
	Pageactions page;
	ReadLocatorsFile read;
	PhpTravelsHelper helper;
	LogReport log;
	MyDataBase database;
	RandomNumber random;
	
	public void contentTextValidate(WebDriver driver) throws Exception {
		page = new Pageactions(driver);
		String expectedproduct = page.getdata_fromExcel("PhpTravelsValidation", "Validation Text", "Page content");
		helper = new PhpTravelsHelper(driver);
		helper.performAction(driver, expectedproduct, "validate.text.txt");
	}

	public void bookingValidation(WebDriver driver) throws Exception {
		String expectedproduct = page.getdata_fromExcel("PhpTravelsValidation", "Validation Text", "Booking content");
		helper.performAction(driver, expectedproduct, "validate.booking.txt");
	}

	public void timeValidation(WebDriver driver) throws Exception {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String time = dtf.format(now);
		helper.performAction(driver, time, "validate.time.txt");
	}

	public void dateValidation(WebDriver driver) throws Exception {
		String date = driver.findElement(By.cssSelector(".h4")).getText();
		List<String> expecteddates = DateConversion.convertDate(date);
		Assert.assertEquals(expecteddates.get(0), expecteddates.get(1));
		System.out.println("dates validated");
		//helper.performAction(driver, expecteddates.get(0), expecteddates.get(1));
	}

	public void bookingnumberValidation(WebDriver driver) throws Exception {
		String expectedproduct = page.getdata_fromExcel("PhpTravelsValidation", "Validation Text", "Booking Content");
		helper.performAction(driver, expectedproduct, "validate.bookingnumber.txt");
	}
	
	public String paymentValidation(WebDriver driver) throws Exception {
		String randomNumber=page.randomnumber("validate.payment.txt", ProjectBaseConstantPaths.PHPTRAVELS_FILE);
		String number=ReadLocatorsFile.readPropertiesFile("validate.payment.txt", ProjectBaseConstantPaths.PHPTRAVELS_FILE);
		String invoiceLocator=number.replace("*",randomNumber);
		String actualpayment=page.getText(invoiceLocator);
		String expectedpayment=page.getdata_fromExcel("PhpTravelsValidation", "Validation Text", "Payment");
		Assert.assertEquals(expectedpayment,actualpayment);
		System.out.println(expectedpayment);
		System.out.println(actualpayment);
		String number1=ReadLocatorsFile.readPropertiesFile("loc.invoice.btn", ProjectBaseConstantPaths.PHPTRAVELS_FILE);
		String invoiceLocator1=number.replace("*",randomNumber);
		System.out.println(number1);
		System.out.println(invoiceLocator1);
		page.clickOnElement(invoiceLocator1);
		return randomNumber;
	}
}

//validate.paymrnt.txt
