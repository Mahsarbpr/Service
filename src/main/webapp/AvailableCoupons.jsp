<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.coupon.Coupon" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.ListIterator" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Available Coupons for a certain date</h2>
  <form role="form" action="AvailableCoupons">
    <div class="form-group">
      <label for="couponID">CouponID:</label>
      <input type="date" class="form-control" id="DT" name="DT" placeholder="Enter Date" value="${DT}">
    </div>
  <button type="submit" class="btn btn-default">Submit</button>
  <input type="text" class="form-control" id="ati1" name="ati1" value="${ati1}">
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
</form>
 </div>

</body>
</html>
    