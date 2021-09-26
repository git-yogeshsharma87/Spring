package com.yog.servlet;

import com.ecommerce.HibernateUtil;
import com.yog.shop.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet implementation class NewProduct
 */
@WebServlet("/NewProduct")
public class NewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewProduct() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name ="Phone";
		double price = 170;
		
	/*	
		Product p1 = new Product (name,price);
		
		
		ProductImage img1 = new ProductImage("a.jpg",p1);
	//	ProductImage img2 = new ProductImage("b.jpg;");
		
	/*
	 * img1.setProduct(p1); img2.setProduct(p1);
	 * 
	 * 
	 * images.add(img1); images.add(img2);
	 * 
	 * p1.setImages(images);
	 */
		
//		List<ProductImageMeta> imagesMeta = new ArrayList<ProductImageMeta>();

		//ProductImage pi1 = new ProductImage;
	//	ProductImageMeta height1 = new ProductImageMeta("height","200",img1);
		//ProductImageMeta imgm2 = new ProductImageMeta("height","100");
		/*
		//img1.addImageMeta(new ProductImageMeta("height","200",img1));
		//p1.addImage(img1); */
		
		/*
		 * imgm1.setProductImg(img1); imgm2.setProductImg(img1);
		 * 
		 * imagesMeta.add(imgm1); imagesMeta.add(imgm2);
		 */
		
		//ProductImageMeta imgm2 = new ProductImageMeta("Meta2");
				
		//img1.setImagesMeta(imagesMeta);
		
		//SessionFactory factory = HibernateUtil.getSessionFactory();
		
		//org.hibernate.Session session = factory.openSession();
		//Session session = factory.openSession();
		
		//Session session = HibernateUtil.getSessionFactory().openSession();
		//Transaction trans = session.beginTransaction();
		
		//session.save(p1);
		
	//	trans.commit();
		//session.close();
	//	*/
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Address address = new Address ("First St", "Florida","FLorida", "45678");
		
		Account account = new Account ("name", "pass");
		User user = new User("John", "Doe",address,account);
		
				session.save(user);
				transaction.commit();
				session.close();
		PrintWriter out = response.getWriter();
		 out.println("<html><body>Done ! </body></html>");

		
	}

	
}
