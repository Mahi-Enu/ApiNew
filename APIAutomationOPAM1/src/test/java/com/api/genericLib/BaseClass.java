package com.api.genericLib;

import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.*;

public class BaseClass {

	public ApiConfig config = new ApiConfig();
	public RestAssuredCommonUtils raUtils = new RestAssuredCommonUtils();

	/*@BeforeSuite
	public void configBS()
	{
		baseURI = "https://restcountries.eu";
		basePath = "/rest/v2";
	}
	// In real time we need to go for this approach
	*/
}
