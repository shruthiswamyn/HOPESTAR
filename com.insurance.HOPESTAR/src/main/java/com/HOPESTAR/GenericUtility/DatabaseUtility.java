package com.HOPESTAR.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.*;

public class DatabaseUtility {

	Connection con=null;
	Statement stat=null;
	ResultSet resultSet=null; 
	
	/**
	 * This methods esatblishes database connection
	 * @author Shruthi
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstantsUtility.dbURL, IPathConstantsUtility.dbUsername, IPathConstantsUtility.dbPassword);
	}
	
	/**
	 * This method executes query and gets data
	 * @author Shruthi
	 * @param query
	 * @param column
	 * @param expectedData
	 * @throws Throwable
	 */
	public void executeQueryAndGetData(String query, int column, String expectedData) throws Throwable
	{
		boolean flag=false;
		stat = con.createStatement();
		resultSet = stat.executeQuery(query);
		
		while(resultSet.next())
		{
			String actualData = resultSet.getString(column);
			if(actualData.equalsIgnoreCase(expectedData))
			{
				flag=true;
				System.out.println("Data is verified"+actualData);
				break;
			}
			else
			{
				System.out.println("Data not matching");
			}
		}
	}
	public void closeDB() throws Throwable
	{
		con.close();
	}
	
	
	
}
