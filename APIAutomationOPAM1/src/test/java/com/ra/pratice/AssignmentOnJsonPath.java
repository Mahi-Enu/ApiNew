package com.ra.pratice;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AssignmentOnJsonPath {

	//@Test
	public void assignment1()
	{
		String reqCode = "[INR]";
		boolean flag = false;
		
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/all");
		
		ArrayList<Object> allCurrencyCode = resp.jsonPath().get("currencies.code");
		
		Iterator<Object> itr = allCurrencyCode.iterator();
		int count = 0;
		while(itr.hasNext())
		{
			Object obj = itr.next();
			String str = obj.toString();
			if(str.equals(reqCode))
			{
				System.out.println(reqCode + " currency code present in a list");
				Object name = resp.jsonPath().get("name[" + count + "]");
				System.out.println("country name for " + reqCode + " is " + name);
				
				Object callingCode = resp.jsonPath().get("callingCodes["+count+"]");
				System.out.println("calling code for " + reqCode + " is " + callingCode) ;
				
				Object population = resp.jsonPath().get("population[" + count + "]");
				System.out.println("population for " + reqCode + " is " + population);
				
				Object capital = resp.jsonPath().get("capital[" + count + "]");
				System.out.println("Capital for " + reqCode + " is " + capital);
				
				flag = true;
				break;
			}
			count++;
		}
		if(!flag)
		{
			System.out.println(reqCode +  " currency code not present in a list");
		}
	}
	
	@Test
	public void assignment2() throws InterruptedException
	{
		Response resp = RestAssured.get("https://www.googleapis.com/books/v1/volumes?q=turing");
		
		Thread.sleep(2000);
		
		ArrayList<Object> allTitle = resp.jsonPath().get("items.volumeInfo.title");
	
		Iterator<Object> itr = allTitle.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		System.out.println("Total Titles are : " + allTitle.size());
	}
}

















