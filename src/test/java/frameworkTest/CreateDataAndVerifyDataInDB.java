package frameworkTest;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericUtility.BaseAPIClass;
import genericUtility.EndPonits;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import pojoClass.PojoClass;

public class CreateDataAndVerifyDataInDB extends BaseAPIClass{
	
	@Test
	public void createData() throws Throwable
	{
		//Step 1 Create Test Data
		PojoClass pojo = new PojoClass("Rahul", "KIA", "Completed", 5);
		
		//Step 2 execute post request
		Response response = given()
							.body(pojo)
							.contentType(ContentType.JSON)
							.when()
							.post(EndPonits.createProjects);
		//Step 3 Capture the project Id and response
		String expData = rLib.getJSONData(response, "projectID");
		System.out.println(expData);
		
		//Step 4 verify in DB
		String query = "select * from project;";
		String actData = dLib.executeQueryAndGetData(query, 1, expData);
		Reporter.log(actData, true);
		
		//Step 5 Validate
		Assert.assertEquals(expData, actData);
		Reporter.log("Data Verification Successful", true);
	}

}
