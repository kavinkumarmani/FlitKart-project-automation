package com.flipkart.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.pages.HPlaptopspage;
import com.flipkart.pages.Homepage;
import com.flipkart.pages.Laptopspage;
import com.flipkart.pages.Loginpage;
import com.flipkart.parent.Baseclass;

public class Laptopspagetest extends Baseclass { 
	
	Loginpage loginpage;
	Homepage homepage;
	Laptopspage laptopspage;
	HPlaptopspage hplaptopspage;
	
	

	public Laptopspagetest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		initilization();
		loginpage=new Loginpage();
		laptopspage=new Laptopspage();
		homepage=loginpage.login((prop.getProperty("mobilenumber")),(prop.getProperty("password")));
		laptopspage=homepage.clickonlaptops();
		
	}
	
	@Test(groups="Testcases")
	public void clickonHPlaptopstest() throws Exception {
		hplaptopspage=laptopspage.clickonHPlaptops();

		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}
