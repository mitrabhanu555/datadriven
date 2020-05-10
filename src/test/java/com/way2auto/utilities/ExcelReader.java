package com.way2auto.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	
	public static String path;
	public static FileInputStream fis = null;
	public static FileOutputStream fileout = null;
	public static Workbook workbook = null;
	public static Sheet sheet = null;
	public static Row row = null;
	public static Cell cell = null;
	public static File file = null;
	
	public ExcelReader(String path) {
		
		this.path=path;
		try {
			file = new File(path);
			fis = new FileInputStream(file);
			workbook = WorkbookFactory.create(fis);
			sheet = workbook.getSheetAt(0);
			
		} catch (Exception e) {
			
			
		}
		
	}
	
	public static Object[][] getdata() throws Throwable{
		
		Object[][] data = null;
		
		data= new Object[sheet.getPhysicalNumberOfRows()][sheet.getRow(0).getPhysicalNumberOfCells()];
		for (int rowindex = sheet.getFirstRowNum()+1; rowindex < sheet.getPhysicalNumberOfRows(); rowindex++) {
			
			for (int colindex = sheet.getRow(1).getFirstCellNum(); colindex < sheet.getRow(rowindex).getPhysicalNumberOfCells(); colindex++) {
				
				data[rowindex][colindex] = sheet.getRow(rowindex).getCell(colindex).toString();
		
		System.out.println(data[rowindex][colindex]);
	    }
	
      }
		workbook.close();
		return data;
		
   }
	
}
