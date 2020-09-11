package com.api.testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.genericLib.BaseClass;

import io.restassured.response.Response;

public class AddNewDataTest extends BaseClass{

	@Test
	public void createNewData() throws IOException
	{
		String apiTestData = config.getApiTestData("AddNewDataInPosts");
		Response resp = config.executeRequest(apiTestData);
		
		resp.then().log().all();

	}
}













