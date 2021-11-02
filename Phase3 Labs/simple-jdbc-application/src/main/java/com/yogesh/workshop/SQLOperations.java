package com.yogesh.workshop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.yogesh.workshop.utils.MySQLDatabaseUtils;

public class SQLOperations {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		findthenumberofcustomers();
		displayallcustomers();
	}

	
	private static void displayallcustomers() throws ClassNotFoundException, SQLException {
		Connection connection = MySQLDatabaseUtils.getConnection();
		System.out.println("obtained a databse connection");
		
		String sql = "SELECT * from studentdb.customers";
		//statement 
		
		Statement statement = connection.createStatement();
		
		//resultset 
		
		ResultSet resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) {
			System.out.println(resultSet.getString("name"));
		}
		
		//close 
		
				resultSet.close();
				statement.close();
				connection.close();
	}


	private static void findthenumberofcustomers() throws ClassNotFoundException,SQLException {
		
		Connection connection = MySQLDatabaseUtils.getConnection();
		System.out.println("obtained a databse connection");
		
		String sql = "SELECT count(*) from studentdb.customers";
		//statement 
		
		Statement statement = connection.createStatement();
		
		//resultset 
		
		ResultSet resultSet = statement.executeQuery(sql);
		
		resultSet.next();
	
		System.out.println("the number of occurance "+ resultSet.getInt(1));
		
		//close 
		
		resultSet.close();
		statement.close();
		connection.close();
		
	}
}
