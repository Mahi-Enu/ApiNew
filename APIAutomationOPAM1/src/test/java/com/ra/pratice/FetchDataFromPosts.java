package com.ra.pratice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchDataFromPosts {

	@Test
	public void getData()
	{
		Response resp = RestAssured.get("http://localhost:3000/posts");
				
		int statusCode = resp.getStatusCode();
		System.out.println("Status code is : " + statusCode);
		
		System.out.println("-------------------------------------------");
		String contentType = resp.getContentType();
		System.out.println("Content type is : " + contentType);
		
		System.out.println("-------------------------------------------");
		long time = resp.getTime();
		System.out.println("Time for Response is : " + time + " ms");
		
		System.out.println("-------------------------------------------");
		String actualContent = resp.asString();
		System.out.println("Actual Data is \n" + actualContent);
	}
}















