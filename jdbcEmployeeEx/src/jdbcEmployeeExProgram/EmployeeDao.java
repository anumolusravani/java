package jdbcEmployeeExProgram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	public int createEmployeeTable()
	{
		Connection connection = null;
		Statement statement = null;
		int result = 0;
		try
		{
			connection = DataBaseConnectionUtils.createConnetion();
			statement = connection.createStatement();
			result = statement.executeUpdate("create table emp_info(eId varchar2(10) primary key,eName varchar2(20),eSalary number)");
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
			     if(connection != null) connection.close();
			     if(statement != null) statement.close();
			     }
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
  public int SaveEmployee(Employee e1)
  {
	   int result =0;
	   try(Connection connection = DataBaseConnectionUtils.createConnetion())
	   {
		   // create the ps object with params
		   PreparedStatement preparedStatement = connection.prepareStatement("insert into emp_info values(?,?,?)");
		   //set the data to params
		   preparedStatement.setString(1, e1.geteId());
		   preparedStatement.setString(2, e1.geteName());
		   preparedStatement.setDouble(3, e1.geteSalary());
		   //execute the query
		   result = preparedStatement.executeUpdate();
		   
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
	   }
	   return result;
  }

public Employee findById(String eId)
  {
	   Employee e1 = null;
	   try(Connection connection = DataBaseConnectionUtils.createConnetion())
	   {
		   PreparedStatement preparedStatement = connection.prepareStatement("select * from emp_info where eId=?");
		   //set the data to params
		   preparedStatement.setString(1, eId);
		   //execute the query
		   ResultSet resultSet = preparedStatement.executeQuery();
		   if(resultSet.next())
		   {
			   //read the data from resultset and setting to employee
			   e1 = new Employee();
			   e1.seteId(resultSet.getString(1));
			   e1.seteName(resultSet.getString(2));
			   e1.seteSalary(resultSet.getDouble(3));
			   
		   }
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
	   }
	   return e1;
   }   
public List<Employee>findAll()
{
	List<Employee> employees = new ArrayList<Employee>();
	Employee e1 = null;
	try(Connection connection = DataBaseConnectionUtils.createConnetion())
	{
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from emp_info");
		while(resultSet.next())
		{

			   //read the data from resultset and setting to employee
			   e1 = new Employee();
			   e1.seteId(resultSet.getString(1));
			   e1.seteName(resultSet.getString(2));
			   e1.seteSalary(resultSet.getDouble(3));
			   //adding the employee into list
			   employees.add(e1);
		}
	}
	catch(SQLException e)
	{ 
		e.printStackTrace();
	}
	return employees;
}
  public int UpdateEmployee(double salary,double incSalary)
  {
	  int result = 0;
	  try(Connection connection = DataBaseConnectionUtils.createConnetion())
	  {
		  PreparedStatement preparedStatement = connection.prepareStatement("update emp_info set eSalary=eSalary+? where eSalary>?");
		  preparedStatement.setDouble(1, incSalary);
		  preparedStatement.setDouble(2, salary);
		  result = preparedStatement.executeUpdate();
	  }
	  catch(SQLException e)
	  {
		  e.printStackTrace();
	  }
	  return result;
  }
  public int deleteEmployeeById(String eId)
  {
	  int result = 0;
	  try(Connection connection = DataBaseConnectionUtils.createConnetion())
	  {
		  PreparedStatement preparedStatement = connection.prepareStatement("delete from emp_info where eid=?");
		  preparedStatement.setString(1, eId);
		  result = preparedStatement.executeUpdate();
      }
	  catch(SQLException e)
	  {
		  e.printStackTrace();
	   }
	  return result;
  }
  public int deleteEmployeeBySalary(double eSalary)
  {
	  int result = 0;
	  try(Connection connection = DataBaseConnectionUtils.createConnetion())
	  {
		  PreparedStatement preparedStatement = connection.prepareStatement("delete from emp_info where eSalary=?");
		  preparedStatement.setDouble(1, eSalary);
		  result = preparedStatement.executeUpdate();
      }
	  catch(SQLException e)
	  {
		  e.printStackTrace();
	   }
	  return result;
  }
  public int DropTable()
  {
	  int result = 0;
	  try(Connection connection = DataBaseConnectionUtils.createConnetion())
	  {
		  Statement statement = connection.createStatement();
		  result = statement.executeUpdate("drop table emp_info");
	  }
	  catch(SQLException e)
	  {
		  e.printStackTrace();
	  }
      return result;
  }
}
