package org.yogesh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,String> cred = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		cred.put("Tom","Jerry");
		cred.put("Yog","San");
		cred.put("Tim","Cook");
		cred.put("Harry","potter");
		cred.put("Welcome","Welcome@123");
		cred.put("Test11","Test1121");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		RequestDispatcher rd = null;
		
		//if(username.equalsIgnoreCase("tom") && password.equals("jerry")) {
		if (cred.containsKey(username) && cred.get(username).equals(password)) {
			rd=request.getRequestDispatcher("SuccessServlet");
			rd.forward(request, response);
		
		} else {
			rd=request.getRequestDispatcher("login.html");
			PrintWriter out = response.getWriter();
			rd.include(request, response);
			out.println("<center><span style = 'color:red'> Invalid Credentials!!</span></center>");

			
		}
		
	}

}
