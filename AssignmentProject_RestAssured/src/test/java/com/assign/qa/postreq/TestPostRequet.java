package com.assign.qa.postreq;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestPostRequet {
	
	@Test
	public void launchGet() {
		
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(res.statusCode());
		System.out.println(res.getBody().asString());
		System.out.println(res.statusLine());
		System.out.println(res.asString());
		
		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	
	}
	
	@Test
	public void launchPost() {
		
		JSONObject obj = new JSONObject();
		obj.put("name", "yusuf");
		obj.put("job", "testing");

		System.out.println(obj);
		System.out.println(obj.toString());
		
		
		given().body(obj.toJSONString()).
		when().
		post("https://reqres.in/api/users").
		then().statusCode(201 );
	}

}
















