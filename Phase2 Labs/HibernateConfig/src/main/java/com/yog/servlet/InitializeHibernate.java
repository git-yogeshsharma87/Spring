package com.yog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ecommerce.HibernateUtil;

/**
 * Servlet implementation class InitializeHibernate
 */
@WebServlet("/InitializeHibernate")
public class InitializeHibernate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitializeHibernate() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
	PrintWriter out = response.getWriter();
	
	out.println("<html><body>");
	
	SessionFactory factory = HibernateUtil.getSessionFactory();
	
	//org.hibernate.Session session = factory.openSession();
	Session session = factory.openSession();
	out.println("Hibernate session opened");
	
	session.close();
	out.println("Hibernate session closed");
	out.println("</body></html>");


	} catch(Exception ex) {
		throw ex;
	}
	}

}
