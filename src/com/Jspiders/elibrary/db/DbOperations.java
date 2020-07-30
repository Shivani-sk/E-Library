package com.Jspiders.elibrary.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DbOperations 
{
	public static Connection giveConnection()
	{
		Connection con = null;

		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			String dburl="jdbc:mysql://localhost:3360/elibrary?user=root&password=root";
			con=DriverManager.getConnection(dburl);
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return con;
	}
}
