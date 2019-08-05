package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.parent.Baseclass;
import com.flipkart.util.Excelutils;

public class Loginpage extends Baseclass{
	
	//pagefactory or object repository
	@FindBy(xpath="//input[@class='_2zrpKA _1dBPDZ']")
	WebElement mobilenumber;
	
	@FindBy(xpath="//input[@class='_2zrpKA _3v41xv _1dBPDZ']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement Loginbutton;
	
	//initilization
	public Loginpage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	//action
	
	public String validatepagetitle() {
		return driver.getTitle();
	}
	
	public Homepage login(String num,String pwd) throws Exception {
		mobilenumber.sendKeys(num);
		password.sendKeys(pwd);
		Loginbutton.click();
		return new Homepage();
		}
	

}
