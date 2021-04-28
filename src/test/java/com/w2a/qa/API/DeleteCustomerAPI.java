package com.w2a.qa.API;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.qa.setup.BaseTest;

import io.restassured.response.Response;

public class DeleteCustomerAPI extends BaseTest{
	
	public static Response sendDeleteRequestToDeleteCustomerAPIWithValidId(Hashtable<String, String> data) {
		
		Response response = given().auth().basic(config.getProperty("validSecreteKey"), "")
				.delete(config.getProperty("customerCreateAPI")+"/"+data.get("id"));
		
		return response;
		
	}  

}
