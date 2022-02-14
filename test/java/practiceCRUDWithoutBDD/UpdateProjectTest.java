package practiceCRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest 
{
	@Test
	public void updateProject()
	{
		//Step 1 Create JSON data
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Rahul");
		jObj.put("projectName", "KIA");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 155);
		
		//Step 2 
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj);
		
		//Step 3
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_403");
		
		//Step 4 Print in console And verify
		ValidatableResponse validate = resp.then();
		validate.assertThat().statusCode(200);
		validate.log().all();
	}

}
