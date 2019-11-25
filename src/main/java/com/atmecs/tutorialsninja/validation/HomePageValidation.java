package com.atmecs.tutorialsninja.validation;

import org.openqa.selenium.WebDriver;
import com.atmecs.tutorialninja.Testsuite.Pageactions;
import com.atmecs.tutorialninja.helper.HomepageHelper;
import com.atmecs.tutorialsninja.utils.LogReport;
import com.atmecs.tutorialsninja.utils.MyDataBase;
import com.atmecs.tutorialsninja.utils.ReadLocatorsFile;

public class HomePageValidation {
	Pageactions page;
	ReadLocatorsFile read;
	HomepageHelper helper;
	LogReport log;
    MyDataBase database;
	public void titleValidate(WebDriver driver) throws Exception {
		page = new Pageactions(driver);
		database=new MyDataBase();
		//String expectedproduct = page.getdata_fromExcel("Sheet4", "Product Details", "title");
		String name = database.db("assessment", "project", "name", 5);
		helper = new HomepageHelper(driver);
		helper.performAction(driver, name, "validate.text.txt");
	}

	public void avilabilityValidation(WebDriver driver) throws Exception {
		//String expectedproduct = page.getdata_fromExcel("Sheet4", "Product Details", "Iphone avilability");
		String name = database.db("assessment", "project", "name", 6);
		helper.performAction(driver, name, "validate.iphoneavilability.txt");
	}

	public void productdescriptionValidation(WebDriver driver) throws Exception {
		//String expectedproduct = page.getdata_fromExcel("Sheet4", "Product Details", "Iphone product description");
		String name = database.db("assessment", "project", "name", 7);
		helper.performAction(driver, name, "validate.iphoneproductdescription.txt");
	}

	public void priceValidation(WebDriver driver) throws Exception {
		//String expectedproduct = page.getdata_fromExcel("Sheet4", "Product Details", "Iphone price");
		String name = database.db("assessment", "project", "name", 8);
		helper.performAction(driver, name, "validate.iphoneprice.txt");
	}

	public void taxValidation(WebDriver driver) throws Exception {
		//String expectedproduct = page.getdata_fromExcel("Sheet4", "Product Details", "Iphone tax");
		String name = database.db("assessment", "project", "name", 9);
		helper.performAction(driver, name, "validate.iphonetax.txt");
	}

	public void macavilabilityValidation(WebDriver driver) throws Exception {
		//String expectedproduct = page.getdata_fromExcel("Sheet4", "Product Details", "Mac avilability");
		String name = database.db("assessment", "project", "name", 10);
		helper.performAction(driver, name, "validate.macavilability.txt");
	}

	public void macproductdescriptionValidation(WebDriver driver) throws Exception {
		//String expectedproduct = page.getdata_fromExcel("Sheet4", "Product Details", "Mac product description");
		String name = database.db("assessment", "project", "name", 11);
		helper.performAction(driver, name, "validate.macproductdescription.txt");
	}

	public void macpriceValidation(WebDriver driver) throws Exception {
		//String expectedproduct = page.getdata_fromExcel("Sheet4", "Product Details", "Mac price");
		String name = database.db("assessment", "project", "name", 12);
		helper.performAction(driver, name, "validate.macprice.txt");
	}

	public void mactaxValidation(WebDriver driver) throws Exception {
		//String expectedproduct = page.getdata_fromExcel("Sheet4", "Product Details", "Mac tax");
		String name = database.db("assessment", "project", "name", 13);
		helper.performAction(driver, name, "validate.mactax.txt");
	}

	public void totalValidation(WebDriver driver) throws Exception {
		//String expectedproduct = page.getdata_fromExcel("Sheet4", "Product Details", "total price");
		String name = database.db("assessment", "project", "name", 14);
		helper.performAction(driver, name, "validate.total.txt");
	}

	public void updatedtotalValidation(WebDriver driver) throws Exception{
		//String expectedproduct = page.getdata_fromExcel("Sheet4", "Product Details", "Updated total price");
		String name = database.db("assessment", "project", "name", 15);
		helper.performAction(driver, name, "validate.updatetotal.txt");
	}

}