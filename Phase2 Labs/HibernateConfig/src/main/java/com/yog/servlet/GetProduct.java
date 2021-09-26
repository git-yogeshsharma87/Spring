package com.yog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;

import org.hibernate.Session;

import com.ecommerce.HibernateUtil;
import com.yog.shop.Product;

import javassist.tools.rmi.ObjectNotFoundException;

/**
 * Servlet implementation class GetProduct
 */
@WebServlet("/GetProduct")
public class GetProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
		Product p = session.load(Product.class, 1);
		
		System.out.println(p.getName());
		System.out.println(p.getPrice());
		
		p.setName("Tablet");
		p.setPrice(790);
		
		org.hibernate.Transaction tr = session.beginTransaction();
		
		session.save(p);
				
		//session.delete(p);
				
		
		tr.commit();
		
		}catch (org.hibernate.ObjectNotFoundException e){
			System.out.println("Row not Found");
			
		}
		
		session.close();
		
	}

	

}
