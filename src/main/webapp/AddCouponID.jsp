<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Add Single Coupon</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Coupon Information</h2>
  <form role="form" action="http://localhost:8080/coupon-service/webapi/myresource/CreateCouponID" method="POST">
    <div class="form-group">
      <label for="var">CouponID:</label>
      <input type="text" class="form-control" id="var" name="var" placeholder="Enter Coupon ID">
    </div>
  <button type="submit" class="btn btn-default">Submit</button>
  </form>
 </div></body>
</html>