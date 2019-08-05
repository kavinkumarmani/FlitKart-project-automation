package com.flipkart.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.pages.Homepage;
import com.flipkart.pages.Laptopspage;
import com.flipkart.pages.Loginpage;
import com.flipkart.parent.Baseclass;
import com.flipkart.util.Excelutils;

public class Homepagetest extends Baseclass {
	
	Loginpage loginpage;
	Homepage homepage;
	Laptopspage laptopspage;
	

	public Homepagetest() throws Exception {
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		initilization();
		loginpage=new Loginpage();
		laptopspage=new Laptopspage();
		homepage=loginpage.login((prop.getProperty("mobilenumber")),(prop.getProperty("password")));
		}
	
	@Test(priority=1,groups="Testcases")
	public void clickonlaptopspagetest() throws Exception {
		laptopspage=homepage.clickonlaptops();
		
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
