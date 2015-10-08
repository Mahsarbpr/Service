 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ValidationCheck">
coupon ID: <input type="text" id="VC" name="VC" >
<input type="submit">
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
  <h2>Coupon Validation Check</h2>
  <form role="form" action="ValidationCheck">
    <div class="form-group">
      <label for="couponID">CouponID:</label>
      <input type="text" class="form-control" id="VC" name="VC" placeholder="Enter Coupon ID" value="${coid}">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
  <br></br>
  Coupon Status: <input type="text" class="form-control" id="Cstatus" name="Cstatus" value="${message}">
  <br></br>
  Expiration Time: <input type="text" class="form-control" id="expirationtime" name="expirationtime" value="${expiration}">
</div>

</body>
</html>
