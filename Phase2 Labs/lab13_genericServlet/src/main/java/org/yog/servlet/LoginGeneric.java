package org.yog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginGeneric implements Servlet {

	ServletConfig config;
	@Override
	public void destroy() {
		System.out.println("Servlet destroy");		
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
			System.out.println("Servlet init");		
			this.config=config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter out = res.getWriter();
	
		out.print("<html><body>");
		out.print(username);
		out.print("<br>");
		out.print(password);
		out.print("</body></html>");
		
		 Enumeration<?> paramNameEnum = getServletConfig().getInitParameterNames();
		  while (paramNameEnum.hasMoreElements()) {
		    String paramName = (String) paramNameEnum.nextElement();
		    	System.out.println(paramName);
	}

}
}
