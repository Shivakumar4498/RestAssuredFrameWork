package practiceCRUDWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class GetAllProjectsTest 
{
	@Test
	public void getAllProjects()
	{
		//Step 1 
		int expstatus = 200;
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		//Step 2 print in console and verify
		System.out.println(resp.prettyPeek());
		int actstatus = resp.getStatusCode();
		Assert.assertEquals(expstatus, actstatus);
	}

}
