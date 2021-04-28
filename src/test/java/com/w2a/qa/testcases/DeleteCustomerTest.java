package com.w2a.qa.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.qa.API.DeleteCustomerAPI;
import com.w2a.qa.setup.BaseTest;
import com.w2a.qa.utilities.DataUtil;

import io.restassured.response.Response;

public class DeleteCustomerTest extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public static void ValidateDeleteCustomer(Hashtable<String, String> data)
	{
		Response response = DeleteCustomerAPI.sendDeleteRequestToDeleteCustomerAPIWithValidId(data);
		response.prettyPrint();
		
		String actialId = response.jsonPath().get("id").toString();
		System.out.println("Getting id from json path : "+actialId);
		Assert.assertEquals(actialId, data.get("id"),"id not matching");
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
	}

}
