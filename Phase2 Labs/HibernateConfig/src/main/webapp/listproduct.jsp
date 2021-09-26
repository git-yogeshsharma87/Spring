<%@ page import= "org.hibernate.Session" %>
<%@ page import= "org.hibernate.Criteria" %>
<%@ page import= "javax.persistence.criteria.CriteriaBuilder" %>
<%@ page import= "javax.persistence.criteria.CriteriaQuery" %>
<%@ page import= "javax.persistence.criteria.Root" %>
<%@ page import= "org.hibernate.criterion.Restrictions" %>
<%@ page import= "org.hibernate.Session" %>


<%@ page import= "com.ecommerce.HibernateUtil" %>
<%@ page import= "com.yog.shop.Product" %>
<%@ page import= "java.util.List" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



 <table border = "1" width = "100%">
 <tr>
	 <td> Item Id </td>
 	<td> Item Name </td>
 	<td> Item Price </td>
 	<td> Item Action </td>
 
 
 </tr>
 
<%

Session se = HibernateUtil.getSessionFactory().openSession();

CriteriaBuilder cb = se.getCriteriaBuilder();
CriteriaQuery<Product> cr = cb.createQuery(Product.class);

Root<Product> root = cr.from(Product.class);

cr.select(root).where(cb.ge(root.get("price"), (double) 200));

org.hibernate.Query<Product> query = se.createQuery(cr);
List<Product> products  = query.getResultList();


for ( Product p : products) {


%>

	
	
	 <tr>
	 <td><%=p.getProductId() %></td>
	 <td><%=p.getName() %></td>
	 <td><%=p.getPrice() %></td>
 <td>
 <a href = "delete?pid=<%=p.getProductId() %>"> Delete </a>
 
  <a href = "update.jsp?pid=<%=p.getProductId() %>"> Update </a>
 
 </td>
 </tr>
 
<%
}
se.close();

%>

 
 
 </table>

</body>
</html>