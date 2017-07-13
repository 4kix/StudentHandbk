<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body style="background-color: #18BC9C">
	<div class="page">
		<div class="wrapper">

			<form class="form-signin shadowed" action="AuthController"
				method="post">
				<h3 class="form-signin-heading">Please login:</h3>
				<input type="text" class="form-control" placeholder="Username"
					name="login" value="" required=""> 
				<input type="password"
					class="form-control" placeholder="Password" name="password"
					value="" required=""> 
					<br> 
				<input
					class="btn btn-lg btn-primary btn-block" type="submit" name="ok"
					value="Login" /> <br>

				<p style="color: red">${errorMessage}</p>
			</form>
		</div>
	</div>

</body>
</html>