<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>401 - Access Denied</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body style="background-color: #FF1744;">
	<div class="page">
		<div class="block">
			<h1>Error 401: Access Denied</h1>
			<p>Please, choose one of the following:</p>
			<br>
			<form class="forms" action="ActMenuController">
				<input class="btn btn-default" type="submit" value="Action Menu" />
			</form>
			<form class="forms" action="Logout">
				<input class="btn btn-default" type="submit" value="Logout" />
			</form>
		</div>
	</div>
</body>
</html>