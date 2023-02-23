package restassured1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_Request {

	@Test
	public void postrequest() {

		RestAssured.baseURI = "";

		RequestSpecification httprequest = RestAssured.given();
		
		
		JSONObject object=new JSONObject();
		
		object.put("", "");
		
		object.put("", "");
		
		httprequest.header("Content-Type","application/JSON");
		
		httprequest.body(object.toJSONString());
		
		

		Response response = httprequest.request(Method.POST, "");
		
		
		  String body = response.getBody().asString();
		  
		 int statuscode = response.statusCode();
		

	}

}
