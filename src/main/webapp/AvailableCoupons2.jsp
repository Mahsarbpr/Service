<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
import java.sql.Date;
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.coupon.Coupon" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.ListIterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
 try{
 List<Coupon> eList = new LinkedList<Coupon>();
 eList = (List<Coupon>)request.getAttribute("Avcoupons"); 
 out.println("<table>");	
 while(eList.iterator().hasNext())
 {
	 Coupon c=new Coupon();
	 c=(Coupon)eList.iterator().next();
	 out.print("<tr>");
	 	out.print("<tr>"+c.CouponID+"</tr>");
	 	out.print("<tr>"+c.Discount+"</tr>");
	 	out.print("<tr>"+c.ItemID+"</tr>");
	 	out.print("<tr>"+c.Itemname+"</tr>");
	 	out.print("<tr>"+c.getValidTime1()+"</tr>");
	 	out.print("<tr>"+c.getValidTime2()+"</tr>");
	 	out.print("</tr>");	 
 }
 out.println("</table>");
 }
 catch(Exception e)
 {
	 System.out.println("Error");
 }
 	%>
</body>
</html>