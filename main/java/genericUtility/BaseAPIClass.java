package genericUtility;
/**
 * 
 * @author Shivakumar
 *
 */

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseAPIClass 
{
	
	public DataBaseUtility dLib = new DataBaseUtility();
	public JavaUtility jLib = new JavaUtility();
	public RestAssuredUtility rLib = new RestAssuredUtility();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		baseURI = "http://localhost";
		port = 8084;
		
		dLib.connectToDB();
		System.out.println("Database Connection established");
	}
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.CloseDB();
		
	}
	

}
