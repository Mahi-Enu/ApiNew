package com.ra.pratice;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class CheckAuthentication {

	public void demoBasicPreemptive()
	{
		Response resp = given().auth().preemptive().basic("username", "password")
						.when().get("Authorised API");
		
		resp.then().log().all();
	}
	
	public void demoBasicChallenging()
	{
		Response resp = given().auth().basic("username", "password")
						.when().get("Authorised API");
		
		resp.then().log().all();
	}
	
	public void demoTokenAuth()
	{
		String tokenID = getTokenID();
		Response resp = given().auth().oauth2(tokenID)
						.when().get("authorised api");
		
		resp.then().log().all();
	}
	
	public String getTokenID()
	{
		Response resp = get("Token provider api");
		
		Object token = resp.jsonPath().get("SecurityToken");
		
		return token.toString();
	}
}


















