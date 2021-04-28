package com.w2a.qa.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.qa.utilities.ExcelReader;

import io.restassured.RestAssured;

public class BaseTest {
	
	public static Properties config = new Properties();
	public FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(".//src//test//resources//testdata//testdata.xlsx");
	
	@BeforeSuite
	public void SetUp() throws IOException {
		fis = new FileInputStream(".//src//test//resources//com//w2a//qa//properties//config.properties");
		config.load(fis);
		RestAssured.baseURI = config.getProperty("baseURI");
		RestAssured.basePath=config.getProperty("basePath");
	}
	
	
	@AfterSuite
public void TearDown() {
		
	}

}
