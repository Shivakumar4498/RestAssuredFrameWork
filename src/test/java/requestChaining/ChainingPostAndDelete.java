package requestChaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.PojoClass;

import static io.restassured.RestAssured.*;

public class ChainingPostAndDelete 
{
	@Test
	public void postAndDelete()
	{
		PojoClass pojo = new PojoClass("virat","india_captain","completed",11);
		given()
			.body(pojo)
			.contentType(ContentType.JSON);
			
			/*Response response = when()
			.post("http://localhost:8084/projects");
		String proId = response.jsonPath().get("[1].projectId");
		System.out.println(proId);	*/
	
	given()
		.pathParam("projectId", proId)
	.when()
		.delete("http://localhost:8084/projects/{projectId}")
	.then()
		.assertThat().statusCode(204)
		.log().all();
		
	}

}
