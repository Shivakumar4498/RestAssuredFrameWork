package assignmentPractice;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;



public class ModifyProjectName 
{
	@Test
	
	public void update() 
	{
		//create of random number
				Random ran =new Random();
				int randomnumber = ran.nextInt(500);
				
				JSONObject jobj=new JSONObject();//json simple dependency
				jobj.put("createdBy","boss");
				
				//jobj.put("projectId", "string");
				jobj.put("projectName", "abc");
				jobj.put("status", "Created");
				jobj.put("teamSize", 10);
				
				given()
					.body(jobj)
					.contentType(ContentType.JSON)
				
				.when()
					.put("http://localhost:8084/projects/TY_PROJ_818")
				.then()
					.assertThat().statusCode(200)
					.log().all();		
			}

}
