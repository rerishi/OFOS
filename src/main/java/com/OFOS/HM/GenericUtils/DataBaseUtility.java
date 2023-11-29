package com.OFOS.HM.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
	Connection con=null;
	
	public void connectDB() throws SQLException
	{
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		con=DriverManager.getConnection(IPathConstants.DBURL, IPathConstants.DB_Username, IPathConstants.DB_Password);
		
	}
	
	public String executeAndUpdateQuery(String colData, String expData, String query) throws SQLException
	{
		Statement state = con.createStatement();
		//String query="Select * from student_info;";
		ResultSet result=state.executeQuery(query);
		boolean flag=false;
		
		while(result.next())
		{
			String actual=result.getString(colData);
			
			if(actual.equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Project Created Successfully");
			return expData;
		}
		else
		{
			System.out.println("Project is not Created");
			
			return "";
		}
		
	}
	
	public void disconnectDB() throws SQLException
	{
		con.close();
	}

}
