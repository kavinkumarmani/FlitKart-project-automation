package com.flipkart.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.parent.Baseclass;

public class HPlaptopspage extends Baseclass {
	
	//@FindBy(xpath="//div[@class='_3wU53n']")
	//WebElement name;
	
	@FindBy(xpath="//div[@class='_1vC4OE _3qQ9m1']")
	WebElement price;
	
	@FindBy(xpath="//div[@class='VGWI6T _1iCvwn']")
	WebElement offer;
	
	public HPlaptopspage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public void HPlaptopsdata() throws Exception {
		
		//writeexcel
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("HPlaptop details");
		
		List<WebElement>HPlaptops=driver.findElements(By.xpath("//div[@class='_3wU53n']"));
		int names=HPlaptops.size();
		int rownum =0;
		//set header
		
		Row row = sheet.createRow(rownum++);
		row.createCell(0).setCellValue("PRODUCT NAME");
		row.createCell(1).setCellValue("PRODUCT PRICE");
		row.createCell(2).setCellValue("OFFER DETAILS");
		
		for(int i=0;i<names;i++) {
			String name= HPlaptops.get(i).getText();
		//click on laptops one by one
			driver.findElement(By.xpath("(//div[@class='_3wU53n'])["+(i+1)+"]")).click();
			Thread.sleep(5000);
		//switching to child window
			Set<String>secondwindow=driver.getWindowHandles();
			Iterator<String> it=secondwindow.iterator();
			String parentwindowid=it.next();
			String childwindowid=it.next();
			driver.switchTo().window(childwindowid);
		//store price and offer
			String pprice=price.getText();
			String poffer="0";
			
			//offers page
			try{
				poffer=offer.getText();
			}
			catch(Exception e) {
				poffer="0";
			}
		//create rows
			
			row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(name);
			row.createCell(1).setCellValue(pprice);
			row.createCell(2).setCellValue(poffer);
			
			driver.close();
			driver.switchTo().window(parentwindowid);
		}
		
		 try
	        {
	            //Write the workbook in file system
			 	File src = new File("C:\\Users\\Saran\\eclipse-workspace\\Flipkartproject\\src\\main\\java\\com\\flipkart\\exceldata\\HPLaptopdetails.xlsx");
			 	src.createNewFile();
	            FileOutputStream out = new FileOutputStream(src);
	            wb.write(out);
	            wb.close();

	            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
		 wb.close();
		
	}
}

