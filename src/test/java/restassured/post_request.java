package restassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Exceldataconfig.exceldata;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class post_request {

	@Test(dataProvider = "passdata")

	public void postrequest(String ename, String esalary, String eage) {

		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

		RequestSpecification httprequest = RestAssured.given();

		JSONObject requestparametre = new JSONObject();

		requestparametre.put("name", ename);

		requestparametre.put("salary", esalary);

		// "age":"23"

		requestparametre.put("age", eage);

		httprequest.header("Content-Type", "application/json");

		httprequest.body(requestparametre.toJSONString()); // attach data to request

		Response response = httprequest.request(Method.POST, "/create");

		// Response response = httprequest.request(Method.POST);

		String bodi = response.getBody().asString();

		System.out.println("Bodi" + bodi);

		int status = response.getStatusCode();

		Assert.assertEquals(status, 200);
		
		
		
		Assert.assertEquals(bodi.contains(ename), true);
		
		
		

		// sucess code validation

		// String self = response.jsonPath().get("status");

		// Assert.assertEquals(self, "success");

	}

	@DataProvider
	public Object[][] passdata() {

		exceldata data = new exceldata("C:\\Users\\saipa\\Desktop\\New folder\\New Microsoft Excel Worksheet.xlsx");

		int rows = data.getrow(0);
		
		

		Object[][] rest = new Object[rows][3];

		for (int i = 0; i < rows; i++) {
			rest[i][0] = data.getexceldata(0, i, 0);

			rest[i][1] = data.getexceldata(0, i, 1);

			rest[i][2] = data.getexceldata(0, i, 2);

		}

		return rest;

	}

}
