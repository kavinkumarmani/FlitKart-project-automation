package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.parent.Baseclass;

public class Laptopspage extends Baseclass {
	
	@FindBy(xpath="(//div[@class='_1p7h2j'])[2]")
	WebElement checkbox;
	
	@FindBy(xpath="(//div[@class='_1p7h2j'])[9]")
	WebElement HPlaptops;

	public Laptopspage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public HPlaptopspage clickonHPlaptops() throws Exception {
		checkbox.click();
		Thread.sleep(7000);
		HPlaptops.click();
		return new HPlaptopspage();
		
		
		
	}

}
