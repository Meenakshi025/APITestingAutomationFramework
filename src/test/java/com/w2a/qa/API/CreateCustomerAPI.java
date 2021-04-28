package com.w2a.qa.API;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.qa.setup.BaseTest;

import io.restassured.response.Response;

public class CreateCustomerAPI extends BaseTest{
	
	public static Response sendPostRequestToCreateCustomerAPIWithValidAuthKey(Hashtable<String, String> data) {
		
		Response response = given().auth().basic(config.getProperty("validSecreteKey"), "").formParam("name", data.get("name"))
				.formParam("email", data.get("email")).formParam("description", data.get("description"))
				.post(config.getProperty("customerCreateAPI"));
		
		return response;
		
	}
	
    public static Response sendPostRequestToCreateCustomerAPIWithInalidAuthKey(Hashtable<String, String> data) {
    	
    	Response response = given().auth().basic(config.getProperty("invaliSecreteKey"), "").formParam("name", data.get("name"))
				.formParam("email", data.get("email")).formParam("description", data.get("description"))
				.post(config.getProperty("customerCreateAPI"));
		
    	return response;
	}

}
