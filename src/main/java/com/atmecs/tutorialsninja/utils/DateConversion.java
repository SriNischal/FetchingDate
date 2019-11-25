package com.atmecs.tutorialsninja.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateConversion {
	static String blogdate;
	static List<String> datesList;
	 public static List<String> convertDate(String actualDate) throws ParseException
	 {
	 try
	 {
	 SimpleDateFormat format1 = new SimpleDateFormat("dd MMMMMM yyyy");
	 SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
	 Date date = format1.parse(actualDate);
	 System.out.println(date+"parsedate");
	 blogdate = (format2.format(date));
	 System.out.println(blogdate +" "+"blogdate");
	 String todaysDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	 System.out.println(todaysDate+" "+"todaysdate");
	 datesList=new ArrayList<String>();
	 datesList.add(blogdate);
	 datesList.add(todaysDate);
	 

}
	 catch(Exception e){
		 System.out.println("Exception occured in converting dates");
	 }
	return datesList;
	 }
}
