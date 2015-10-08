<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="rcservlet">
		<h2>Read Coupon</h2>
				<div style="padding:10px;">
					Coupon ID: <input name="ID" />
				</div>
				<div style="padding:10px;text-align:center">
					<input type="submit" value="Submit" />
				</div>
	</form>
</body>
</html> -->

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
  <h2>Coupon Information</h2>
  <form role="form" action="rcservlet">
    <div class="form-group">
      <label for="couponID">CouponID:</label>
      <input type="text" class="form-control" id="ID" name="ID" placeholder="Enter Coupon ID" value="${id}">
    </div>
  <button type="submit" class="btn btn-default">Submit</button>
  <br></br>
  Item name: <input type="text" class="form-control" id="in" name="in" value="${in}">
  <br></br>
  Coupon start time: <input type="text" class="form-control" id="ti1" name="ti1" value="${ti1}">
  <br></br>
  Coupon expiration time: <input type="text" class="form-control" id="ti2" name="ti2" value="${ti2}">
  </form>
 </div>

</body>
</html>
