package com.ra.pratice;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DemoJsonPath {

//	@Test
	public void checkJsonPath()
	{
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/all");
		
		ArrayList<Object> allCurrencyCode = resp.jsonPath().get("currencies.code");
		System.out.println(allCurrencyCode);
		
		Object firstCC = resp.jsonPath().get("currencies.code[0]");
		System.out.println("1st currancy code : " + firstCC);
		
		Object obj = resp.jsonPath().get("currencies.code[99]");
		System.out.println("100th currancy code : " + obj);
		
	}
//	@Test
	public void fetchCodeByCountry()
	{
		String reqCountry = "Vanuatu";
		boolean flag = false;
		
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/all");
		
		ArrayList<Object> allCountryName = resp.jsonPath().get("name");
		
		Iterator<Object> itr = allCountryName.iterator();
		int count = 0;
		while(itr.hasNext())
		{
			Object obj = itr.next();
			if(obj.equals(reqCountry))
			{
				System.out.println(reqCountry + " is present in a list");
				Object reqCode = resp.jsonPath().get("currencies.code["+ count +"]");
				System.out.println(reqCountry + " is having currency code as : " + reqCode);
				flag = true;
				break;
			}
			count++;
		}
		if(!flag)
		{
			System.out.println(reqCountry + " is not present in a list");
		}	
	}
	
	@Test
	public void fetchCodeByCoutryName()
	{
		String reqCountry = "India";
		
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/all");
		
		ArrayList<Object> allCountryName = resp.jsonPath().get("name");
		
		if(allCountryName.contains(reqCountry))
		{
			int index = allCountryName.indexOf(reqCountry);
			Object reqCode = resp.jsonPath().get("currencies.code["+ index +"]");
			System.out.println(reqCountry + " is having currency code as : " + reqCode);
		}else{
		//	System.out.println(reqCountry + " is not present in a list");
			throw new IllegalArgumentException("Invalid Country Name");
		}
		
	}
}

















