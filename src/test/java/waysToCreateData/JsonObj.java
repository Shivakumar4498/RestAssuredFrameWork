package waysToCreateData;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class JsonObj 
{
	@Test
	
	public void jsonObj() 
	{
		JSONObject jObj = new JSONObject();//json simple
		jObj.put("createdBy", "Ratan TATA");
		jObj.put("projectName", "Altroz22");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 35);
		
		
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_802")
		.then()
			.assertThat().statusCode(200)
			.contentType(ContentType.JSON)
			.log().all();
	}

}
