package responseValidation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicValidation 
{
	@Test
	public void dynamicValidation()
	{
		String expectedProjectName="Wellness Med Supply";
		Response response = when()
			.get("http://localhost:8084/projects");
		 List<String> projName = response.jsonPath().get("projectName");
		 boolean flag = false;
		 for(String pNames : projName)
		 {
			 try
			 {
			 if (pNames.equals(expectedProjectName))
			 {
				 flag=true;
			 }
			 }
			 catch (Exception e)
			 {
				 
			 }
		 }
		 response.then()
		 		.assertThat()
		 		.contentType(ContentType.JSON).and().statusCode(200)
		 		.log().all();
		 		Assert.assertEquals(flag, true);
	}

}
