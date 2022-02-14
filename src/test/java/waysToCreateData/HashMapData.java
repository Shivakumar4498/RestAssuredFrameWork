package waysToCreateData;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class HashMapData 
{
	@Test
	public void hashMap()
	{
		
	HashMap map = new HashMap();
	map.put("createdBy", "Mohan Gowda");
	map.put("projectName", "Gowda");
	map.put("status", "Completed");
	
	given()
		.body(map)
		.contentType(ContentType.JSON)
	
	.when()
		.post("http://localhost:8084/addProject")
		
	.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	
	}

}
