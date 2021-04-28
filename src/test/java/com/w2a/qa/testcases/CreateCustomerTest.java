package com.w2a.qa.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.qa.API.CreateCustomerAPI;
import com.w2a.qa.setup.BaseTest;
import com.w2a.qa.utilities.DataUtil;

import io.restassured.response.Response;

public class CreateCustomerTest extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public static void ValidateCreateCustomerAPIWihValidSecreteKey(Hashtable<String, String> data)
	{
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(data);
		response.prettyPrint();
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public static void ValidateCreateCustomerAPIWihInvalidSecreteKey(Hashtable<String, String> data) 
	{
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithInalidAuthKey(data);
		response.prettyPrint();
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(), 401);
	}

}
