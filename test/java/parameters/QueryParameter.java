package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter 
{
	@Test
	public void queryparm()
	{
		given()
			.queryParams("page", "2")
		.when()
			.get("https://reqres.in/api/users")
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}

}
