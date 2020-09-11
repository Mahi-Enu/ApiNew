package com.ra.pratice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CheckParameters {

	@Test
	public void checkQueryString()
	{	
		given()
		.param("userId", "7")
		.pathParam("x", "posts")
		.when()
		.get("https://jsonplaceholder.typicode.com/{x}")
		.then().log().all();
	}
}











