package com.atmecs.tutorialninja.helper;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.tutorialninja.Testsuite.Pageactions;
import com.atmecs.tutorialsninja.utils.LogReport;
import com.atmecs.tutorialsninja.utils.ProjectBaseConstantPaths;
import com.atmecs.tutorialsninja.utils.ReadLocatorsFile;

public class HomepageHelper {
	Pageactions page;
	LogReport log;
	ReadLocatorsFile read;
	public WebDriver driver;
	
	public HomepageHelper(WebDriver driver)
	{
		this.driver=driver;
	}
	public void performAction(WebDriver driver,String expectedData,String validationMessage) throws Exception
	{
		page = new Pageactions(driver);
		log=new LogReport();
        read=new ReadLocatorsFile(driver);
		String actualproduct;
        actualproduct=page.getText(ReadLocatorsFile.getData(validationMessage,ProjectBaseConstantPaths.LOCATORS_FILE1));
		Assert.assertEquals(actualproduct, expectedData);
		log.info("Successfully validated " + expectedData);
		System.out.println(actualproduct);
		System.out.println(expectedData);
	}

}
