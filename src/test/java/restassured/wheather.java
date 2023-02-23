package restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class wheather {

	@Test
	void wheatherDetails() {

		// specify base URI
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

		// Request Object

		RequestSpecification httprequest = RestAssured.given();

		// response object
		Response response = httprequest.request(Method.GET, "/employees");

		String body = response.getBody().asString();

		System.out.println("Body is" + body);
		
		
        // status code validation
		int status = response.getStatusCode();

		Assert.assertEquals(status, 200);
		
		
		//status line verification
		
		
	String line = response.getStatusLine();
	
	
	System.out.println(line);
	
	Assert.assertEquals(line,"HTTP/1.1 200 OK");
		

	}

}
