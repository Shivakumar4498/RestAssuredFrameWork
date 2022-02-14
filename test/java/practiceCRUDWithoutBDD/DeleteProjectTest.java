package practiceCRUDWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest
{
	@Test
	public void deleteProject() 
	{	
		//Step 1
		int expstatus = 200;
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_403");
		
		//Step 2
				
		System.out.println(resp.prettyPrint());
		int actstatus = resp.getStatusCode();
		Assert.assertEquals(expstatus, actstatus);
	}

}
