<!DOCTYPE html>
<html>
<head>
	<title>Bootstrap In Practice - Landing Page Example</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<!-- Bootstrap -->
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
	<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet" />

	<link href="http://fonts.googleapis.com/css?family=Abel|Open+Sans:400,600" rel="stylesheet" />

	<style>

		/* http://css-tricks.com/perfect-full-page-background-image/ */
		html {
			/*background: url("/Peanuts.jpg") no-repeat center center fixed; */
			background-image: url('http://localhost:8080/coupon-service/Coupons.jpg');
			-webkit-background-size: cover;
			-moz-background-size: cover;
			-o-background-size: cover;
			background-size: cover;
		}

		body {
			padding-top: 20px;
			font-size: 16px;
			font-family: "Open Sans",serif;
			background: transparent;
		}

		h1 {
			font-family: "Abel", Arial, sans-serif;
			font-weight: 400;
			font-size: 40px;
		}

		/* Override B3 .panel adding a subtly transparent background */
		.panel {
			background-color: rgba(255, 255, 255, 0.9);
		}

		.margin-base-vertical {
			margin: 40px 0;
		}
		.custom {
    		width: 400px !important;
		}
	</style>

</head>
<body>
<div class="container">
<div class="row">
<div class="col-md-6 col-md-offset-3 panel panel-default">
<h1 class="margin-base-vertical">Admin Page:</h1>
	
	<form role="form" action="ReadCoupon.jsp" method="Post">
    <p class="text-center">
    <input type="submit" class="btn-success btn-lg custom" value="Read Coupon">
	</p>
	</form>
	
	<form role="form" action="validation.jsp" method="Post">
    <p class="text-center">
    <input type="submit" class="btn btn-success btn-lg custom" value="Check Coupon Validation">
	</p>
	</form>
	
	<form role="form" action="Cart1.jsp" method="Post">
    <p class="text-center">
    <input type="submit" class="btn-success btn-lg custom" value="Compute final Price">
	</p>
	</form>
	
	<form role="form" action="AvailableCoupons.jsp" method="Post">
    <p class="text-center">
    <input type="submit" class="btn-success btn-lg custom" value="Check for Available coupons">
	</p>
	</form>
	
	<form role="form" action="AddCoupon.jsp" method="Post">
    <p class="text-center">
    <input type="submit" class="btn-success btn-lg custom" value="Add Coupon">
    </p>
	</form>
	
	<form role="form" action="UploadCouponPackage.jsp" method="Post">
    <p class="text-center">
    <input type="submit" class="btn-success btn-lg custom" value="Upload Coupon Package">
	</p>
	</form>
	
	<form role="form" action="UpdateCoupon.jsp" method="Post">
 	<p class="text-center">
 	<input type="submit" class="btn-success btn-lg custom" value="Update Coupon">
	</p>
	</form>
	
	<form role="form" action="DeleteCoupon.jsp" method="Post">
 	<p class="text-center">
 	<input type="submit" class="btn-success btn-lg custom" value="Delete Coupon">
	</p>
	</form>
</div><!-- //main content -->
</div><!-- //row -->
</div> <!-- //container -->
</body>
</html>