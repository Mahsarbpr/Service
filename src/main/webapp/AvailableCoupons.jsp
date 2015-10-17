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
  <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
  <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>
<body>
<div class="container">
  <h2>Available Coupons for a certain date</h2>
  <form role="form" action="AvailableCoupons">
    <div class="form-group">
      <label for="Coupon Time">Available coupon for this time:</label>
      <input type="date" class="form-control" id="DT" name="DT" placeholder="Enter Date" value="${DT}">
    </div>                                       

<div class="form-element-left">
<label>Available Coupons of this Type:</label>
<select name="school_type" class="required" id="school_type">
  <option value="" disabled="disabled" selected="selected"></option>
  <option value="public">Public School</option>
  <option value="private">Private School</option>
  <option value="home">Home School</option>
  <option value="other">Other</option>
</select>
</div>

       
<div id="Pdiscount" class="form-element-right hidden">
<label for="Pdiscount">Please specify discount amount</label>
<input type="text" name="Pdiscount" id="Pdiscount" placeholder="Discount Amount" maxlength="200">
</div>
<div class="clear"></div> 
 
    <div class="form-group">
      <label for="Item Name">Available coupon for this item:</label>
      <input type="text" class="form-control" id="INC" name="INC" placeholder="Item name" value="${INC}">
    </div>
  <button type="submit" class="btn btn-default">Submit</button>
  <input type="text" class="form-control" id="ati1" name="ati1" value="${ati1}">
</form>
 </div>

</body>
</html>
    