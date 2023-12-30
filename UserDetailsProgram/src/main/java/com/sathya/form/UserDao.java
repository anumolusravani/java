package com.sathya.form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	private static final PreparedStatement preparedStatement = null;
	public int saveUser(User user)
	{
		int result = 0;
		try(Connection connection = DBConnectionUtils.createConnetion())
		{
			PreparedStatement preparedStatement = connection.prepareStatement("insert into user_table values(?,?,?,?,?)");
			preparedStatement.setString(1, user.getUserId());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getUserEmail());
			preparedStatement.setString(4, user.getUserMobile());
			preparedStatement.setString(5, user.getUserLocation());
			result = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
 
	public User findById(String userId)
	{
		User user = null; 
		try(Connection connection = DBConnectionUtils.createConnetion())
		{
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user_table where userId=?");
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{	user = new User();
				user.setUserId(resultSet.getString(1));
				user.setUserName(resultSet.getString(2));
				user.setUserEmail(resultSet.getString(3));
				user.setUserMobile(resultSet.getString(4));
				user.setUserLocation(resultSet.getString(5));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public User login(String userName, String userEmail) {
	    User user = null;
	    try (Connection connection = DBConnectionUtils.createConnetion();
	         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user_table WHERE userName=? AND userEmail=?")) {

	        preparedStatement.setString(1, userName);
	        preparedStatement.setString(2, userEmail);
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                user = new User();
	                user.setUserId(resultSet.getString("userId"));
	                user.setUserName(resultSet.getString("userName"));
	                user.setUserEmail(resultSet.getString("userEmail"));
	                user.setUserMobile(resultSet.getString("userMobile"));
	                user.setUserLocation(resultSet.getString("userLocation"));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return user;
	}
	public List<User> findAll() 
	{
		List<User> users = new ArrayList<User>();
		User u = null;
		try(Connection connection = DBConnectionUtils.createConnetion())
		{
		  Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user_table");
			while(resultSet.next())
			{
				u = new User();
				u.setUserId(resultSet.getString(1));
				u.setUserName(resultSet.getString(2));
				u.setUserEmail(resultSet.getString(3));
				u.setUserMobile(resultSet.getString(4));
				u.setUserLocation(resultSet.getString(5));
				users.add(u);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return users;
	}
	public int deleteById(String userId)
	{
          int result = 0; 
		try(Connection connection = DBConnectionUtils.createConnetion())
		{
			PreparedStatement preparedStatement = connection.prepareStatement("delete from user_table where userId=?");
			preparedStatement.setString(1, userId);
			result = preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}