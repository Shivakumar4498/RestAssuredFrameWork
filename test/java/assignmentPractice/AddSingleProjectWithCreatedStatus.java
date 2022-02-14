package assignmentPractice;

import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddSingleProjectWithCreatedStatus {

	
	@Test
	public void createproject() {
		//Step 1:  create data
		JSONObject jobj =new JSONObject();//json simple dependency
		jobj.put("createdBy","samsung");
		jobj.put("createdOn", "10/02/2022");
		//jobj.put("projectId", "string");
		jobj.put("projectName", "sam_s9");
		jobj.put("status", "Created");
		jobj.put("teamSize", 10);
		
		Object Matchers;
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201).time(((Object) Matchers).lessThan(3000L), TimeUnit.MILLISECONDS)
			.contentType(ContentType.JSON)
			.log().all();
		
	}
}
