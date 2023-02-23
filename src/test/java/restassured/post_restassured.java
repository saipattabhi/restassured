package restassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class post_restassured {

	@Test

	public void postrequest() {

		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

		RequestSpecification httprequest = RestAssured.given();

		JSONObject requestparametre = new JSONObject();

		requestparametre.put("name","suchitra");

		requestparametre.put("salary","42500");
		
		//"age":"23"
		
		requestparametre.put("age","35");

		httprequest.head("Content-Type", "application/json");

		httprequest.body(requestparametre.toJSONString()); // attach data to request

		Response response = httprequest.request(Method.POST,"/create");

		// Response response = httprequest.request(Method.POST);

		String bodi = response.getBody().asString();

		System.out.println("Bodi" + bodi);

		int status = response.getStatusCode();

		Assert.assertEquals(status, 200);

		// sucess code validation

		//String self = response.jsonPath().get("status");

		//Assert.assertEquals(self, "success");

	}

}
