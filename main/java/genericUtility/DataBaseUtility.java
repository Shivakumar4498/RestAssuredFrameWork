package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * this interface contains constant values
 * @author Shivakumar
 */

public class DataBaseUtility 
{
	Connection con = null;
	//Step 1 register the database
	//Step 2 get connection with DB
	//Step 3 issue craete Statement
	//Step 4 ExecuteQuery
	//Step 5 Colse Connection
	
	/**
	 * This method will establish connection with DataBase
	 * @throws Throwable
	 */
	
	public void connectToDB() throws Throwable
	{
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		con = DriverManager.getConnection(IConstant.dbURL, IConstant.dbUserName, IConstant.dbPassword);
	}
	/**
	 * this method will execute query and return the data present in database
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	
	public String executeQueryAndGetData(String query, int columnIndex, String expData) throws Throwable
	{
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String value = result.getString(columnIndex);
			if (value.equalsIgnoreCase(expData))
			{
				flag = true; //rising flag
				break;
			
			}
		}
		if(flag)
		{
			System.out.println(expData+" Data verified");
			return expData;
		}
		else
		{
			System.out.println("Data not present");
			return "";
		}
		
		/**
		 * 
		 */
		
		
	}
	public void CloseDB() throws Throwable
	{
		con.close();
	}

}
