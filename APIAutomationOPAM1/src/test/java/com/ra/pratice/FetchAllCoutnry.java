package com.ra.pratice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchAllCoutnry {

	@Test
	public void getAllCountry()
	{
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/all");
		
		/*we will get complete actual content from response body in a String form
		String ac = resp.asString();
		System.out.println(ac);*/
		
		/*fetch complete response with actual content & all headers
		resp.then().log().all();*/
		
		
		// this method will used to print directly actual content
		resp.prettyPrint();
	}
}
















