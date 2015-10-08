<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Cart1</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Compute Price</h2>
<form role="form" action="CP">
<div class="form-group">
<label for="Item 1"> Item 1:</label>
<input type="text" class="form-control" name="itm1" value="${itm1}">
<label for="Price1"> Price1:</label>
<input type="text" class="form-control" name="pitm1" value="${pitm1}">
<br></br>
<br></br>
</div>
<div class="form-group">
 <label for="Item 2"> Item 2:</label>
<input type="text" class="form-control" name="itm2" value="${itm2}">
<label for="Price"> Price</label>
<input type="text" class="form-control" name="pitm2" value="${pitm2}">
  <br>
  <br>
  </div>
<div>
<button type="submit" class="btn btn-default">Submit</button>
</div>
<div class="form-group">
 <label for="TotalPrice"> Total Price:</label>
<input type="text" class="form-control" name="tp" value="${tp}">
  </div>
</form>
</div>
</body>
</html>