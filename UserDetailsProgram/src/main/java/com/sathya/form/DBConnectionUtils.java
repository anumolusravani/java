package com.sathya.form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtils {
    //this method create the connection and return connection
	public static Connection createConnetion()
	{
		Connection connection = null;
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","harini","welcome");
			
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return connection;
		
	}
}
