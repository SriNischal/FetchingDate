package com.atmecs.tutorialsninja.validation;

import org.openqa.selenium.WebDriver;
import com.atmecs.tutorialninja.Testsuite.Pageactions;
import com.atmecs.tutorialninja.helper.HeatClinicHelper;
import com.atmecs.tutorialninja.helper.HomepageHelper;
import com.atmecs.tutorialsninja.utils.LogReport;
import com.atmecs.tutorialsninja.utils.MyDataBase;
import com.atmecs.tutorialsninja.utils.ReadLocatorsFile;

public class HeatClinicvalidation {
	Pageactions page;
	ReadLocatorsFile read;
	HeatClinicHelper helper;
	LogReport log;
    MyDataBase database;

	public void homeproductValidate(WebDriver driver) throws Exception {
		page = new Pageactions(driver);
		String expectedproduct = page.getdata_fromExcel("Sheet2", "Names", "Home Product title");
		helper = new HeatClinicHelper(driver);
		helper.performAction(driver, expectedproduct, "validate.homeproduct.txt");
	}

	public void hotsauceproductValidate(WebDriver driver) throws Exception {
		String expectedproduct = page.getdata_fromExcel("Sheet2", "Names", "HotSauce Product title");
		helper.performAction(driver, expectedproduct, "validate.hotsauceproduct.txt");
	}

	public void merchandiseproductValidate(WebDriver driver) throws Exception {
		String expectedproduct = page.getdata_fromExcel("Sheet2", "Names", "Mechandise Product title");
		helper.performAction(driver, expectedproduct, "validate.clearanceproduct.txt");
	}

	public void clearanceproductValidate(WebDriver driver) throws Exception {
		String expectedproduct = page.getdata_fromExcel("Sheet2", "Names", "Clearance Product title");
		helper.performAction(driver, expectedproduct, "validate.merchandiseproduct.txt");
	}

	public void newtohotsauceproductValidate(WebDriver driver) throws Exception {
		String expectedproduct = page.getdata_fromExcel("Sheet2", "Names", "New to hot sauce");
		helper.performAction(driver, expectedproduct, "validate.newtohotsauce.txt");
	}

	public void faqproductValidate(WebDriver driver) throws Exception {
		String expectedproduct = page.getdata_fromExcel("Sheet2", "Names", "Faq");
		helper.performAction(driver, expectedproduct, "validate.faq.txt");
	}

	public void mensValidate(WebDriver driver) throws Exception {
		String expectedproduct = page.getdata_fromExcel("Sheet2", "Names", "Viewing mens");
		helper.performAction(driver, expectedproduct, "validate.mens.txt");
	}

	public void productValidate(WebDriver driver) throws Exception {
		String expectedproduct = page.getdata_fromExcel("Sheet2", "Names", "Product title");
		helper.performAction(driver, expectedproduct, "validate.producttitle.txt");
	}

	public void priceValidate(WebDriver driver) throws Exception {
		String expectedproduct = page.getdata_fromExcel("Sheet2", "Names", "price");
		helper.performAction(driver, expectedproduct, "validate.price.txt");
	}

	public void totalpriceValidate(WebDriver driver) throws Exception {
		String expectedproduct = page.getdata_fromExcel("Sheet2", "Names", "total price");
		helper.performAction(driver, expectedproduct, "validate.totalprice.txt");
	}

	public void updatepriceValidate(WebDriver driver) throws Exception {
		String expectedproduct = page.getdata_fromExcel("Sheet2", "Names", "updated total");
		helper.performAction(driver, expectedproduct, "validate.totalprice.txt");
	}
}