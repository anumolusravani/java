package com.sathya.product;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	public int saveProduct(Product product) {
		int result=0;
		try (Connection connection=DBConnectionUtils.createConnetion();){
			PreparedStatement preparedStatement=connection.prepareStatement("insert into Product_info values(?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, product.getProId());
			preparedStatement.setString(2, product.getProName());
			preparedStatement.setDouble(3, product.getProPrice());
			preparedStatement.setString(4, product.getProBrand());
			preparedStatement.setString(5, product.getProMadeIn());
			preparedStatement.setDate(6, product.getProMfgDate());
			preparedStatement.setDate(7, product.getProExpDate());
			preparedStatement .setBinaryStream(8, product.getProImage());
			 result=preparedStatement.executeUpdate();
	
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Product>findAll()
	{
		List<Product> product = new ArrayList<Product>();
	
		try(Connection connection = DBConnectionUtils.createConnetion())
		{
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Product_info");
			while(resultSet.next())
			{
				Product pp = new Product();
				pp.setProId(resultSet.getString("proId"));
				pp.setProName(resultSet.getString("proName"));
				pp.setProPrice(Double.parseDouble(resultSet.getString("proPrice")));
				pp.setProBrand(resultSet.getString("proBrand"));
				pp.setProMadeIn(resultSet.getString("proMadeIn"));
				pp.setProMfgDate(resultSet.getDate("proMfgDate"));
				pp.setProExpDate(resultSet.getDate("proExpDate"));
				
				pp.setReadImage(resultSet.getBytes("proImage"));
			       product.add(pp);
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return product;
	}
	public int deleteById(String proId)
	{
		int result = 0;
		try(Connection connection = DBConnectionUtils.createConnetion())
		{
			PreparedStatement preparedStatement = connection.prepareStatement("delete from Product_info where proId=?");
			//set the data to parms
			preparedStatement.setString(1, proId);
			result = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public Product findById(String proId) {
		Product p = null;
		try(Connection connection = DBConnectionUtils.createConnetion())
		{
			//create the ps object
			PreparedStatement preparedStatement = connection.prepareStatement("select * from  Product_info where proId=?");
			//set the data to params
			preparedStatement.setString(1, proId);
			//execute the query
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				 p = new Product();
				p.setProId(resultSet.getString("proId"));
				p.setProName(resultSet.getString("proName"));
				p.setProPrice(Double.parseDouble(resultSet.getString("proPrice")));
				p.setProBrand(resultSet.getString("proBrand"));
				p.setProMadeIn(resultSet.getString("proMadeIn"));
				p.setProMfgDate(resultSet.getDate("proMfgDate"));
				p.setProExpDate(resultSet.getDate("proExpDate"));
				
				p.setReadImage(resultSet.getBytes("proImage"));
			      				
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return p;
	}

	public int updateProduct(Product updatedProduct) {
	    int result = 0;
    try(Connection connection = DBConnectionUtils.createConnetion())
    {
    	int parameterIndex = 1;
         // SQL query to update product details
    	 String sql = "UPDATE Product_info SET proName=?, proPrice=?, proBrand=?, proMadeIn=?, " +
                 "proMfgDate=?, proExpDate=?" +
                 (updatedProduct.getProImage() != null ? ", proImage=?" : "") +
                 " WHERE proId=?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // Set the parameters for the update statement
        preparedStatement.setString(parameterIndex++, updatedProduct.getProName());
        preparedStatement.setDouble(parameterIndex++, updatedProduct.getProPrice());
        preparedStatement.setString(parameterIndex++, updatedProduct.getProBrand());
        preparedStatement.setString(parameterIndex++, updatedProduct.getProMadeIn());
        preparedStatement.setDate(parameterIndex++, updatedProduct.getProMfgDate());
        preparedStatement.setDate(parameterIndex++, updatedProduct.getProExpDate());
        
        if ( updatedProduct.getProImage() != null) {
            preparedStatement.setBinaryStream(parameterIndex++, updatedProduct.getProImage());
        }
        
        preparedStatement.setString(parameterIndex++, updatedProduct.getProId());

            // Execute the update
            result = preparedStatement.executeUpdate();
        }
     catch (SQLException e) {
        e.printStackTrace();
    } 
    return result;
	    }

	
}