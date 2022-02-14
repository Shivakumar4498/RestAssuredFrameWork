package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Auth2
{
	@Test
	public void auth()
	{
		Response response = given()
			.formParams("client_id", "kolivada")
			.formParams("client_secret", "bcb8925fb5f89c2cfb5a58a6d6772a89")
			.formParams("grant_type", "client_credentials")
			.formParams("redirect_uri", "https://example.com")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
			String token = response.jsonPath().get("access_token");
			
		given()
			.auth().oauth2(token)
			.pathParam("USER_ID", "2784")
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then()
			.log().all();
		

	}

}
