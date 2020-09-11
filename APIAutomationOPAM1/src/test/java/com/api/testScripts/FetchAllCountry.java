package com.api.testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.genericLib.BaseClass;

import io.restassured.response.Response;

public class FetchAllCountry extends BaseClass{

	@Test
	public void getAllCountry() throws IOException
	{
		String apiTestData = config.getApiTestData("getAllCountryData");
		Response resp = config.executeRequest(apiTestData);
		
		resp.then().log().all();
	}
}







