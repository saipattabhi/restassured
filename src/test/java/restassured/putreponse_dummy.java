package restassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class putreponse_dummy {

	@Test
	public void updatedata() {

		RestAssured.baseURI = "https://reqres.in/api";

		RequestSpecification httprequest = RestAssured.given();

		JSONObject responsepara = new JSONObject();

		responsepara.put("name", "babji");

		responsepara.put("job", "bondamakes");

		httprequest.header("Content-Type", "application/json");

		httprequest.body(responsepara.toJSONString());

		Response response = httprequest.request(Method.PUT, "/users/2");
		
		
	String responsebody = response.getBody().asString();
	
	System.out.println("Response Body"+responsebody);
	
	int statuscode = response.getStatusCode();
	
	System.out.println("Status Code"+statuscode);
	
	Assert.assertEquals(statuscode, 200);
	

	}

}
