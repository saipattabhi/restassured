package restassured;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class post_dummy {

	@Test
	public void createdata() {

		RestAssured.baseURI = "https://reqres.in";

		RequestSpecification httprequest = RestAssured.given();

		JSONObject responsepara = new JSONObject();

		responsepara.put("name", "aachi");
		
		responsepara.put("job", "cook");

		httprequest.header("Content-Type", "application/json");

		httprequest.body(responsepara.toJSONString());

		Response response = httprequest.request(Method.POST, "/api/users");

		String body = response.getBody().asString();

		System.out.println("Response body is " + body);
		
		
	int code = response.getStatusCode();
	
	System.out.println("Response Code"+code);
	
	Assert.assertEquals(code, 201);
		
		
		

	}

}
