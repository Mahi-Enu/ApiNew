package com.ra.pratice;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CheckAssrtion {

	// @Test
	public void demoAssertionByTestNG()
	{
		Response resp = given().param("userId"	, "4")
						.when().get("https://jsonplaceholder.typicode.com/posts");
		
		int statusCode = resp.getStatusCode();
		System.out.println("Status code is : " + statusCode + "\n");
		Assert.assertEquals(statusCode, 200);
		
		String contentType = resp.getContentType();
		System.out.println("Content Type is : " + contentType + "\n");
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		
		long timeInMs = resp.getTime();
		System.out.println("Response Time is : " + timeInMs + "\n");
		Assert.assertTrue(timeInMs < 5000);
		
		Object title = resp.jsonPath().get("title[3]");
		System.out.println("4th title is : " + title + "\n");
		Assert.assertEquals(title, "magnam ut rerum iure");
		
		resp.then().log().all();
	}
	
	@Test
	public void demoAssertionByRA()
	{
		Response resp = given().param("userId"	, "4")
						.when().get("https://jsonplaceholder.typicode.com/posts");
		
		resp.then().assertThat()
		.statusCode(200)
		.and()
		.contentType(ContentType.JSON)
		.and()
		.time(Matchers.lessThan(6000L))
		.and()
		.log().all();
	}
}

















