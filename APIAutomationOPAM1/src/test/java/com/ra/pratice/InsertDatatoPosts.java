package com.ra.pratice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class InsertDatatoPosts {

	@Test
	public void addData()
	{
		//step 1 :- Set the Precondition for request
		RequestSpecification reqsp = RestAssured.given();
		
		// step 2 :- Create a Json Object by using JSONOBject class
		JSONObject jobj = new JSONObject();
		jobj.put("id", 7);
		jobj.put("name", "Prajana");
		jobj.put("skills", "Automation");
		
		// step 3 :- Convert a Java Object into JSONForm
		String jsonData = jobj.toJSONString();
		
		// step 4 :- Keep tha jsonData inside a body part of request
		reqsp.body(jsonData);
		
		// step 5 :- set the content Type for request
		reqsp.contentType(ContentType.JSON);
		
		// step 6 :- attach or apply the precondtion on a request
		RequestSender sender = reqsp.when();
		
		// step 7 :- send the request on perticular API
		Response resp = sender.post("http://localhost:3000/posts");
	
		// used to fetch complete response
		ValidatableResponse vr = resp.then();
		vr.log().all();
	}
}


















