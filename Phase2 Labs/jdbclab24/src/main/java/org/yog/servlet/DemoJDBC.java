package org.yog.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");

		Properties props = new Properties();
		props.load(in);

		try {
			DbConnection conn = new DbConnection(props.getProperty("url"), props.getProperty("userid"),
					props.getProperty("password"));

			Statement stmt = conn.getConnection().createStatement();

			String name = "Ford";
			String price = "128.85";

			stmt.executeUpdate("insert into product (name,price,date_added) values ('" + name + "," + price + ",now()");

			/*
			 * ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY
			 * 
			 * ); ResultSet rSet = stmt.executeQuery("select * from eproduct where pid>=4");
			 * 
			 * while(rSet.next()) { System.out.println(rSet.next());
			 * 
			 * }
			 */

			stmt.close();
			conn.closeConnection();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}