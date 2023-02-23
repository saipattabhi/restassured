package restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class get_dumyresponse {

	@Test
	public void getrequestresponse() {

		RestAssured.baseURI = "https://reqres.in";

		RequestSpecification httprequest = RestAssured.given();

		Response response = httprequest.request(Method.GET, "/api/users?page=2");

		String responsebody = response.getBody().asString();

		System.out.println("Response body" + responsebody);

		int statuscode = response.getStatusCode();

		System.out.println("Status Code is " + statuscode);

		Assert.assertEquals(statuscode, 200);

	}

}
