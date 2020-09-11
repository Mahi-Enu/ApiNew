package com.ra.pratice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RemoveDataFromPosts {

	@Test
	public void deleteData()
	{
		Response resp = RestAssured.delete("http://localhost:3000/posts/9");
		
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
