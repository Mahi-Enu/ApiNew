package com.api.genericLib;

import org.hamcrest.Matchers;
import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * @author Gaurav
 *
 * {@code} This is useful for all common scenarios for Rest API
 * 
 * @since 2020
 */
public class RestAssuredCommonUtils {

	/**
	 * @author Gaurav
	 * @param resp to fetch status code
	 * @param expectedStatusCode for validation of actual status code
	 */
	public void validateStatusCode(Response resp , int expectedStatusCode)
	{
		resp.then().assertThat().statusCode(expectedStatusCode);
		System.out.println("status code validation is successfull");
	}
	
	public void validateContentType(Response resp)
	{
		resp.then().assertThat().contentType(ContentType.JSON);
		System.out.println("content type validation is successfull");
	}
	
	public void validateResponseTime(Response resp , long rangeofWithInTime)
	{
		resp.then().assertThat().time(Matchers.lessThan(rangeofWithInTime));
		System.out.println("Response Time validation is successfull");
	}
	
	public void validateKVPair(Response resp , String jsonpath , String expectedValue)
	{
		Object obj = resp.jsonPath().get(jsonpath);
		String actualValue = obj.toString();
		Assert.assertEquals(actualValue, expectedValue);
	}
	
	public String fetchTokenID(Response resp , String jsonPath)
	{
		Object objtoken = resp.jsonPath().get(jsonPath);
		return objtoken.toString();
	}
}












