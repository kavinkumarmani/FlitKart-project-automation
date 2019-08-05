package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.parent.Baseclass;

public class Homepage extends Baseclass{
	
	@FindBy(xpath="(//span[@class='_1QZ6fC _3Lgyp8'])[1]")
	WebElement electronics;

	@FindBy(xpath="//a[@title='Laptops']")
	WebElement laptops;
	
	public Homepage() throws Exception {
		
	PageFactory.initElements(driver, this);
		}
	public Laptopspage clickonlaptops() throws Exception {
		Actions action=new Actions(driver);
		Thread.sleep(5000);
		action.moveToElement(electronics).perform();
		Thread.sleep(3000);
		action.moveToElement(laptops).click().perform();
		return new Laptopspage();
		
		
	}

}
