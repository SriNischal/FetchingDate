package com.atmecs.tutorialsninja.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.atmecs.tutorialninja.Testsuite.Pageactions;
import com.atmecs.tutorialsninja.dataprovider.WriteDataToExcel;

public class DateClass {
	public WebDriver driver;
	Pageactions page=new Pageactions(driver);
	
	@Test
	public void calendar() throws Exception {
		WriteDataToExcel writedata=new WriteDataToExcel(ProjectBaseConstantPaths.EXPECTED_FILE1);
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String systemdate=(dateformat.format(now));
        Calendar getData= Calendar.getInstance();
        SimpleDateFormat dateformat1=new SimpleDateFormat("MM/dd/yyyy");
        String previous=page.getdata_fromExcel("Calender", "Number of days", "Subtract month");
        System.out.println(previous);
        int previousmonth=Integer.parseInt(previous);
		getData.add(Calendar.MONTH, previousmonth);
		String previousmonthdate = dateformat1.format(getData.getTime());
		System.out.println("date before 1 month : " + previousmonthdate);
		writedata.setCellData("Calender", "Effective Date", 2, "Add month");

		getData.setTime(dateformat1.parse(systemdate));
		String next= page.getdata_fromExcel("Calender", "Number of days", "Add month");
		System.out.println(next);
		int nextmonth=Integer.parseInt(next);
		getData.add(Calendar.MONTH, nextmonth);
		String nextmonthdate = dateformat1.format(getData.getTime());
		System.out.println("date next 1 month : " + nextmonthdate);
		writedata.setCellData("Calender", "Effective Date", 3, "Subtract month");

		getData.setTime(dateformat1.parse(systemdate));
		String days= page.getdata_fromExcel("Calender", "Number of days", "days to add");
		System.out.println(days);
		int daystoadd=Integer.parseInt(days);
		getData.add(Calendar.DATE, daystoadd);
		String tendaysdate = dateformat1.format(getData.getTime());
		System.out.println("date after tendays : " + tendaysdate);
		writedata.setCellData("Calender", "Effective Date", 4, "days to add");

	}

}
