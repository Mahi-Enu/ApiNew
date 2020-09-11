package com.ra.pratice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class CheckEmployess {

	@Test
	public void fetchAllEmployee()
	{
		given().pathParam("x", "api").pathParam("y", "v1").pathParam("z", "employees")
		.when().get("http://dummy.restapiexample.com/{x}/{y}/{z}")
		.then().log().all();
		
		/*
		Response resp = get("http://dummy.restapiexample.com/api/v1/employees");
		resp.then().log().all();*/
	}
	
	
	
	
	
	
	
	
	
	
	//@Test
	public void fetchSpecificEmployee()
	{
		Response resp = get("http://dummy.restapiexample.com/api/v1/employee/12");
		resp.then().log().all();
	}
	
	//@Test
	public void addEmployee()
	{
		//step 1 :- Set the Precondition for request
		RequestSpecification reqsp = given();
		
		// step 2 :- Create a Json Object by using JSONOBject class
		JSONObject jobj = new JSONObject();
		jobj.put("id", 25);
		jobj.put("employee_name", "Prajana");
		jobj.put("employee_salary", "50000");
		jobj.put("employee_age", "24");
		jobj.put("profile_image", "");
		
		// step 3 :- Convert a Java Object into JSONForm
		String jsonData = jobj.toJSONString();
		
		// step 4 :- Keep tha jsonData inside a body part of request
		reqsp.body(jsonData);
		
		// step 5 :- set the content Type for request
		reqsp.contentType(ContentType.JSON);
		
		// step 6 :- attach or apply the precondtion on a request
		RequestSender sender = reqsp.when();
		
		// step 7 :- send the request on perticular API
		Response resp = sender.post("http://dummy.restapiexample.com/api/v1/create");
	
		// used to fetch complete response
		ValidatableResponse vr = resp.then();
		vr.log().all();
	}
}












