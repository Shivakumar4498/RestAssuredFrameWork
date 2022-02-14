package practiceCRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectTest 
{
	@Test
	public void createProject()
	{
		 Random ran = new Random();
		 int randomNum = ran.nextInt(1000);
		
		JSONObject jObj = new JSONObject();//json simple
		jObj.put("createdBy", "Altroz");
		jObj.put("projectName", "TATA"+randomNum);
		jObj.put("status", "competed");
		jObj.put("teamSize", 1500);
	
		
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}
	

}
