package com.qa.TestClasses;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.PageClasses.ProductDetailPage;
import com.qa.Utilities.Utilities;

import BaseClass.BaseClass;

public class ProductDetailTest extends BaseClass {

	Logger log = Logger.getLogger(ProductDetailTest.class);
	ProductDetailPage productpage;
	Utilities utility;

	public ProductDetailTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		log.info(
				"****************************** Starting test cases execution  *****************************************");
		initialization();
		productpage = new ProductDetailPage();
		utility = new Utilities();

	}

	@Test
	public void YourLogoLogin() {
		log.info(
				"****************************** Actions on the given scenario Application *****************************************");
		productpage.ProductDetail();

	}

	@AfterMethod
	public void teardown() throws Throwable {
		
//		driver.quit();

	}

}
