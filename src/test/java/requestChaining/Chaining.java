package requestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Chaining 
{
	@Test
	public void chaining()
	
	{
		Response response = when()
				.get("http://localhost:8084/projects");
			String proId = response.jsonPath().get("[1].projectId");
			System.out.println(proId);	
		
		given()
			.pathParam("projectId", proId)
		.when()
		.then()
			.assertThat().statusCode(204)
			.log().all();
			}

}