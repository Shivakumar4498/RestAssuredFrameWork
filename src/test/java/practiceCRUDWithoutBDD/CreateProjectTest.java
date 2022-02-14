package practiceCRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	@Test
	public void createproject()
	{
		//Step 1 create test data
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Shivakumar");
		jObj.put("projectName", "Wellness Med Supply");
		jObj.put("status", "Created");
		jObj.put("teamSize", 8);
		
		//Step 2 Provide request spesification
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj);
		
		//Step 3 Perform Action
		Response resp = req.post("http://localhost:8084/addProject");
		
		//Step 4 Print in Consloe and verify
		
		System.out.println(resp.asPrettyString());
		System.out.println(resp.prettyPeek());
		System.out.println(resp.prettyPrint());
	}
	

}
