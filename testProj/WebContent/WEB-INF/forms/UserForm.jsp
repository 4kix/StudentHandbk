<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Form</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="page">
    <form class="forms" action="UserListController">
    	<input class="btn" type="submit" value="Back" />
	</form>
	<form class="forms" action="Logout">
    	<input class="btn" type="submit" value="Logout" />
	</form>
<div class="block">
	<h3>User info</h3>
		
	<form class="form-horizontal" action="UserSaveController" method="post">
	<div class="form-group">
		<label for="user" class="col-sm-2 control-label"> User: </label>
		<div class="col-sm-10">
			<Input class="form-control"  type="text" name="username" value="${username}">
		</div>
	</div>
	<div class="form-group">
			<label for="password" class="col-sm-2 control-label"> Password: </label>
			<div class="col-sm-10">
				<Input class="form-control" type="text" name="password" value="${password}">
			</div>
	</div>	
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label"> Role: </label>
			<div class="col-sm-10">
				<Input class="form-control" type="text" name="role" value="${role}">
			</div>
		</div>
		<br>
		<br>		
			<input class="btn btn-success" type="submit" value="Save" />
			<input class="btn btn-danger" formaction="UserDelController" type="submit" value="Delete" />
			
			<input type="hidden" name="action" value="${action}">
	</form>
		<p style = "color: red">${msg}</p>
		
</div>
</div>
</body>
</html>