<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Coupon ID:<INPUT TYPE="TEXT" NAME="ID">
<br><br>
Promotion code:<INPUT TYPE="TEXT" NAME="promotion">
<br><br>
Valid Time:<INPUT TYPE="TEXT" NAME="time">
<br><br>
Type:<INPUT TYPE="TEXT" NAME="type">
<br><br>
<form action="savetoDB" method="Post">
    <input type="submit" value="Add to Web Service">
    <br><br>
</form>
</body>
</html>