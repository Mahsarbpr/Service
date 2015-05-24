<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Coupon</title>
</head>
<body>
	<div style="padding-left:100px;font-family: monospace;">
		<h2>Create Coupon</h2>
		<form action="http://localhost:8080/coupon-service/webapi/myresource/CreateCoupon" method="POST">
			<div style="width: 200px; text-align: left;">
				<div style="padding:10px;">
					Coupon ID: <input name="ID" />
				</div>
				<div style="padding:10px;">
					Coupon discount value: <input name="discount" />
				</div>
				<div style="padding:10px;">
					Coupon Type: <input name="type" />
				</div>
				<div style="padding:10px;text-align:center">
					<input type="submit" value="Submit" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>