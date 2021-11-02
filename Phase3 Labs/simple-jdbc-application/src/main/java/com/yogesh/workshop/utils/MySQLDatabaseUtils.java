package com.yogesh.workshop.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLDatabaseUtils {

	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	
	String driverClassName = "com.mysql.cj.jdbc.Driver";
	Class.forName(driverClassName);
	String url = "jdbc:mysql://localhost:3306/studentdb?allowPublicKeyRetrieval=true&useSSL=false";
	String user = "root";
	String password = "Jsr@30071987";
	
	Connection connection = DriverManager.getConnection(url,user,password);
	
	return connection;
	
	
}

	
}