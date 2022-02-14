package genericUtility;

import io.restassured.response.Response;

/**
 * this class contains generic methods specific to rest assure
 * @author Shivakumar
 */

public class RestAssuredUtility 
{
	
	/**
	 * this method will return the json data for the json path specified
	 * @param resp
	 * @param jsonpath
	 * @return
	 */
public String getJSONData(Response resp, String jsonpath)
{
	String jsonData = resp.jsonPath().get(jsonpath);
	return jsonData;
	
}

}
