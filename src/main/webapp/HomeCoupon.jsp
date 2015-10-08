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
			/*background-image: url("/Peanuts.jpg") no-repeat center center fixed;*/
			/*background-image: url('../images/Peanuts.jpg'); */
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

	</style>

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3 panel panel-default">

				<h1 class="margin-base-vertical">Login</h1>
				<form role="form" class="margin-base-vertical" action="login" method="post">
					<p class="input-group">
						<span class="input-group-addon"></span>
						<input type="text" class="form-control input-lg" name="username" id="username" placeholder="Username" />
					</p>
					<p class="input-group">
						<span class="input-group-addon"></span>
						<input type="text" class="form-control input-lg" name="password" id="password" placeholder="Password" />
					</p>
					<p class="text-center">
						<button type="submit" class="btn btn-success btn-lg">Login</button>
					</p>
				</form>
			</div><!-- //main content -->
		</div><!-- //row -->
	</div> <!-- //container -->

</body>
</html>