package practiceCRUDWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProjectTest 
{
	@Test
	public void getSingleProject()
	{
		//Step 1 Get Single Project
		int expecstatus = 200;
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_404");

		
		//Step 2 print in console & verify
		System.out.println(resp.prettyPeek());
		int actstatus = resp.getStatusCode();
		Assert.assertEquals(expecstatus, actstatus);
		
	}

}
