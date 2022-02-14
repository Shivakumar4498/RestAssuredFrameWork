package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameters 
{
		@Test
		public void pathParameter()
		{
		given()
			.pathParam("projectId", "TY_PROJ_804")
		.when()
			.get("http://localhost:8084/projects/{projectId}")
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}

}
