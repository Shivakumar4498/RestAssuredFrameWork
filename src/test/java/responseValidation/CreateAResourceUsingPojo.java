package responseValidation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClass.PojoClass;

import static io.restassured.RestAssured.*;

public class CreateAResourceUsingPojo 
{
	@Test
	public void createResourceUsingPojo()
	
	{
		PojoClass pojo = new PojoClass("Shiva","Banglore","Completed",18);
		given()
			.body(pojo)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}

}
