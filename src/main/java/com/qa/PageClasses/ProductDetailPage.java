package com.qa.PageClasses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BaseClass.BaseClass;

public class ProductDetailPage extends BaseClass {

	@FindBy(xpath = "//input[@name ='q' and @type='text']")
	WebElement SearchBox;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	WebElement CancelMark;

	@FindBy(xpath = "//button[@class='L0Z3Pu']")
	WebElement SearchButton;

	@FindBy(xpath = "//a[@title='Mobiles']")
	WebElement MobileLink;

	@FindBy(xpath = "//div[@class='_24_Dny _3tCU7L']")
	WebElement FlipkartAssured;

	@FindBy(xpath = "//div[@class='_4921Z t0pPfW' and @title='Samsung']")
	WebElement Brand;

	@FindBy(xpath = "//div[contains(text(),'Price -- High to Low')]")
	WebElement High_to_Low;

	public ProductDetailPage() {

		PageFactory.initElements(driver, this);
	}

	public void ProductDetail() {
		CancelMark.click(); // Clicking on Cross button

		SearchBox.sendKeys(pr.getProperty("ProductName").trim());// Enter ProductName in Search text box

		SearchButton.click(); // Clicked on Search button

		MobileLink.click();// Click action on link

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_24_Dny
		// _3tCU7L']")));
		FlipkartAssured.click();

		wait.until(ExpectedConditions.elementToBeClickable(Brand));
		Brand.click();
		wait.until(ExpectedConditions.elementToBeClickable(High_to_Low));
		High_to_Low.click(); // click on High to Low filter
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Fetch All the Products Text
		List<WebElement> list_of_products = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> list_of_products_price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));

		// Use of HashMaop to store Products and Their prices(after conversion to
		// Integer)
		String product_name;
		String product_price;
		int int_product_price;
		TreeMap<Integer, String> map_final_products = new TreeMap<Integer, String>();
		for (int i = 0; i < list_of_products.size(); i++) {
			product_name = list_of_products.get(i).getText();// Iterate and fetch product name
			product_price = list_of_products_price.get(i).getText();// Iterate and fetch product price
			product_price = product_price.replaceAll("[^0-9]", "");// Replace anything with space other than numbers
			int_product_price = Integer.parseInt(product_price);// Convert to Integer
			map_final_products.put(int_product_price, product_name);// Add product and price in HashMap
		}
		for (Entry<Integer, String> entry : map_final_products.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
//		Set<Integer> allkeys = map_final_products.keySet();
//		ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);
//		
//		//Sort the Prices in Array List using Collections class
//		//this will sort in ascending order lowest at the top and highest at the bottom
//		Collections.sort(array_list_values_product_prices);
//		
//		Collections.sort(array_list_values_product_prices, Collections.reverseOrder()); 
//		System.out.println(array_list_values_product_prices);
//		
//		Collection<String> allvalues =map_final_products.values();
//		ArrayList<String> array_list_values_product_name = new ArrayList<String>(allvalues);
//		
//		//Sort the Prices in Array List using Collections class
//		//this will sort in ascending order lowest at the top and highest at the bottom
//		Collections.sort(array_list_values_product_name);
//		
//		Collections.sort(array_list_values_product_name, Collections.reverseOrder()); 
//		System.out.println(array_list_values_product_name);
		
	}


}
