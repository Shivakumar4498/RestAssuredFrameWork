package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParametersTest 
{
	@Test
public void parameter()

{
		given()
			.pathParam("username", "Lindsay")
			.queryParam("sort", "created")
			.queryParam("per_Page", "85")
		.when()
			.get("https://api.github.com/users/{username}/repos")
		.then()
			.assertThat().statusCode(200)
			.log().all();
}
}
