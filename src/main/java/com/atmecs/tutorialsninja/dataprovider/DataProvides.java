package com.atmecs.tutorialsninja.dataprovider;

import org.testng.annotations.DataProvider;

import com.atmecs.tutorialsninja.utils.ProjectBaseConstantPaths;

public class DataProvides {

	@DataProvider(name = "destination")
	public Object[][] gethomepagedata() {
		TestDataProvider provideData = new TestDataProvider(ProjectBaseConstantPaths.EXPECTED_FILE1, 0);
		Object[][] getData = provideData.provideData();
		return getData;
	}

	@DataProvider(name = "heatclinic")
	public Object[][] getheroingdata() {
		TestDataProvider provideData = new TestDataProvider(ProjectBaseConstantPaths.EXPECTED_FILE1, 1);
		Object[][] getData = provideData.provideData();
		return getData;
	}
}
