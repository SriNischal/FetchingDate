package com.atmecs.tutorialsninja.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.atmecs.tutorialsninja.utils.ProjectBaseConstantPaths;

public class ExcelRead {
      public void read(int sheet,int row,int column) throws Exception {
    	  File file=new File(ProjectBaseConstantPaths.EXPECTED_FILE1);
    	  FileInputStream fis=new FileInputStream(file);
    	  XSSFWorkbook book=new XSSFWorkbook(fis);
    	  XSSFSheet sheets=book.getSheetAt(1);
    	  String data=sheets.getRow(row).getCell(10).getStringCellValue();
    	  System.out.println("Data from excel is"+ data);
    	  book.close();
      }
}

