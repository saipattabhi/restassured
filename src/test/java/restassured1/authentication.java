package restassured1;

import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class authentication {

	
	@Test
	public void authenticationapi()
	{
		
		
		RestAssured.baseURI="";
		
		PreemptiveBasicAuthScheme  authscheme=new PreemptiveBasicAuthScheme();
		
		authscheme.setUserName("");
		authscheme.setPassword("");
		
		RestAssured.authentication=authscheme;
		
		RequestSpecification httprequest=RestAssured.given();
		
		Response response= httprequest.request(Method.GET,"/");
		
		
	}
	
	
	
}
