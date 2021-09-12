package org.yog.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yog.util.DbConnection;

/**
 * Servlet implementation class DemoJDBC
 */
@WebServlet("/DemoJDBC")
public class DemoJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String databaseURL = "jdbc:mysql://localhost:3306";
	private final String databaseUsername = "root";
	private final String databasePassword = "Jsr@30071987";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DemoJDBC() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*try {
			
			 * InputStream in = getServletContext().getResourceAsStream(
			 * "/jdbclab23/src/main/webapp/config.properties"); Properties props = new
			 * Properties(); props.load(in);
			 * 
			 * 
			 * Class.forName("com.mysql.jdbc.Driver");
			 * 
			 * Connection connection =
			 * DriverManager.getConnection(databaseURL,databaseUsername,databasePassword);
			 * // DBConnection conn = new DBConnection(props.getProperty("url"),
			 * props.getProperty("userid"), props.getProperty("password"));
			 * 
			 * Statement stmt = connection.createStatement();
			 * stmt.executeUpdate("CREATE DATABASE simplilearn;"); stmt.close();
			 * 
			 * 
			 * connection.close(); // conn.closeConnection(); PrintWriter printwriter =
			 * response.getWriter(); printwriter.println("Connection is good");
			 * 
			 * 
			 * Statement stmtdrp = connection.createStatement();
			 * stmtdrp.executeUpdate("DROP DATABASE simplilearn;"); stmt.close();
			 

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
		
		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
		
		Properties props = new Properties();
		props.load(in);
		
		try {
			DbConnection conn = new DbConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
		
			Statement stmt = conn.getConnection().createStatement();
			stmt.executeUpdate("CREATE DATABASE simplilearn");
			System.out.println("Create database");
			
			stmt.close();
			conn.closeConnection();
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}

}