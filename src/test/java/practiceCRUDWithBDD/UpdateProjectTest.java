package practiceCRUDWithBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest 
{
	
	@Test
	
	public void updateProject()
	{
		Random ran = new Random();
		 int randomNum = ran.nextInt(1000);
		
		JSONObject jObj = new JSONObject();//json simple
		jObj.put("created by", "Altroz");
		jObj.put("project name", "TATA"+randomNum);
		jObj.put("Status", "competed");
		jObj.put("teamSize", 1500);
		
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_802")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(200)
			.log().all();
	}

}
