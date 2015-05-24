<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  <!DOCTYPE html> -->
<html>
<head>
<title>Create Coupon</title>
</head>
<body>
	<div style="padding-left:100px;font-family: monospace;">
		<h2>Read Coupon</h2>
		<form action="http://localhost:8080/coupon-service/webapi/myresource/ReadCoupon" method="post">
			<div style="width: 200px; text-align: left;">
				<div style="padding:10px;">
					Coupon ID: <input name="ID" />
				</div>
				<div style="padding:10px;text-align:center">
					<input type="submit" value="Submit" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>