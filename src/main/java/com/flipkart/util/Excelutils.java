package com.flipkart.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excelutils{
	
	public static XSSFCell cell;
	public static XSSFSheet sheet;
	public static XSSFWorkbook wb;

	public static void setexcelfile() throws Exception {
		
		File src=new File("C:\\Users\\Saran\\eclipse-workspace\\Flipkartproject\\src\\main\\java\\com\\flipkart\\exceldata\\testdata.xlsx");
		FileInputStream fis=new FileInputStream(src);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheetAt(0);
		}
	
	public static String getcelldata(int row,int column) {
		
		cell=sheet.getRow(row).getCell(column);
		String celldata=cell.getStringCellValue();
		return celldata;
		 
		
		
	}

}
