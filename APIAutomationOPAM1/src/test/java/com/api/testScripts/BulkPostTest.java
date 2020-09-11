package com.api.testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.genericLib.BaseClass;

import io.restassured.response.Response;

public class BulkPostTest extends BaseClass{

	@Test
	public void addBulkData() throws Exception
	{
		String apiTestData = config.getApiTestData("InsertBulkData");
		Response resp = config.executeBulkPostRequest(apiTestData);
		
		resp.then().log().all();
	}
}









