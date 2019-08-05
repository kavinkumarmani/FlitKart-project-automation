//@author:kavinkumar

package com.flipkart.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.pages.HPlaptopspage;
import com.flipkart.pages.Homepage;
import com.flipkart.pages.Laptopspage;
import com.flipkart.pages.Loginpage;
import com.flipkart.parent.Baseclass;
import com.flipkart.util.Utilities;

public class HPlaptopspagetest extends Baseclass{
	
	Loginpage loginpage;
	Homepage homepage;
	Laptopspage laptopspage;
	HPlaptopspage hplaptopspage;
	
	public HPlaptopspagetest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		initilization();
		loginpage=new Loginpage();
		laptopspage=new Laptopspage();
		hplaptopspage=new HPlaptopspage();
		homepage=loginpage.login((prop.getProperty("mobilenumber")),(prop.getProperty("password")));
		laptopspage=homepage.clickonlaptops();
		hplaptopspage=laptopspage.clickonHPlaptops();
		
	}
	
	@Test(groups="Testcases")
	public void validateexcelwrite() throws Exception {
		hplaptopspage.HPlaptopsdata();
		
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
