package com.flipkart.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.flipkart.pages.Homepage;
import com.flipkart.pages.Loginpage;
import com.flipkart.parent.Baseclass;
import com.flipkart.util.Excelutils;

public class Loginpagetest extends Baseclass {
		Loginpage loginpage;
		Homepage homepage;
		public static String username;
		public static String Password;
	

	public Loginpagetest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		initilization();
		Excelutils.setexcelfile();
		loginpage=new Loginpage();
		
		
		 
	}
	@Test(priority=2,groups="Testcases")
	public void logintest() throws Exception {
		username=Excelutils.getcelldata(1,0);
		Password=Excelutils.getcelldata(1,1);
		homepage=loginpage.login(username,Password);
	}
	
	@Test(priority=1,groups="Title")
	public void checktitle() { 
		SoftAssert sa=new SoftAssert();
		String title=loginpage.validatepagetitle();
		System.out.println(title);
		sa.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!","title not matched");
		sa.assertAll();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
