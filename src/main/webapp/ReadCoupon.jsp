<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Enter coupon ID you want to Read:<INPUT TYPE="TEXT" NAME="read">
<br><br>
<form action="searchDB" method="Post">
    <input type="submit" value="search Web Service">
    <br><br>
</form>
showing coupon information
<br><br>
<form action="HomeCoupon.jsp" method="Post">
    <input type="submit" value="back to Home">
    <br><br>
</form>
</body>
</html>