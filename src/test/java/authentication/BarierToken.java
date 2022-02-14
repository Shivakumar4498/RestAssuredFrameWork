package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BarierToken 
{
	@Test
	public void barierToken()
	{
		given()
			.auth().oauth2("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")
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}

}
